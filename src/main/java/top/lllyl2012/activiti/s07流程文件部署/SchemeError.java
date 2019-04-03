package top.lllyl2012.activiti.s07流程文件部署;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class SchemeError {//部署格式问题流程文件
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        RepositoryService rs = pe.getRepositoryService();

        DeploymentBuilder pd = rs.createDeployment();

        pd.addClasspathResource("error/schema_error.bpmn");
        pd.disableSchemaValidation();//部署时不校验格式
        pd.deploy();

        pe.close();

        System.exit(0);
    }
}
