package top.lllyl2012.activiti.s19补偿事件;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class IcbcAddDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution arg0) {
        System.out.println("工商银行加款");
    }

}
