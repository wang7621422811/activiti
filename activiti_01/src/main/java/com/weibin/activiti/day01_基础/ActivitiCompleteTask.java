package com.weibin.activiti.day01_基础;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author: webin
 * @date: 2019-12-04 21:38
 * @description:       处理当前用户的任务列表
 *                          背后操作的表：
 *                              act_hi_actinst
 *                              act_hi_identitylink
 *                              act_hi_taskinst
 *                              act_ru_execution
 *                              act_ru_identitylink
 *                              act_run_task        ：   任务表
 * @version: 0.0.1
 */
public class ActivitiCompleteTask {

    //查询当前用户的任务并且处理数据
    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到TaskService对象
        TaskService taskService = processEngine.getTaskService();
        //3.查询当前用户的任务
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("wangwu") //zhangsan lishi wangwu
                .singleResult();
        //3.处理任务，结合当前用户任务列表的查询操作，任务ID
        taskService.complete(task.getId());
        //5输出任务的id
        System.out.println(task.getId());
    }


    /*public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到TaskService对象
        TaskService taskService = processEngine.getTaskService();
        //3.处理任务，结合当前用户任务列表的查询操作，任务ID
        taskService.complete("7502");
    }*/

    //zhangsan完成自己的任务
    /*public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到TaskService对象
        TaskService taskService = processEngine.getTaskService();
        //3.处理任务，结合当前用户任务列表的查询操作，任务ID
        taskService.complete("2505");
    }*/
}
