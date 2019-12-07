package com.weibin.activiti.day02_进阶1;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * @author: webin
 * @date: 2019-12-06 20:52
 * @description:    (删除)流程定义信息
 *                      删除定义信息关联的表记录：
 *                          act_ge_bytearray : 存储二进制信息的表
 *                          act_re_deployment : 流程定义部署的表
 *                          act_re_procdef : 流程定义数据表
 *
 * @version: 0.0.1
 */
public class DeleteProcessDefinition {

    /**
     * 注意事项：
     *  1.当我们正在执行的这一套流程没有完全审批结束的时候，此时如果要删除定义信息时，会删除失败
     *  2.如果公司层面要强制删除，可以使用repositoryService.deleteDeployment("1",true);
     *      参数true代表级联删除，此时就会先删除没有完成的流程节点，最后就可以删除流程定义信息 false代表不级联删除 默认为false
     * @param args
     */
    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.创建RepositoryService对象 param：删除的流程部署id
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.执行删除流程定义
        repositoryService.deleteDeployment("1");


    }
}
