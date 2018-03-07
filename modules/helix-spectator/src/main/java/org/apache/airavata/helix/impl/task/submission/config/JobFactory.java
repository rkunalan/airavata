package org.apache.airavata.helix.impl.task.submission.config;

import org.apache.airavata.helix.impl.task.submission.config.app.*;
import org.apache.airavata.helix.impl.task.submission.config.app.parser.*;
import org.apache.airavata.model.appcatalog.computeresource.*;
import org.apache.airavata.registry.cpi.AppCatalog;
import org.apache.airavata.registry.cpi.AppCatalogException;

public class JobFactory {

    public static String getTemplateFileName(ResourceJobManagerType resourceJobManagerType) {
        switch (resourceJobManagerType) {
            case FORK:
                return "FORK_Groovy.template";
            case PBS:
                return "PBS_Groovy.template";
            case SLURM:
                return "SLURM_Groovy.template";
            case UGE:
                return "UGE_Groovy.template";
            case LSF:
                return "LSF_Groovy.template";
            case CLOUD:
                return "CLOUD_Groovy.template";
            default:
                return null;
        }
    }

    public static ResourceJobManager getResourceJobManager(AppCatalog appCatalog, JobSubmissionProtocol submissionProtocol, JobSubmissionInterface jobSubmissionInterface) {
        try {
            if (submissionProtocol == JobSubmissionProtocol.SSH ) {
                SSHJobSubmission sshJobSubmission = getSSHJobSubmission(appCatalog, jobSubmissionInterface.getJobSubmissionInterfaceId());
                if (sshJobSubmission != null) {
                    return sshJobSubmission.getResourceJobManager();
                }
            } else if (submissionProtocol == JobSubmissionProtocol.LOCAL) {
                LOCALSubmission localJobSubmission = getLocalJobSubmission(appCatalog, jobSubmissionInterface.getJobSubmissionInterfaceId());
                if (localJobSubmission != null) {
                    return localJobSubmission.getResourceJobManager();
                }
            } else if (submissionProtocol == JobSubmissionProtocol.SSH_FORK){
                SSHJobSubmission sshJobSubmission = getSSHJobSubmission(appCatalog, jobSubmissionInterface.getJobSubmissionInterfaceId());
                if (sshJobSubmission != null) {
                    return sshJobSubmission.getResourceJobManager();
                }
            }
        } catch (AppCatalogException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static LOCALSubmission getLocalJobSubmission(AppCatalog appCatalog, String submissionId) throws AppCatalogException {
        try {
            return appCatalog.getComputeResource().getLocalJobSubmission(submissionId);
        } catch (Exception e) {
            String errorMsg = "Error while retrieving local job submission with submission id : " + submissionId;
            throw new AppCatalogException(errorMsg, e);
        }
    }

    public static SSHJobSubmission getSSHJobSubmission(AppCatalog appCatalog, String submissionId) throws AppCatalogException {
        try {
            return appCatalog.getComputeResource().getSSHJobSubmission(submissionId);
        } catch (Exception e) {
            String errorMsg = "Error while retrieving SSH job submission with submission id : " + submissionId;
            throw new AppCatalogException(errorMsg, e);
        }
    }

    public static JobManagerConfiguration getJobManagerConfiguration(ResourceJobManager resourceJobManager) throws Exception {
        if(resourceJobManager == null)
            return null;


        String templateFileName = getTemplateFileName(resourceJobManager.getResourceJobManagerType());
        switch (resourceJobManager.getResourceJobManagerType()) {
            case PBS:
                return new PBSJobConfiguration(templateFileName, ".pbs", resourceJobManager.getJobManagerBinPath(),
                        resourceJobManager.getJobManagerCommands(), new PBSOutputParser());
            case SLURM:
                return new SlurmJobConfiguration(templateFileName, ".slurm", resourceJobManager
                        .getJobManagerBinPath(), resourceJobManager.getJobManagerCommands(), new SlurmOutputParser());
            case LSF:
                return new LSFJobConfiguration(templateFileName, ".lsf", resourceJobManager.getJobManagerBinPath(),
                        resourceJobManager.getJobManagerCommands(), new LSFOutputParser());
            case UGE:
                return new UGEJobConfiguration(templateFileName, ".pbs", resourceJobManager.getJobManagerBinPath(),
                        resourceJobManager.getJobManagerCommands(), new UGEOutputParser());
            case FORK:
                return new ForkJobConfiguration(templateFileName, ".sh", resourceJobManager.getJobManagerBinPath(),
                        resourceJobManager.getJobManagerCommands(), new ForkOutputParser());
            // We don't have a job configuration manager for CLOUD type
            default:
                return null;
        }

    }
}