package top.lllyl2012.activiti.s08流程定义;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;
import java.util.UUID;

public class AuthTest {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        RepositoryService repositoryService = pe.getRepositoryService();
        IdentityService identityService = pe.getIdentityService();

        User user = identityService.newUser(UUID.randomUUID().toString());
        user.setFirstName("haha");
        identityService.saveUser(user);

        Deployment deployment = repositoryService.createDeployment().addClasspathResource("s8/test_4.bpmn").deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId()).singleResult();

        repositoryService.addCandidateStarterUser(processDefinition.getId(),user.getId());//定义用户拥有该流程权限

        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery()
                .startableByUser(user.getId()).list();//遍历该用户拥有权限的所有流程
        for (ProcessDefinition processDefinition1:processDefinitions) {
            System.out.println(processDefinition1.getId());
        }

        pe.close();
        System.exit(0);
    }
}
