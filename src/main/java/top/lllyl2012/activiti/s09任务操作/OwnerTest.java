package top.lllyl2012.activiti.s09任务操作;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.UUID;

public class OwnerTest {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = pe.getTaskService();
        IdentityService identityService = pe.getIdentityService();

        //创建一个任务
        Task task = taskService.newTask(UUID.randomUUID().toString());
        task.setName("task_1");
        taskService.saveTask(task);

        //创建一个持有人
        User user = identityService.newUser(UUID.randomUUID().toString());
        user.setFirstName("user_1");
        identityService.saveUser(user);

        taskService.setOwner(task.getId(),user.getId());

        List<Task> tasks = taskService.createTaskQuery().taskOwner(user.getId()).list();
        for (Task t :tasks) {
            System.out.println(t.getName());
        }

        pe.close();
        System.exit(0);
    }
}
