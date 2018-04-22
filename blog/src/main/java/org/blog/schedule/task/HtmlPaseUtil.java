package org.blog.schedule.task;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlPaseUtil {
	static String url="http://www.cjcjihua.com/";
    public static void main( String[] args )
    {
    	try {
   
            Document root = Jsoup.connect(url).get();
            Elements div = root.getElementsByClass("showInfoBox");
            Elements rows = div.select("tbody>tr");
            for (Element element : rows) {
				System.out.println(element.text());
			}
            
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}finally {
    	}
    }
}
