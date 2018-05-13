package org.job.jobs.common;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.job.entity.T2018VO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class AbsLoadHtml implements ILoadFromHtml{
	private final Logger log = LogManager.getLogger(AbsLoadHtml.class);

	@Override
	public Document loadDocumentFromURL(String url) {
		Document root = null;
		try {
			root = Jsoup.connect(url).timeout(120000).get();
		} catch (IOException e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
		return root;
	}
	
	@Override
	public T2018VO getResult() {
		
		return null;
	}
}
