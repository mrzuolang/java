package org.zuolang.demo;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LoadFromHtml2VO {
	static String url="http://www.cjcjihua.com/";
    public static List<PK10VO> loadFromURL()
    {
    	List<PK10VO>list = new ArrayList<PK10VO>();
    	try {
            Document root = Jsoup.connect(url).get();
            Elements div = root.getElementsByClass("showInfoBox");
            Elements rows = div.select("tbody>tr");
            for (Element element : rows) {
            	String text = element.text();
            	if(text!=null&&text.trim().length()>0) {
            		PK10VO vo = new PK10VO();
            		String[] words = text.split(" ");
            		vo.setBill_code(words[2]);
            		vo.setPlan_code(words[0]);
            		vo.setPlan_code(words[1]);
            		vo.setNum_one(words[3]);
            		vo.setResult("中".equals(words[4].toString())?Byte.parseByte("1"):Byte.parseByte("0"));
            		System.out.println(vo);
            		list.add(vo);
            	}
			}
            
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}finally {
    	}
    	return list;
    }
}
