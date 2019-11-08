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

public class SeleniumFood {
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:/Users/multicampus/Desktop/RestaurantData.txt"));
		Scanner sc=new Scanner(System.in);
		List<String> list=new ArrayList<>();
		sc.nextLine();
		int cnt=0;
		while(sc.hasNext()) {
			String s=sc.nextLine();
			list.add((++cnt)+","+s);
		}
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		SeleniumFood selTest = new SeleniumFood();
    	
        selTest.crawl(list);
    }
 
    
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Users/multicampus/Desktop/PJT3/chromedriver_win32/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumFood() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://www.yogiyo.co.kr/mobile/#/";
    }
 
    public void crawl(List<String> list) {
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
        	int size=list.size();
        	int ssss=305;
        	int ingi=2;
        	for (int k = ssss; k < ssss+1; k++) {
        		JavascriptExecutor jse = (JavascriptExecutor)driver;

        		driver.get(base_url);
        		Thread.sleep(1000);
        		driver.findElement(By.cssSelector("#search > div > form > input")).clear();
        		driver.findElement(By.cssSelector("#search > div > form > input")).sendKeys("대전광역시 유성구 덕명동 16-1 한밭대학교");            
        		driver.findElement(By.cssSelector("#button_search_address > button.btn.btn-default.ico-pick")).click();
        		Thread.sleep(1000);

	    		driver.get(driver.getCurrentUrl());
	//            System.out.println(driver.getPageSource());
	    		
	    		driver.findElement(By.cssSelector("#category > ul > li.hidden-xs.menu-search > a")).click();
	    		driver.findElement(By.cssSelector("#category > ul > li.main-search > form > div > input")).clear();
        		driver.findElement(By.cssSelector("#category > ul > li.main-search > form > div > input")).sendKeys(list.get(k).split(",")[1]);            
        		driver.findElement(By.cssSelector("#category > ul > li.main-search > form > div > input")).sendKeys(Keys.RETURN);
	    		
        		Thread.sleep(1000);
        		Actions actions = new Actions(driver);
        		
        		String restSizeStr=jse.executeScript("return document.querySelector('#content > div > div.restaurant-list').childElementCount;").toString();
	            int restSize=Integer.parseInt(restSizeStr);
	            System.out.println(restSize);
	            int restNum=0;
	            for (int i = 2; i < restSize+1; i++) {
		            WebElement webE=driver.findElement(By.cssSelector("#content > div > div.restaurant-list > div:nth-child("+i+") > div > table > tbody > tr > td:nth-child(2) > div > div.restaurant-name.ng-binding"));
	            	String restName=webE.getText();
	        		if(restName.equals(list.get(k).split(",")[1])) {
	        			restNum=i;
	        			break;
	        		}
				}
	            if(restNum==0) continue;
        		actions.moveToElement(driver.findElement(By.cssSelector("#content > div > div.restaurant-list > div:nth-child("+restNum+") > div > table > tbody > tr > td:nth-child(2) > div > div.restaurant-name.ng-binding"))).click().perform();
        		Thread.sleep(3000);
        		
        		driver.get(driver.getCurrentUrl());
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
	            for (int i = ingi; i < menuSize; i++) {
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
	            	element=doc.selectFirst("#menu > div > div:nth-child("+ingi+") > div.panel-collapse.collapse.in.btn-scroll-container > div > ul > li:nth-child("+j+") > table > tbody > tr > td.menu-text > div.menu-name.ng-binding");
					M++;
	            	if(element==null) {
						break;
					}
				}
	            
	            // 인기메뉴에 있는 모든 메뉴를 크롤링 
	        	for(int j=1;j<M;j++) {
	        		element=doc.selectFirst("#menu > div > div:nth-child("+ingi+") > div.panel-collapse.collapse.in.btn-scroll-container > div > ul > li:nth-child("+j+") > table > tbody > tr > td.menu-text > div.menu-name.ng-binding");
	        		for (String s:set) {
	        			if(element.html().equals(s.split(",")[0])) {
	        				FoodList.add((k+1)+","+s+",1");
	        			}
					}
	        	}
	            
	        	//
	    		for (String s:set) {
	    			boolean flag=true;
	    			for (int j = 0; j < FoodList.size(); j++) {
	    				if(FoodList.get(j).split(",")[1].equals(s.split(",")[0])) { // 인기메뉴에 있으면
	    					flag=false;
	    					break;
	    				}
					}
	    			if(flag) {
	    				if(s.split(",")[0].equals("짜장면")) {
	    					int a=0;
	    				}
	    				FoodList0.add((k+1)+","+s+",0");
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
        	}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        } 
    }
    
}
