package top.lllyl2012.activiti.s07流程文件部署;

import org.activiti.bpmn.model.*;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 *代码方式定义流程
 */
public class BpmnTest {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        RepositoryService rs = pe.getRepositoryService();

        DeploymentBuilder db = rs.createDeployment();

        db.addBpmnModel("My process",createProcessModel()).deploy();

        pe.close();

        System.exit(0);
    }
    private static BpmnModel createProcessModel(){
        BpmnModel model = new BpmnModel();
        Process process = new Process();
        model.addProcess(process);
        process.setId("myProcess");
        process.setName("My Process");
        //开始事件
        StartEvent startEvent = new StartEvent();
        startEvent.setId("startEvent");
        process.addFlowElement(startEvent);
        //用户任务
        UserTask userTask = new UserTask();
        userTask.setName("User Task");
        userTask.setId("userTask");
        process.addFlowElement(userTask);
        //编辑文本
        EndEvent endEvent = new EndEvent();
        endEvent.setId("endEvent");
        process.addFlowElement(endEvent);
        //
        process.addFlowElement(new SequenceFlow("startEvent","userTask"));
        process.addFlowElement(new SequenceFlow("userTask","endEvent"));
        return model;

    }
}
