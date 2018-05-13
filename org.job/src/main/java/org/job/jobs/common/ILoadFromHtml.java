package org.job.jobs.common;

import org.job.entity.T2018VO;
import org.jsoup.nodes.Document;

public interface ILoadFromHtml {
	public Document loadDocumentFromURL(String url);
	
	public T2018VO getResult();
	
	public T2018VO readNewPlanFromDocument();
}
