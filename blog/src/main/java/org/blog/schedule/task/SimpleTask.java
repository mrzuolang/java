package org.blog.schedule.task;

import org.blog.schedule.util.SuperTask;

/**
 * 定时任务例子
 * @author lang
 *
 */
public class SimpleTask extends SuperTask{
	
	public SimpleTask(String name) {
		super(name);
	}
	@Override
	public void init() {
		
	}
	@Override
	public void task() throws Exception {
		System.out.println("删除数据中......");
		Thread.sleep(5000);
	}

}
