package top.lllyl2012.activiti.s10任务参数与附件;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.UUID;

public class VarTest {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = pe.getTaskService();

        Task task = taskService.newTask(UUID.randomUUID().toString());
        task.setName("task_s101");
        taskService.saveTask(task);

//        taskService.setVariable(task.getId(),"key1","hello");
        Person person = new Person();
        person.setName("person_1");
        person.setAge("21");
        taskService.setVariable(task.getId(),"key2",person);//保存任务参数，全局参数

        Person s = taskService.getVariable(task.getId(),"key2",Person.class);//获取任务参数
        System.out.println(s.getName() + " -----" + s.getAge());

        pe.close();
        System.exit(0);
    }
}
