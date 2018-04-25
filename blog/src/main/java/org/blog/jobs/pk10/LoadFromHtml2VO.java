package org.blog.jobs.pk10;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.blog.util.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LoadFromHtml2VO {
	private static final Logger log = LogManager.getLogger();

	static String url = "http://www.cjcjihua.com/";

	public static Document getHHTMLFromURL() {
		Document root = null;
		try {
			root = Jsoup.connect(url).timeout(120000).get();
		} catch (IOException e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
		return root;
	}

	public static PK10VO getResult(Document root) {
		String bill_code = root.getElementById("time").parent().text();
		if(bill_code==null || bill_code.length()<1) {
			return null;
		}
		bill_code = bill_code.substring(0, bill_code.indexOf("期"));
		log.info(bill_code);
		PK10VO vo = new PK10VO();
		vo.setBill_code(bill_code);
		String numsText = root.getElementsByClass("bgList").text();
		log.info(numsText);
		if(numsText==null || numsText.length()<1) {
			return null;
		}
		String[] nums = numsText.split(" ");
		vo.setN1(nums[0]);
		vo.setN2(nums[1]);
		vo.setN3(nums[2]);
		vo.setN4(nums[3]);
		vo.setN5(nums[4]);
		vo.setN6(nums[5]);
		vo.setN7(nums[6]);
		vo.setN8(nums[7]);
		vo.setN9(nums[8]);
		vo.setN10(nums[9]);
		log.info(vo);
		return vo;
	}

	public static PK10VO getNewPlan(Document root) {
		PK10VO vo = new PK10VO();
		Elements div = root.getElementsByClass("showInfoBox");
		Elements rows = div.select("tbody>tr");
		Element element = rows.get(0);
		String text = element.text();
		String[] words = text.split(" ");
		vo.setBill_code(words[2]);
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
