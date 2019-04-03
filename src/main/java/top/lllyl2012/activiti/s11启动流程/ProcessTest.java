package top.lllyl2012.activiti.s11启动流程;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

public class ProcessTest {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = pe.getRepositoryService();
        TaskService taskService = pe.getTaskService();
        RuntimeService runtimeService = pe.getRuntimeService();

        Deployment deployment = repositoryService.createDeployment().addClasspathResource("s11/demo.bpmn").deploy();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        //启动流程实例，第二个参数会保存在act_ru_execution的business_key中
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId(),"abc");
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinition.getKey());//这个key就是bpmn的process定义中的id
        System.out.println(processInstance.getId());
        pe.close();
        System.exit(0);
    }
}
