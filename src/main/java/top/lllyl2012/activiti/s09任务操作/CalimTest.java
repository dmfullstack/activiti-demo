package top.lllyl2012.activiti.s09任务操作;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.UUID;

public class CalimTest {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = pe.getTaskService();
        IdentityService identityService = pe.getIdentityService();

        //创建一个任务
        Task task = taskService.newTask(UUID.randomUUID().toString());
        task.setName("task_3");
        taskService.saveTask(task);

        //创建一个持有人
        User user = identityService.newUser(UUID.randomUUID().toString());
        user.setFirstName("user_3");
        identityService.saveUser(user);

        taskService.setOwner(task.getId(),user.getId());

        taskService.claim(task.getId(),"a2ba07dc-257b-40a3-ac90-bc8ee1251237");//设置代理人（id）
//        taskService.claim(task.getId(),"31dc7754-f9de-4c10-861a-3cb0495ce047");//设置第二个会报错

        List<Task> tasks = taskService.createTaskQuery().taskAssignee("0a6843b2-59d0-4439-be8a-59b23105b38c").list();
        for (Task t :tasks) {
            System.out.println(t.getName());
        }

        pe.close();
        System.exit(0);
    }
}
