package top.lllyl2012.activiti.s10任务参数与附件;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class VarLocalTest {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = pe.getRepositoryService();
        TaskService taskService = pe.getTaskService();
        RuntimeService runtimeService = pe.getRuntimeService();

        Deployment deployment = repositoryService.createDeployment().addClasspathResource("s10/var_local.bpmn").deploy();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId()).singleResult();

        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());//创建流程实例

        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        taskService.setVariableLocal(task.getId(),"key4","haha");//设置本地参数，也就是局部参数
        System.out.println(task.getId() + ":" + taskService.getVariableLocal(task.getId(),"key4"));

        taskService.complete(task.getId());
        task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        System.out.println("end"  + task.getId() + ":" + taskService.getVariableLocal(task.getId(),"key4"));

        pe.close();
        System.exit(0);
    }
}
