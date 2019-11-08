package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SeleniumFoodOne {
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws FileNotFoundException {
		SeleniumFoodOne selTest = new SeleniumFoodOne();
        selTest.crawl();
    }
 
    
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Users/multicampus/Desktop/PJT3/chromedriver_win32/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumFoodOne() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://www.yogiyo.co.kr/mobile/#/279477/";
    }
 
    public void crawl() {
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
        		JavascriptExecutor jse = (JavascriptExecutor)driver;
        		int count=353;
        		driver.get(base_url);
        		Thread.sleep(1000);
	            String html=driver.getPageSource();
	            Document doc= Jsoup.parseBodyFragment(html);
	            Element element=doc.selectFirst("#content > div.restaurant-detail.row.ng-scope > div.col-sm-8 > div.restaurant-info > div.restaurant-title > span");
	            Element element2 = null;
	            Element element3 = null;
	            
	            String restaurent_name="";
				restaurent_name=(element.html());
	            
	            System.out.println(restaurent_name);
	            
	            List<String> FoodList = new ArrayList<>();
	            List<String> FoodList0 = new ArrayList<>();
	            Set<String> set=new HashSet<>();
        		
	            Thread.sleep(1000);
	            driver.get(driver.getCurrentUrl());
	            String menuSizeStr=jse.executeScript("return document.querySelector('#menu > div').childElementCount;").toString();
	            System.out.println(menuSizeStr);
	            int menuSize=Integer.parseInt(menuSizeStr);
	            System.out.println(menuSize);			                        
	            
	//            Set() 메뉴이름,
	//            Map() 이름,가격,
	            int M=0;
	            for (int i = 2; i < menuSize; i++) {
	            	M=0;
	                for (int j = 1; j < 25; j++) {
	                	element=doc.selectFirst("#menu > div > div:nth-child("+i+") > div.panel-collapse.collapse.in.btn-scroll-container > div > ul > li:nth-child("+j+") > table > tbody > tr > td.menu-text > div.menu-name.ng-binding");
	    				M++;
	                	if(element==null) {
	    					break;
	    				}
	    			}
	            	for(int j=1;j<M;j++) {
	            		element=doc.selectFirst("#menu > div > div:nth-child("+i+") > div.panel-collapse.collapse.in.btn-scroll-container > div > ul > li:nth-child("+j+") > table > tbody > tr > td.menu-text > div.menu-name.ng-binding");
	                	element2=doc.selectFirst("#menu > div > div:nth-child("+i+") > div.panel-collapse.collapse.in.btn-scroll-container > div > ul > li:nth-child("+j+") > table > tbody > tr > td.menu-text > div.menu-price > span.text-strike.ng-binding");
	                	element3=doc.selectFirst("#menu > div > div:nth-child("+i+") > div.panel-collapse.collapse.in.btn-scroll-container > div > ul > li:nth-child("+j+") > table > tbody > tr > td.photo-area > div");
	                	
	                	String temp=element2.html().split("원")[0];
	                	String price;
	                	String img_url=element3.attr("style");
	                	if(temp.length()>3) {
	                		price=temp.split(",")[0]+temp.split(",")[1];
	                	}else {
	                		price=temp;
	                	}
	                	String img=img_url.split("'")[1];
	                	if(img_url.split("'")[1].equals("") || img_url.split("'")[1].equals(null)) {
	                		img="NULL";
	                	}
	        			set.add(element.html()+","+price+","+img);
	            	}
				}
	            
	            
	        	M=0;
	            for (int j = 1; j < 25; j++) {
	            	element=doc.selectFirst("#menu > div > div:nth-child(2) > div.panel-collapse.collapse.in.btn-scroll-container > div > ul > li:nth-child("+j+") > table > tbody > tr > td.menu-text > div.menu-name.ng-binding");
					M++;
	            	if(element==null) {
						break;
					}
				}
	        	for(int j=1;j<M;j++) {
	        		element=doc.selectFirst("#menu > div > div:nth-child(2) > div.panel-collapse.collapse.in.btn-scroll-container > div > ul > li:nth-child("+j+") > table > tbody > tr > td.menu-text > div.menu-name.ng-binding");
	        		for (String s:set) {
	        			if(element.html().equals(s.split(",")[0])) {
	        				FoodList.add(count+","+s+",1");
	        			}
					}
	        	}
	            
	    		for (String s:set) {
	    			boolean flag=true;
	    			for (int j = 0; j < FoodList.size(); j++) {
	    				if(FoodList.get(j).split(",")[1].equals(s.split(",")[0])) {
	    					flag=false;
	    					break;
	    				}
					}
	    			if(flag) {
	    				FoodList0.add(count+","+s+",0");
	    			}
				}
				
	            
	            
				for (int i=0;i<FoodList.size();i++) {
					sb.append(FoodList.get(i)+"\n");
				}
	              
				for (int i = 0; i < FoodList0.size(); i++) {
					sb.append(FoodList0.get(i)+"\n");
				}
				
				String s=sb.toString();
				OutputStream input= new FileOutputStream("C:/Users/multicampus/Desktop/outputPerson.txt");
				byte[] by=s.getBytes();
				input.write(by);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        } 
    }
    
}
