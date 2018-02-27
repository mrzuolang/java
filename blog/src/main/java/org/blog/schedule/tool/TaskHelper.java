package org.blog.schedule.tool;

import org.blog.dao.TaskDao;
import org.blog.dao.TaskhistoryDao;
import org.blog.util.DateUtil;
import org.blog.util.VOUtil;
import org.blog.vo.TaskVO;
import org.blog.vo.TaskhistoryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	private TaskDao taskDao;
	private TaskVO taskVO=null;
	
	@Autowired
	private TaskhistoryDao taskhistoryDao;

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
	private void prepare() {
		start = System.currentTimeMillis();
		String startTimer = DateUtil.getDateTime(start);
		log.info(LINE + task.getName()+LINE);
		log.info("开始时间从："+startTimer);
		
		//记录任务开始时间
		taskVO = taskDao.findByName(task.getName());
		if(taskVO==null) {
			taskVO = new TaskVO();
			taskVO.setTask_name(task.getName());
			taskVO.setStart_time(startTimer);
			taskVO.setTs(startTimer);
			taskVO.setClass_name(task.getClass().getName());
			taskDao.insert(taskVO);
		}else {
			
			taskVO.setStart_time(startTimer);
			taskVO.setTs(startTimer);
			TaskhistoryVO historyVO = VOUtil.getTaskVO(taskVO);
			taskhistoryDao.insert(historyVO);
			taskDao.deleteByPk(taskVO.getTask_id());
			taskDao.insert(taskVO);
			
		}
	}

	/**
	 * 任务运行
	 */
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
		
		//更新任务结果
		taskVO.setEnd_time(endTimer);
		if(e!=null) {
			String msg = e.getMessage();
			if(msg.length()<4096) {
				taskVO.setException_msg(msg);							
			}else {
				taskVO.setException_msg(msg.substring(0, 4096));	
			}
		}else {
			taskVO.setResult("任务正常结束");
		}
		taskDao.updateTaskEnd(taskVO);
		
	}

}
