package top.lllyl2012.activiti.s08流程定义;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

public class ActiveTest {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        RepositoryService rs = pe.getRepositoryService();

        Deployment deployment = rs.createDeployment().addClasspathResource("s8/test_2.bpmn").deploy();

        ProcessDefinition processDefinitiond = rs.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();

        System.out.println("id:"+processDefinitiond.getId());
        rs.suspendProcessDefinitionByKey(processDefinitiond.getKey());//中止流程

        RuntimeService runtimeService = pe.getRuntimeService();
        runtimeService.startProcessInstanceByKey(processDefinitiond.getKey());//中止后无法运行，会报错

        pe.close();
        System.exit(0);
    }
}
