package top.lllyl2012.activiti.s07流程文件部署;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.zip.ZipInputStream;

public class ZipDeploy {
    public static void main(String[] args) throws FileNotFoundException {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        RepositoryService rs = pe.getRepositoryService();

        DeploymentBuilder db =  rs.createDeployment();

        FileInputStream fis = new FileInputStream(new File(ZipDeploy.class.getResource("/datas.zip").getPath()));

        System.out.println();

        ZipInputStream zis = new ZipInputStream(fis);

        db.addZipInputStream(zis);

        db.deploy();

        pe.close();

        System.exit(0);
    }
}
