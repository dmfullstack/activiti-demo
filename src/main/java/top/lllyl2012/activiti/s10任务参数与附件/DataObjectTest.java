package top.lllyl2012.activiti.s10任务参数与附件;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class DataObjectTest {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = pe.getRepositoryService();
        TaskService taskService = pe.getTaskService();
        RuntimeService runtimeService = pe.getRuntimeService();

        Deployment deployment = repositoryService.createDeployment().addClasspathResource("s10/dataObject.bpmn").deploy();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId()).singleResult();

        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());//创建流程实例

        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        String value = taskService.getVariable(task.getId(),"personName",String.class);//取出bpmn中已经设置好的dataObject参数，即在流程文件中事先定义好的参数
        System.out.println(value);

        pe.close();
        System.exit(0);
    }
}
