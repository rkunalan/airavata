/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/
package org.apache.airavata.gfac.impl;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import org.apache.airavata.common.exception.AiravataException;
import org.apache.airavata.gfac.core.JobManagerConfiguration;
import org.apache.airavata.gfac.core.SSHApiException;
import org.apache.airavata.gfac.core.authentication.AuthenticationInfo;
import org.apache.airavata.gfac.core.authentication.SSHKeyAuthentication;
import org.apache.airavata.gfac.core.cluster.AbstractRemoteCluster;
import org.apache.airavata.gfac.core.cluster.CommandInfo;
import org.apache.airavata.gfac.core.cluster.CommandOutput;
import org.apache.airavata.gfac.core.cluster.OutputParser;
import org.apache.airavata.gfac.core.cluster.RawCommandInfo;
import org.apache.airavata.gfac.core.cluster.ServerInfo;
import org.apache.airavata.model.status.JobStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * One Remote cluster instance for each compute resource.
 */
public class HPCRemoteCluster extends AbstractRemoteCluster{
    private static final Logger log = LoggerFactory.getLogger(HPCRemoteCluster.class);
	private final SSHKeyAuthentication authentication;
	private final JSch jSch;
	private Session session;

	public HPCRemoteCluster(ServerInfo serverInfo, JobManagerConfiguration jobManagerConfiguration, AuthenticationInfo
			authenticationInfo) throws AiravataException {
		super(serverInfo, jobManagerConfiguration, authenticationInfo);
		try {
			if (authenticationInfo instanceof SSHKeyAuthentication) {
				authentication = (SSHKeyAuthentication) authenticationInfo;
			} else {
				throw new AiravataException("Support ssh key authentication only");
			}
			jSch = new JSch();
			jSch.addIdentity(authentication.getPrivateKeyFilePath(), authentication.getPublicKeyFilePath(),
					authentication.getPassphrase().getBytes());
			session = jSch.getSession(serverInfo.getUserName(), serverInfo.getHost(), serverInfo.getPort());
			session.setUserInfo(new DefaultUserInfo(serverInfo.getUserName(), null, authentication.getPassphrase()));
			if (authentication.getStrictHostKeyChecking().equals("yes")) {
				jSch.setKnownHosts(authentication.getKnownHostsFilePath());
			} else {
				session.setConfig("StrictHostKeyChecking","no");
			}
			session.connect(); // 0 connection timeout
		} catch (JSchException e) {
			throw new AiravataException("JSch initialization error ", e);
		}
	}

	@Override
	public String submitBatchJob(String jobScriptFilePath, String workingDirectory) throws SSHApiException {
		scpTo(jobScriptFilePath, workingDirectory); // scp script file to working directory
		RawCommandInfo submitCommand = jobManagerConfiguration.getSubmitCommand(workingDirectory, jobScriptFilePath);

		StandardOutReader reader = new StandardOutReader();
		executeCommand(submitCommand, reader);
		throwExceptionOnError(reader, submitCommand);
		return outputParser.parseJobSubmission(reader.getStdOutputString());
	}

	@Override
	public void scpTo(String localFile, String remoteFile) throws SSHApiException {
		int retry = 3;
		while (retry > 0) {
			try {
				if (!session.isConnected()) {
					session.connect();
				}
				log.info("Transferring localhost:" + localFile  + " to " + serverInfo.getHost() + ":" + remoteFile);
				SSHUtils.scpTo(localFile, remoteFile, session);
				retry = 0;
			} catch (Exception e) {
				retry--;
				if (!session.isConnected()) {
					try {
						session.connect();
					} catch (JSchException e1) {
						throw new SSHApiException("JSch Session connection failed");
					}
				}
				if (retry == 0) {
					throw new SSHApiException("Failed to scp localhost:" + localFile + " to " + serverInfo.getHost() +
							":" + remoteFile, e);
				} else {
					log.info("Retry transfer localhost:" + localFile + " to " + serverInfo.getHost() + ":" +
							remoteFile);
				}
			}
		}
	}

	@Override
	public void scpFrom(String remoteFile, String localFile) throws SSHApiException {
		int retry = 3;
		while(retry>0) {
			try {
				if (!session.isConnected()) {
					session.connect();
				}
				log.info("Transferring " + serverInfo.getHost() + ":" + remoteFile + " To localhost:" + localFile);
				SSHUtils.scpFrom(remoteFile, localFile, session);
				retry=0;
			} catch (Exception e) {
				retry--;
				if (!session.isConnected()) {
					try {
						session.connect();
					} catch (JSchException e1) {
						throw new SSHApiException("JSch Session connection failed");
					}
				}
				if (retry == 0) {
					throw new SSHApiException("Failed to scp " + serverInfo.getHost() + ":" + remoteFile + " to " +
							"localhost:" + localFile, e);
				} else {
					log.info("Retry transfer " + serverInfo.getHost() + ":" + remoteFile + "  to localhost:" + localFile);
				}
			}
		}
	}

	@Override
	public void scpThirdParty(String remoteFileSource, String remoteFileTarget) throws SSHApiException {
		try {
			if(!session.isConnected()){
				session.connect();
			}
			log.info("Transferring from:" + remoteFileSource + " To: " + remoteFileTarget);
			SSHUtils.scpThirdParty(remoteFileSource, remoteFileTarget, session);
		} catch (IOException | JSchException e) {
			throw new SSHApiException("Failed scp file:" + remoteFileSource + " to remote file "
					+remoteFileTarget , e);
		}
	}

