package org.job.schedule.util;
import java.util.Date;

import org.job.dao.JobDao;
import org.job.entity.JobVO;
import org.job.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/** 任务助手，主要记录任务开始时间 结束时间
 * @author lang
 *
 */
@Repository
public class TaskHelper {

	private SuperTask task;
	private Logger log;
	private long start;
	private long end;
	private Exception e = null;
	public static final String LINE="=============";
	@Autowired
	private JobDao taskDao;
	private JobVO jobVO=null;
	

	/**
	 * 手功调用任务助手
	 * @param task
	 */
	public TaskHelper(SuperTask task) {
		this.task = task;
		log = LoggerFactory.getLogger(task.getClass());
	}
	
	public TaskHelper() {
		super();
	}
	
	public void setTask(SuperTask task) {
		this.task = task;
		log = LoggerFactory.getLogger(task.getClass());
	}

	/**
	 * 任务预运行
	 * 记录任务开始时间
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	private void prepare() {
	
		log.info(LINE + task.getName()+LINE);
		log.info("开始时间从："+DateUtil.getDateTime());
		
		//记录任务开始时间
		jobVO = taskDao.findByName(task.getName());
		Date now = new Date();
		if(jobVO==null) {
			jobVO = new JobVO();
			jobVO.setJob_name(task.getName());
			jobVO.setStart_time(now);
			jobVO.setClass_name(task.getClass().getName());
			taskDao.insert(jobVO);
		}else {
			
			jobVO.setStart_time(now);
			taskDao.insert(jobVO);
			
		}
	}

	/**
	 * 任务运行
	 */
	@Transactional(propagation=Propagation.REQUIRED)
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

	/**
	 * 任务结束时调用 参数为空则任务无异常，
	 * 记录任务耗时，任务结束时间
	 * @param e
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	private void destory(Exception e) {
		end = System.currentTimeMillis();
		Date endTimer = new Date();		
		if (e != null) {
			log.info(task.getName()+"任务失败!");
			log.info(e.getMessage());
		}else {
			log.info(task.getName()+"任务执行成功!");
		}
		
		log.info("耗时：" + (end - start) / 1000 + "秒");
		log.info("结束于时间:"+endTimer);
		
		//更新任务结果
		jobVO.setEnd_time(endTimer);
		if(e!=null) {
			String msg = e.getMessage();
			if(msg.length()<4096) {
				jobVO.setException_msg(msg);							
			}else {
				jobVO.setException_msg(msg.substring(0, 4096));	
			}
		}else {
			jobVO.setResult("Y");
		}
		taskDao.updateTaskEnd(jobVO);
		
	}

}
