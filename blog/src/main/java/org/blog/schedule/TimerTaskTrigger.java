package org.blog.schedule;

import org.blog.schedule.task.SimpleTask;
import org.blog.schedule.tool.TaskHelper;
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

	// fixedRate属性 该属性的含义是上一个调用开始后再次调用的延时
	//每隔1分钟执行一次
	@Scheduled(fixedRate = 5*1000)
	public void fixedRate() {
		SimpleTask task = new SimpleTask("删除超时订单");
		TaskHelper helper = new TaskHelper(task);
		helper.run();
	}

	//fixedDelay属性 该属性的功效与上面的fixedRate则是相反的，配置了该属性后会等到方法执行完成后延迟配置的时间再次执行该方法
	//每隔1分钟执行一次，延迟10秒执行
	@Scheduled(initialDelay=10000, fixedDelay = 6000*1000)
	public void fixedDelay() {
		
	}
	//每分05秒执行一次
	@Scheduled(cron = "5 * */1 * * ?")
	public void initialDelay() {
		
	}
}
