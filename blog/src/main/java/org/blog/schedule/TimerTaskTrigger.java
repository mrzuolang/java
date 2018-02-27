package org.blog.schedule;

import org.blog.schedule.task.SimpleTask;
import org.blog.schedule.tool.TaskHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 任务触发器
 * 控制任务的启动时间
 * @author lang
 *
 */
@Component
public class TimerTaskTrigger {
	@Autowired
	TaskHelper taskHelper;

	// fixedRate属性 该属性的含义是上一个调用开始后再次调用的延时
	//每隔1分钟执行一次
	@Scheduled(fixedRate = 5*1000)
	public void fixedRate() {
		SimpleTask task = new SimpleTask("删除超时订单");
		taskHelper.setTask(task);
		taskHelper.run();
		
		
	}

	//fixedDelay属性 该属性的功效与上面的fixedRate则是相反的，配置了该属性后会等到方法执行完成后延迟配置的时间再次执行该方法
	//每隔5分钟执行一次，延迟10秒执行
	@Scheduled(fixedDelay = 300*1000)
	public void fixedDelay() {
		
	}
	//每小时执行一次
	@Scheduled(cron = "* * */1 * * ?")
	public void initialDelay() {
		
	}
}
