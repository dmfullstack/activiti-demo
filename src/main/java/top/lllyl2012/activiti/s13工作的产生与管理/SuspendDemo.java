package top.lllyl2012.activiti.s13工作的产生与管理;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

public class SuspendDemo {
    public static void main(String[] args) throws InterruptedException {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = pe.getRepositoryService();
        RuntimeService runtimeService = pe.getRuntimeService();
        TaskService taskService = pe.getTaskService();

        Deployment deployment = repositoryService.createDeployment().addClasspathResource("s13/suspend_test.bpmn").deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();

        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());

        System.out.println(processInstance.getId());

        Thread.sleep(10000);

        runtimeService.suspendProcessInstanceById(processInstance.getId());//暂停这个工作

        Thread.sleep(10000);

        runtimeService.activateProcessInstanceById(processInstance.getId());//重启这个工作
    }
}
