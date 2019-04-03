package top.lllyl2012.activiti.s07流程文件部署;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;

import java.io.IOException;
import java.io.InputStream;

public class
TextQuery {
    public static void main(String[] args) throws IOException {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        RepositoryService rs = pe.getRepositoryService();

        DeploymentBuilder pb = rs.createDeployment();

        pb.addClasspathResource("my_text.txt");

        Deployment deployment = pb.deploy();

        InputStream is = rs.getResourceAsStream(deployment.getId(),"my_text.txt");
        int count = is.available();
        byte[] contents = new byte[count];
        is.read(contents);
        String content = new String(contents);

        System.out.println(content);

        pe.close();
        System.exit(0);

    }
}
