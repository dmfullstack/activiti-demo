package top.lllyl2012.activiti.s06数据查询;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

import java.util.List;

public class GroupList {
    public static void main(String[] args) {
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

        IdentityService is = pe.getIdentityService();
        List<Group> group =  is.createGroupQuery().list();
        for (Group g: group) {
            System.out.println(g.getId() + ":" + g.getName() + ":" + g.getType());
        }

        long count = is.createGroupQuery().count();
        System.out.println("总数:" + count);

        pe.close();
        System.exit(0);
    }
}
