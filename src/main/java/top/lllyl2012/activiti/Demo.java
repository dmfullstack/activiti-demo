package top.lllyl2012.activiti;

import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class Demo {
    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        //储存服务
        RepositoryService rs = engine.getRepositoryService();
        //运行时服务
        RuntimeService runService = engine.getRuntimeService();
        //任务服务
        TaskService taskService = engine.getTaskService();

        rs.createDeployment().addClasspathResource("ideaFirst.bpmn").deploy();

         ProcessInstance pi = runService.startProcessInstanceByKey("myProcess_1");

         //员工提交审核
         Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前流程节点：" + task.getName());
        taskService.complete(task.getId());

        //经理审核
        Task task2 = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("当前第二节点：" + task2.getName());
        taskService.complete(task2.getId());

        //最后
        Task task3 = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println("结束了：" + task3);

        engine.close();
        System.exit(0);
    }
}
