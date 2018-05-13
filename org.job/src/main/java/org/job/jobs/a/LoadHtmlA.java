package org.job.jobs.a;

import org.job.entity.T2018VO;
import org.job.jobs.URLs;
import org.job.jobs.common.AbsLoadHtml;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LoadHtmlA extends AbsLoadHtml{
	private final String webName="A";

	@Override
	public T2018VO readNewPlanFromDocument() {
		Document root = this.loadDocumentFromURL(URLs.map.get(webName));
		T2018VO vo = new T2018VO();
		Elements div = root.getElementsByClass("showInfoBox");
		Elements rows = div.select("tbody>tr");
		Element element = rows.get(0);
		String text = element.text();
		String[] words = text.split(" ");
		vo.setBill_code(Long.parseLong(words[2]));
		vo.setPlan_code(words[0]);
		String[] nums = words[1].split(",");
		StringBuffer sb = new StringBuffer();
		for (String num : nums) {
			sb.append((num.length()==1?"0"+num:num));
			sb.append(",");
		}
		vo.setPlan_content(sb.toString().substring(0, sb.length()));
		vo.setNum_one(words[3]);
		return vo;
	}

}
