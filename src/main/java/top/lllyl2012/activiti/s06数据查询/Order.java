package top.lllyl2012.activiti.s06数据查询;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

import java.util.List;

public class Order {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        IdentityService is = pe.getIdentityService();
        List<Group> groups = is.createGroupQuery().orderByGroupName().desc().orderByGroupType().asc().list();

        for (Group g: groups) {
            System.out.println(g.getId() + ":" + g.getName() + ":" + g.getType());
        }

        pe.close();
        System.exit(0);
    }

}
