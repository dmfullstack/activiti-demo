package top.lllyl2012.activiti.s11启动流程;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;

public class ScopeTest {//流程定义的本地参数
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = pe.getRepositoryService();
        TaskService taskService = pe.getTaskService();
        RuntimeService runtimeService = pe.getRuntimeService();

        Deployment deployment = repositoryService.createDeployment().addClasspathResource("s11/scope.bpmn").deploy();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        //启动流程实例，第二个参数会保存在act_ru_execution的business_key中
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId(),"abc");

        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
        for (Task t:tasks) {
            Execution execution = runtimeService.createExecutionQuery().executionId(t.getExecutionId()).singleResult();
            if("task1".equals(t.getName())){
                runtimeService.setVariableLocal(execution.getId(),"ekey","gaga");//给task1设置流程本地参数
            }else{
                runtimeService.setVariable(execution.getId(),"ekey2","haha");//给task2设置流程全局参数
            }
        }
        for (Task t :tasks) {
            System.out.println(t.getName());
            taskService.complete(t.getId());
        }

        Task task3 = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        String v1 = runtimeService.getVariable(processInstance.getId(),"ekey",String.class);
        String v2 = runtimeService.getVariable(processInstance.getId(),"ekey2",String.class);
        System.out.println("v1:"+v1);//Null
        System.out.println("v2:"+v2);//全局参数有

        System.out.println(task3.getId());

        pe.close();
        System.exit(0);
    }
}
