package top.lllyl2012.activiti.s08流程定义;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

public class DeployTest {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        RepositoryService rs = pe.getRepositoryService();

        Deployment deployment = rs.createDeployment().addClasspathResource("s8/test_1.bpmn")
                .addClasspathResource("s8/test_1.png").deploy();//如果有部署png，activiti就不会再自己生成一个了

        pe.close();
        System.exit(0);

    }
}
