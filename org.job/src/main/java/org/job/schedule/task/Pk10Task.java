package org.job.schedule.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.job.entity.T2018VO;
import org.job.schedule.jobs.DBDao;
import org.job.schedule.jobs.LoadFromHtml2VO;
import org.job.schedule.util.SuperTask;
import org.jsoup.nodes.Document;

/**
 * 定时任务例子
 * 
 * @author lang
 *
 */
public class Pk10Task extends SuperTask {
	private static final Logger log = LogManager.getLogger();

	public Pk10Task(String name) {
		super(name);
	}

	@Override
	public void task() throws Exception {
		log.info("Pk10Task......");
		Document root = LoadFromHtml2VO.getHHTMLFromURL();
		T2018VO plan = LoadFromHtml2VO.getNewPlan(root);
		// 插入计划
		if (DBDao.getVOByPk(plan.getBill_code()) == null) {
			// 计划不存在
			DBDao.insert(plan);
		}
		// 更新结果
		T2018VO res = LoadFromHtml2VO.getResult(root);
		T2018VO res_plan = DBDao.getVOByPk(res.getBill_code());
		if (res_plan != null) {
			if (res_plan.getPlan_content().contains(res.getN1())) {
				res.setResult("Y");
			}else {
				res.setResult("N");
			}
			DBDao.update(res);
		}
	}
}
