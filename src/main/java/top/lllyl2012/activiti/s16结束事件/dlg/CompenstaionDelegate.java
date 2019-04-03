package top.lllyl2012.activiti.s16结束事件.dlg;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class CompenstaionDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution arg0) {
        System.out.println("进行补偿处理");
    }

}
