package top.lllyl2012.activiti.s23子流程;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ErrorJavaDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution arg0) {
        System.out.println("执行子流程Service Task的Java Delegate, 抛出错误");
        throw new BpmnError("myError");
    }

}
