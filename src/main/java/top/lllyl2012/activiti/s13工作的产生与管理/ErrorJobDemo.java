package top.lllyl2012.activiti.s13工作的产生与管理;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Job;
import org.activiti.engine.runtime.ProcessInstance;

public class ErrorJobDemo {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = pe.getRepositoryService();
        RuntimeService runtimeService = pe.getRuntimeService();
        TaskService taskService = pe.getTaskService();
        ManagementService managementService = pe.getManagementService();//管理服务组件

        Deployment deployment = repositoryService.createDeployment().addClasspathResource("s13/error_task.bpmn").deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();

        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());
        System.out.println(processInstance.getId());

        //设置重试次数
        Job job = managementService.createJobQuery().singleResult();
        managementService.setJobRetries(job.getId(),1);

        //再次重试抛出异常
        managementService.executeJob(job.getId());
    }
}
