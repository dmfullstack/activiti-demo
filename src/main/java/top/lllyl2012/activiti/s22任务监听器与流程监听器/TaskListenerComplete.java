package top.lllyl2012.activiti.s22任务监听器与流程监听器;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TaskListenerComplete implements TaskListener {

    @Override
    public void notify(DelegateTask arg0) {
        System.out.println("完成任务的时候触发的");
    }

}
