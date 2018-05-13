package org.job.jobs;

import java.util.Timer;
import java.util.TimerTask;

import org.job.entity.T2018VO;
import org.jsoup.nodes.Document;

public class TaskMain {
	public static void main(String[] args) {
		Timer t = new Timer(true);
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				getDataFrom();
			}
		}, 2000, 25000);
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void getDataFrom() {
		Document root = LoadFromHtml2VO.getHHTMLFromURL();
		if (root != null) {
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
				} else {
					res.setResult("N");
				}

				DBDao.update(res);
			}
		}

	}
}
