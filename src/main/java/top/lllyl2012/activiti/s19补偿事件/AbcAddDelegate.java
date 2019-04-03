package top.lllyl2012.activiti.s19补偿事件;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class AbcAddDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution arg0) {
        System.out.println("农业银行加款");
    }

}
