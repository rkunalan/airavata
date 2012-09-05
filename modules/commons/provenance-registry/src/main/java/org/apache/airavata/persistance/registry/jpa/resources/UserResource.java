package org.apache.airavata.persistance.registry.jpa.resources;

import org.apache.airavata.persistance.registry.jpa.Resource;
import org.apache.airavata.persistance.registry.jpa.ResourceType;
import org.apache.airavata.persistance.registry.jpa.model.Experiment;
import org.apache.airavata.persistance.registry.jpa.model.Gateway;
import org.apache.airavata.persistance.registry.jpa.model.User_Workflow;
import org.apache.airavata.persistance.registry.jpa.model.Users;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserResource extends AbstractResource {
    private int id;
    private String userName;
    private String password;
    private int gatewayID;
    private ProjectResource projectResource;


    public UserResource() {
    }

    public UserResource(int id) {
        this.id = id;
//        this.gatewayID = gatewayID;
//        this.projectResource = projectResource;
    }

    public int getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public int getGatewayID() {
        return gatewayID;
    }

    public void setGatewayID(int gatewayID) {
        this.gatewayID = gatewayID;
    }

    public Resource create(ResourceType type) {
        if (type == ResourceType.USER_WORKFLOW) {
            UserWorkflowResource userWorkflowResource = new UserWorkflowResource();
            userWorkflowResource.setUserID(id);
//            userWorkflowResource.setProjectID();
            return userWorkflowResource;
        } else if (type == ResourceType.EXPERIMENT) {
            ExperimentResource experimentResource = new ExperimentResource();
//            experimentResource.setProjectID(id);
            experimentResource.setUserID(id);
            return experimentResource;
        } else {
            return null;
        }
    }

    public void remove(ResourceType type, Object name) {
        begin();
        if(type == ResourceType.USER_WORKFLOW){
            Query q = em.createQuery("Delete p FROM User_Workflow p WHERE p.user_ID = :user_id and p.user_workflow_name = :usrwf_name");
            q.setParameter("user_id", id);
            q.setParameter("usrwf_name", name);
            q.executeUpdate();
        }else if (type == ResourceType.EXPERIMENT){
            Query q = em.createQuery("Delete p FROM Experiment p WHERE p.user_ID = :user_id and p.experiment_ID = :ex_name");
            q.setParameter("user_id", id);
            q.setParameter("ex_name", name);
            q.executeUpdate();
        }
        end();

    }

    public Resource get(ResourceType type, Object name) {
        begin();
        if (type == ResourceType.USER_WORKFLOW) {
            Query q = em.createQuery("SELECT p FROM User_Workflow p WHERE p.user_ID = :user_id and p.user_workflow_name = :usrwf_name");
            q.setParameter("user_id", id);
            q.setParameter("usrwf_name", name);
            User_Workflow userWorkflow = (User_Workflow) q.getSingleResult();
            UserWorkflowResource userWorkflowResource = new UserWorkflowResource(userWorkflow.getProject().getProject_ID(), id, userWorkflow.getUser_workflow_name());
            userWorkflowResource.setContent(userWorkflow.getWorkflow_content());
            userWorkflowResource.setLastUpdateDate(userWorkflow.getLast_update_date());
            end();
            return userWorkflowResource;
        } else if (type == ResourceType.EXPERIMENT) {
            Query q = em.createQuery("SELECT p FROM Experiment p WHERE p.user_ID = :user_id and p.experiment_ID = :ex_name");
            q.setParameter("user_id", id);
            q.setParameter("ex_name", name);
            Experiment experiment = (Experiment) q.getSingleResult();
            ExperimentResource experimentResource = new ExperimentResource(experiment.getExperiment_ID());
            experimentResource.setProjectID(experiment.getProject().getProject_ID());
            Users user = new Users();
            user.setUser_ID(id);
            user.setUser_name(userName);
            user.setPassword(password);
            experiment.setUser(user);
            experiment.setSubmitted_date(experiment.getSubmitted_date());
            experiment.setUser(experiment.getUser());
            end();
            return experimentResource;
        }
        return null;
    }

    public List<Resource> get(ResourceType type) {
        List<Resource> resourceList = new ArrayList<Resource>();
        begin();
        if (type == ResourceType.USER_WORKFLOW) {
            Query q = em.createQuery("SELECT p FROM User_Workflow p WHERE p.user_ID =:usr_ID");
            q.setParameter("usr_ID", id);
            List results = q.getResultList();
            if (results.size() != 0) {
                for (Object result : results) {
                    User_Workflow userWorkflow = (User_Workflow) result;
                    UserWorkflowResource userWorkflowResource = new UserWorkflowResource(userWorkflow.getProject().getProject_ID(), userWorkflow.getUsers().getUser_ID(), userWorkflow.getUser_workflow_name());
                    userWorkflowResource.setContent(userWorkflow.getWorkflow_content());
                    userWorkflowResource.setLastUpdateDate(userWorkflow.getLast_update_date());
                    resourceList.add(userWorkflowResource);
                }
            }
        } else if (type == ResourceType.EXPERIMENT) {
            Query q = em.createQuery("SELECT p FROM Experiment p WHERE p.user_ID =:usr_ID");
            q.setParameter("usr_ID", id);
            List results = q.getResultList();
            if (results.size() != 0) {
                for (Object result : results) {
                    Experiment experiment = (Experiment) result;
                    ExperimentResource experimentResource = new ExperimentResource(experiment.getExperiment_ID());
                    experimentResource.setProjectID(experiment.getProject().getProject_ID());
                    experimentResource.setUserID(experiment.getUser().getUser_ID());
                    experimentResource.setSubmittedDate(experiment.getSubmitted_date());
                    resourceList.add(experimentResource);
                }
            }
        }
        end();
        return resourceList;
    }

    public void save() {
        begin();
        Users user = new Users();
        Gateway gateway = new Gateway();
        gateway.setGateway_ID(gatewayID);
        user.setGateway(gateway);
        user.setUser_name(userName);
        user.setPassword(password);
        if (id != -1) {
            user.setUser_ID(id);
        }
        em.persist(user);
        end();

    }

    public boolean isExists(ResourceType type, Object name) {
        begin();
        if(type == ResourceType.USER_WORKFLOW){
            Query q = em.createQuery("SELECT p FROM User_Workflow p WHERE p.gateway_ID =:gate_ID and p.user_ID =:userID and p.user_workflow_name =:usr_wf_name");
            q.setParameter("gate_ID", gatewayID);
            q.setParameter("userID",id);
            q.setParameter("usr_wf_name", name);
            User_Workflow userWorkflow = (User_Workflow)q.getSingleResult();
            if(userWorkflow != null){
                return true;
            }else {
                return false;
            }
        }else if(type == ResourceType.EXPERIMENT){
            Query q = em.createQuery("SELECT p FROM Experiment p WHERE p.gateway_ID =:gate_ID and p.user_ID =:userID and p.experiment_ID =:experimentID");
            q.setParameter("gate_ID", gatewayID);
            q.setParameter("userID",id);
            q.setParameter("experimentID", name);
            Experiment experiment = (Experiment)q.getSingleResult();
            if(experiment != null){
                return true;
            }else {
                return false;
            }
        }
        end();
        return false;
    }

    public ProjectResource getProjectResource() {
        return projectResource;
    }

    public void setProjectResource(ProjectResource projectResource) {
        this.projectResource = projectResource;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
