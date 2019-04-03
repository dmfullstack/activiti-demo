package top.lllyl2012.activiti.s07流程文件部署;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class BpmnError {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        RepositoryService rs = pe.getRepositoryService();

        DeploymentBuilder pb  = rs.createDeployment();

        pb.addClasspathResource("error/bpmn_error.bpmn");
        pb.disableBpmnValidation();//不校验流程问题

        pb.deploy();
        pe.close();
        System.exit(0);
    }
}