	@Override
	public void makeDirectory(String directoryPath) throws SSHApiException {
		try {
			if (!session.isConnected()) {
				session.connect();
			}
			log.info("Creating directory: " + serverInfo.getHost() + ":" + directoryPath);
			SSHUtils.makeDirectory(directoryPath, session);
		} catch (JSchException | IOException e) {
			throw new SSHApiException("Failed to create directory " + serverInfo.getHost() + ":" + directoryPath);
		}
	}

	@Override
	public boolean cancelJob(String jobId) throws SSHApiException {
		RawCommandInfo cancelCommand = jobManagerConfiguration.getCancelCommand(jobId);
		StandardOutReader reader = new StandardOutReader();
		executeCommand(cancelCommand, reader);
		throwExceptionOnError(reader, cancelCommand);
		return true;
	}

	@Override
	public JobStatus getJobStatus(String jobId) throws SSHApiException {
		RawCommandInfo monitorCommand = jobManagerConfiguration.getMonitorCommand(jobId);
		StandardOutReader reader = new StandardOutReader();
		executeCommand(monitorCommand, reader);
		throwExceptionOnError(reader, monitorCommand);
		return outputParser.parseJobStatus(jobId, reader.getStdOutputString());
	}

	@Override
	public String getJobIdByJobName(String jobName, String userName) throws SSHApiException {
		RawCommandInfo jobIdMonitorCommand = jobManagerConfiguration.getJobIdMonitorCommand(jobName, userName);
		StandardOutReader reader = new StandardOutReader();
		executeCommand(jobIdMonitorCommand, reader);
		throwExceptionOnError(reader, jobIdMonitorCommand);
		return outputParser.parseJobId(jobName, reader.getStdOutputString());
	}

	@Override
	public void getJobStatuses(String userName, Map<String, JobStatus> jobStatusMap) throws SSHApiException {
		RawCommandInfo userBasedMonitorCommand = jobManagerConfiguration.getUserBasedMonitorCommand(userName);
		StandardOutReader reader = new StandardOutReader();
		executeCommand(userBasedMonitorCommand, reader);
		throwExceptionOnError(reader, userBasedMonitorCommand);
		outputParser.parseJobStatuses(userName, jobStatusMap, reader.getStdOutputString());
	}

	@Override
	public List<String> listDirectory(String directoryPath) throws SSHApiException {
		try {
			if (!session.isConnected()) {
				session.connect();
			}
			log.info("Creating directory: " + serverInfo.getHost() + ":" + directoryPath);
			return SSHUtils.listDirectory(directoryPath, session);
		} catch (JSchException | IOException e) {
			throw new SSHApiException("Failed to list directory " + serverInfo.getHost() + ":" + directoryPath);
		}
	}

	@Override
	public Session getSession() throws SSHApiException {
		return session;
	}

	@Override
	public void disconnect() throws SSHApiException {
		session.disconnect();
	}

	/**
	 * This method return <code>true</code> if there is an error in standard output. If not return <code>false</code>
	 * @param reader - command output reader
	 * @param submitCommand - command which executed in remote machine.
	 * @return command has return error or not.
	 */
	private void throwExceptionOnError(StandardOutReader reader, RawCommandInfo submitCommand) throws SSHApiException{
		String stdErrorString = reader.getStdErrorString();
		String command = submitCommand.getCommand().substring(submitCommand.getCommand().lastIndexOf(File.separator)
				+ 1);
		if (stdErrorString == null) {
			// noting to do
		}else if ((stdErrorString.contains(command.trim()) && !stdErrorString.contains("Warning")) || stdErrorString
				.contains("error")) {
			log.error("Command {} , Standard Error output {}", command, stdErrorString);
			throw new SSHApiException("Error running command " + command + "  on remote cluster. StandardError: " +
					stdErrorString);
		}
	}

	private void executeCommand(CommandInfo commandInfo, CommandOutput commandOutput) throws SSHApiException {
		String command = commandInfo.getCommand();
		ChannelExec channelExec = null;
		try {
			if (!session.isConnected()) {
				session.connect();
			}
			channelExec = ((ChannelExec) session.openChannel("exec"));
			channelExec.setCommand(command);
		    channelExec.setInputStream(null);
			channelExec.setErrStream(commandOutput.getStandardError());
			log.info("Executing command {}", commandInfo.getCommand());
			channelExec.connect();
			commandOutput.onOutput(channelExec);
		} catch (JSchException e) {
			throw new SSHApiException("Unable to execute command - ", e);
		}finally {
			//Only disconnecting the channel, session can be reused
			if (channelExec != null) {
				channelExec.disconnect();
			}
		}
	}

	@Override
	public ServerInfo getServerInfo() {
		return this.serverInfo;
	}

	private class DefaultUserInfo implements UserInfo {

		private String userName;
		private String password;
		private String passphrase;

		public DefaultUserInfo(String userName, String password, String passphrase) {
			this.userName = userName;
			this.password = password;
			this.passphrase = passphrase;
		}

		@Override
		public String getPassphrase() {
			return null;
		}

		@Override
		public String getPassword() {
			return null;
		}

		@Override
		public boolean promptPassword(String s) {
			return false;
		}

		@Override
		public boolean promptPassphrase(String s) {
			return false;
		}

		@Override
		public boolean promptYesNo(String s) {
			return false;
		}

		@Override
		public void showMessage(String s) {

		}
	}
}