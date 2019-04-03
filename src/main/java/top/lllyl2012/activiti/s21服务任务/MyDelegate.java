package top.lllyl2012.activiti.s21服务任务;

import java.io.Serializable;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class MyDelegate implements JavaDelegate, Serializable {

    @Override
    public void execute(DelegateExecution arg0) {
       System.out.println("这是自定义处理类");
    }

}
