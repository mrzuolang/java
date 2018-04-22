package org.zuolang.demo;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	List<PK10VO> list = LoadFromHtml2VO.loadFromURL();
    	for (PK10VO pk10vo : list) {
    		DBDao.insert(pk10vo);
		}    	
    }
}
