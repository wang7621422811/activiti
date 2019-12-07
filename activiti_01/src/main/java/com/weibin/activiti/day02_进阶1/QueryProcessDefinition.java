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
 * @description:    (查询)流程定义信息
 * @version: 0.0.1
 */
public class QueryProcessDefinition {

    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.得到ProcessDefinitionQuery对象 可以认为就是一个查询器
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        //4.设置条件，并查询出当前的所有的流程定义
        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey("holiday") //查询条件：流程定义的key
                .orderByProcessDefinitionVersion() //设置排序方式，根据流程定义的版本号进行排序
                .desc() //降序查询
                .list();//查询出所有信息
        //5.输出流程定义信息
        for (ProcessDefinition processDefinition : list) {
            System.out.println("流程定义的ID：" + processDefinition.getId());
            System.out.println("流程定义的名称：" + processDefinition.getName());
            System.out.println("流程定义的key：" + processDefinition.getKey());
            System.out.println("流程定义的版本号：" + processDefinition.getVersion());
            System.out.println("流程部署ID：" + processDefinition.getDeploymentId());
        }

    }
}
