package top.lllyl2012.activiti.s06数据查询;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

import java.util.List;

public class GroupPageList {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        IdentityService is = pe.getIdentityService();
        List<Group> groups = is.createGroupQuery().listPage(3,5);//和mysql分页一个规则

        for (Group g :groups) {
            System.out.println(g.getId() + ":" + g.getName() + ":" + g.getType());
        }

        pe.close();
        System.exit(0);

    }
}
