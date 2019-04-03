package top.lllyl2012.activiti.s13工作的产生与管理;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class MyJavaDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println(111);
    }
}
