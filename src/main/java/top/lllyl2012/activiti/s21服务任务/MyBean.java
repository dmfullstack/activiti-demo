package top.lllyl2012.activiti.s21服务任务;

import java.io.Serializable;

import org.activiti.engine.runtime.Execution;

public class MyBean implements Serializable {

    private String name = "angus";

    public String getName() {
        return name;
    }
    
    public void print(Execution exe) {
        System.out.println("执行print方法，执行流id：" + exe.getId());
    }
}
