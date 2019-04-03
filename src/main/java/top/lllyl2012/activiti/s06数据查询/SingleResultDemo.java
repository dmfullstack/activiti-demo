package top.lllyl2012.activiti.s06数据查询;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class SingleResultDemo {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        IdentityService is = pe.getIdentityService();
        Group group = is.createGroupQuery().groupName("group_0").groupType("type_0").singleResult();//如果查出来两条则会报错

        System.out.println(group.getId() + ":" + group.getName() + ":" + group.getType());

        pe.close();
        System.exit(0);
    }
}
