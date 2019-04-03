package top.lllyl2012.activiti.s25流程活动的特性;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ForeachDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("执行服务任务: " + execution.getVariable("data"));
    }

}
