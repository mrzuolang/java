package org.blog.schedule.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.blog.jobs.pk10.DBDao;
import org.blog.jobs.pk10.LoadFromHtml2VO;
import org.blog.jobs.pk10.PK10VO;
import org.blog.schedule.util.SuperTask;
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
	public void init() {

	}

	@Override
	public void task() throws Exception {
		log.info("Pk10Task......");
		Document root = LoadFromHtml2VO.getHHTMLFromURL();
		PK10VO plan = LoadFromHtml2VO.getNewPlan(root);
		// 插入计划
		if (DBDao.getVOByPk(plan.getBill_code()) == null) {
			// 计划不存在
			DBDao.insert(plan);
		}
		// 更新结果
		PK10VO res = LoadFromHtml2VO.getResult(root);
		PK10VO res_plan = DBDao.getVOByPk(res.getBill_code());
		if (res_plan != null) {
			byte isHit = (byte) 0;
			if (res_plan.getPlan_content().contains(res.getN1())) {
				isHit = (byte) 1;
			}
			res.setResult(isHit);
			DBDao.update(res);
		}
	}
}
