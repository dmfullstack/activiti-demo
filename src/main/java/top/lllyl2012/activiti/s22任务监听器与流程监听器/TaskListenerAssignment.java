package top.lllyl2012.activiti.s22任务监听器与流程监听器;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TaskListenerAssignment implements TaskListener {

    @Override
    public void notify(DelegateTask arg0) {
        System.out.println("指定代理人时触发的");
    }

}
