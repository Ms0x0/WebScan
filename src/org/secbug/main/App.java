package org.secbug.main;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;


public class App {

	public static void main(String[] args) {
	
		HttpClientDownloader  dower = new HttpClientDownloader();
		
		
     Spider.create(new HelloSpider()).addUrl("http://www.secbug.org").thread(5).run();
	

	}

}
