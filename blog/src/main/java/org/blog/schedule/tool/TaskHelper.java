package org.blog.schedule.tool;

import org.blog.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskHelper {

	private Task task;
	private Logger log;
	private long start;
	private long end;
	private Exception e = null;
	public static final String LINE="=============";

	public TaskHelper(Task task) {
		this.task = task;
		log = LoggerFactory.getLogger(task.getClass());

	}

	private void prepare() {
		start = System.currentTimeMillis();
		String startTimer = DateUtil.getDateTime(start);
		log.info(LINE + task.getName()+LINE);
		log.info("开始时间从："+startTimer);
	}

	public void run() {
		this.prepare();
		task.init();
		try {
			task.task();
		} catch (Exception e) {
			this.e = e;
		} finally {
			task.end();
			this.destory(e);
		}
	}

	private void destory(Exception e) {
		end = System.currentTimeMillis();
		String endTimer = DateUtil.getDateTime(end);		
		if (e != null) {
			log.info(task.getName()+"任务失败!");
			log.info(e.getMessage());
		}else {
			log.info(task.getName()+"任务执行成功!");
		}
		
		log.info("耗时：" + (end - start) / 1000 + "秒");
		log.info("结束于时间:"+endTimer);
	}

}
