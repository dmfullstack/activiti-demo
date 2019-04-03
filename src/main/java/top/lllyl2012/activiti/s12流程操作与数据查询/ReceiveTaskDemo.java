package top.lllyl2012.activiti.s12流程操作与数据查询;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;

public class ReceiveTaskDemo {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = pe.getRepositoryService();
        RuntimeService runtimeService = pe.getRuntimeService();
        TaskService taskService = pe.getTaskService();

        Deployment deployment = repositoryService.createDeployment().addClasspathResource("s12/demom.bpmn").deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();

        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());

        //找到当前的子执行流
        Execution execution = runtimeService.createExecutionQuery()
                .processInstanceId(processInstance.getId())
                .onlyChildExecutions().singleResult();
        System.out.println(execution.getActivityId());

        //触发当前流程
        runtimeService.trigger(execution.getId());

        Execution execution1 = runtimeService.createExecutionQuery()
                .processInstanceId(processInstance.getId()).onlyChildExecutions().singleResult();
        System.out.println(execution1.getActivityId());

        pe.close();
        System.exit(0);
    }
}
