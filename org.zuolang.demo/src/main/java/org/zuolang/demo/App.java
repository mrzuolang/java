package org.zuolang.demo;

import java.util.Timer;
import java.util.TimerTask;

import org.jsoup.nodes.Document;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		Timer timer = new Timer("定时任务");
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Action();
			}
		}, 1000,3000);
	}

	public static void Action() {
		Document root = LoadFromHtml2VO.getHHTMLFromURL();
		PK10VO plan = LoadFromHtml2VO.getNewPlan(root);
		//插入计划
		if(DBDao.getVOByPk(plan.getBill_code())==null) {
			//计划不存在
			DBDao.insert(plan);
		}
		//更新结果
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
