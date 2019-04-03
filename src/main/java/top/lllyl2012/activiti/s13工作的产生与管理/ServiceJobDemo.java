package top.lllyl2012.activiti.s13工作的产生与管理;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

public class ServiceJobDemo {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = pe.getRepositoryService();
        RuntimeService runtimeService = pe.getRuntimeService();
        TaskService taskService = pe.getTaskService();

        Deployment deployment = repositoryService.createDeployment().addClasspathResource("s13/service_task.bpmn").deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();

        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());

    }
}
