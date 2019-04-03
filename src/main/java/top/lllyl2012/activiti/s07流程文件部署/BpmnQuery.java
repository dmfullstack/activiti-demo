package top.lllyl2012.activiti.s07流程文件部署;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

import java.io.IOException;
import java.io.InputStream;

public class BpmnQuery {
    public static void main(String[] args) throws IOException {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        RepositoryService rs = pe.getRepositoryService();

        Deployment deployment = rs.createDeployment()
                .addClasspathResource("ideaFirst.bpmn")
                .deploy();

        ProcessDefinition processDefinition =  rs.createProcessDefinitionQuery()
                .deploymentId(deployment.getId()).singleResult();

        InputStream is = rs.getProcessModel(processDefinition.getId());
        int count = is.available();
        byte[] cout = new byte[count];
        is.read(cout);
        String content = new String(cout);
        System.out.println(content);//打印出ideaFirst.bpmn

        pe.close();
        System.exit(0);
    }
}
