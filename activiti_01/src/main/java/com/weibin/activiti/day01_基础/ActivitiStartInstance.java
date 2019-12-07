package com.weibin.activiti.day01_基础;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @author: webin
 * @date: 2019-12-04 21:26
 * @description:    启动流程实例，前提是已经完成流程定义的部署工作  部署=>启动实例=>查询
 *                  启动实例印象到那些表：
 *                      act_hi_actinst      :   已完成的活动信息
 *                      act_hi_identitylink :   参与者信息
 *                      act_hi_procinst     :   流程信息
 *                      act_hi_taskinst     :   任务实例
 *                      act_run_execution   :   执行表
 *                      act_run_identitylink:   参与者信息
 *                      act_run_task        :   任务表
 * @version: 0.0.1
 */
public class ActivitiStartInstance {

    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RunService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.创建流程实例，流程定义的key需要知道
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday");
        //3.输出实例的相关信息
        System.out.println("流程部署的ID：" + processInstance.getDeploymentId());
        System.out.println("流程实例的ID：" + processInstance.getId());
        System.out.println("活动ID：" + processInstance.getActivityId());
    }



}
