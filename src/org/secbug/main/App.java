package org.secbug.main;



import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;


public class App {

	public static void main(String[] args) {
	
	
		
		
		Spider  spider =	Spider.create(new HelloSpider()).thread(5).addUrl("http://www.secbug.org");
		
		ConsolePipeline cpip = new ConsolePipeline() ;
		spider.addPipeline(cpip);
		HttpClientDownloader down  =	new HttpClientDownloader();
	
		down.setProxyProvider(SimpleProxyProvider.from(new Proxy("127.0.0.1",8888)));
		spider.setDownloader(down);
		
		//spider.test("http://www.secbug.org/");
		
		spider.run();
		
		System.out.println("…®√ËΩ· ¯");
	

	}

}
