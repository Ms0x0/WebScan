package org.secbug.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class HelloSpider implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

	
	@Override
	public void process(Page page) {
	
		System.out.println(page.getRequest().getHeaders());
		List<String> urls = 	page.getHtml().links().all();
		
		
		for(String url : urls)
		{
			
			
			
			if(url.startsWith("http://www.moonsos.com"))
			{
				try {
					String data = page.getRequest().getMethod() + ":" + page.getRequest().getUrl() 
							+ " : "+ page.getRequest().getCookies()+"\r\n" ;
					
					
					new FileOutputStream(new File("m.log"),true).write(data.getBytes());;
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				page.addTargetRequest(url);
			}
		}
	
		
		
	}

	@Override
	public Site getSite() {
	

		
		return site;
	}

}
