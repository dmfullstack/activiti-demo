package top.lllyl2012.activiti.s07流程文件部署;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageQuery {
    public static void main(String[] args) throws IOException {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        RepositoryService rs = pe.getRepositoryService();

        Deployment deployment = rs.createDeployment()
                .addClasspathResource("ideaFirst.bpmn")
                .deploy();

        ProcessDefinition processDefinition =  rs.createProcessDefinitionQuery()
                .deploymentId(deployment.getId()).singleResult();

        InputStream is = rs.getProcessDiagram(processDefinition.getId());

        BufferedImage image = ImageIO.read(is);

        File file = new File("D:/笔记/result.png");
        if(!file.exists()) file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        ImageIO.write(image,"png",fos);
        fos.close();
        is.close();

        pe.close();
        System.exit(0);
    }
}
