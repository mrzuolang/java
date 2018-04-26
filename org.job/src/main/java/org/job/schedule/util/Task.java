package org.job.schedule.util;

/**
 * 定时任务的接口
 * @author lang
 *
 */
public interface Task {
	
	/**
	 * 返回任务的名称，名称需要唯一性
	 * @return
	 */
	public String getName();
	
	/**
	 * 任务初始化方法
	 */
	public void init();
	
	/**
	 * 任务的业务代码
	 * @throws Exception
	 */
	public void task() throws Exception;
	
	/**
	 * 任务结束代码
	 */
	public void end();
}
