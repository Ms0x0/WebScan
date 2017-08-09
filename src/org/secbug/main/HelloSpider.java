package org.secbug.main;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class HelloSpider implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).
    		setTimeOut(10000).addHeader("Content-Encoding", "gzip").
    		addHeader("Connection", "keep-alive").
    		addHeader("Referer", "https://github.com/Ms0x0").
    		addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36");

	
 
    
    
	@Override
	public void process(Page page) {
	
		System.out.println(page.getRequest());
		List<String> urls = 	page.getHtml().links().all();
		
		
		for(String url : urls){
			
			if(url.startsWith("http://www.secbug.org"))
			{
				
				page.addTargetRequest(url);
			}
		}
	
		
		
	}

	@Override
	public Site getSite() {
	

		
		return site;
	}

}
