package top.lllyl2012.activiti.s06数据查询;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class SaveGroup {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        IdentityService identityService = processEngine.getIdentityService();

        for(int i=0;i<10;i++){
            Group group  = identityService.newGroup(String.valueOf(i));
            group.setName("group_"+i);
            group.setType("type_"+i);
            identityService.saveGroup(group);
        }
        processEngine.close();
        System.exit(0);
    }
}
