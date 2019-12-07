package com.weibin.activiti.day01_基础;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author: webin
 * @date: 2019-12-04 21:38
 * @description:       查询当前用户的任务列表
 * @version: 0.0.1
 */
public class ActivitiTaskQuery {

    /*
        1.首先zhangsan申请  .list();
        2.lisi
     */
    private static String people = "lisi";
    private static String key = "myProcess_1";

    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到TaskService对象
        TaskService taskService = processEngine.getTaskService();
        //3.根据流程定义的key，负责人assignee来实现当前用户的任务列表查询
        //queryList(taskService,people,key);
        querySingle(taskService,"lisi",key);


        //4.任务列表展示

    }

    private static void querySingle(TaskService taskService, String lisi, String key) {
        Task task = taskService.createTaskQuery().processDefinitionKey(key)
                .taskAssignee(people)
                .singleResult();
        System.out.println("流程实例ID ： " + task.getProcessInstanceId());
        System.out.println("任务ID ： " + task.getId()); //5002
        System.out.println("任务负责人 ： " + task.getAssignee());
        System.out.println("任务名称 ： " + task.getName());
    }

    private static void queryList(TaskService taskService, String people, String key) {
        List<Task> list = taskService.createTaskQuery().processDefinitionKey(key)
                .taskAssignee(people)
                .list();
        for (Task task : list) {
            System.out.println("流程实例ID ： " + task.getProcessInstanceId());
            System.out.println("任务ID ： " + task.getId());
            System.out.println("任务负责人 ： " + task.getAssignee());
            System.out.println("任务名称 ： " + task.getName());
        }
    }
}
