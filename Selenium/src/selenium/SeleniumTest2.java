package selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SeleniumTest2 {
    public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:/Users/multicampus/Desktop/FoodData.txt"));
		Scanner sc=new Scanner(System.in);
		List<String> list=new ArrayList<>();
		sc.nextLine();
		int cnt=0;
		while(sc.hasNext()) {
			String s=sc.nextLine();
			list.add(s);
		}
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		SeleniumTest2 selTest = new SeleniumTest2();
    	
        selTest.crawl(list);
    }
 
    
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Users/multicampus/Desktop/PJT3/chromedriver_win32/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumTest2() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://www.yogiyo.co.kr/mobile/#/303548/";
    }
 
    public void crawl(List<String> list) {
    	
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
//            System.out.println(driver.getPageSource());
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
            
            int N=0;
            for (int i = 1; i < 15; i++) {
            	element=doc.selectFirst("#menu > div > div:nth-child("+i+") > div.panel-heading > h4 > a > span");
				if(element==null) {
					break;
				}
				N++;
			}				                        
            
//            System.out.println("N:"+N);
//            Set() 메뉴이름,
//            Map() 이름,가격,
            int M=0;
            for (int i = 2; i < N; i++) {
            	M=0;
                for (int j = 1; j < 25; j++) {
                	element=doc.selectFirst("#menu > div > div:nth-child("+i+") > div.panel-collapse.collapse.in.btn-scroll-container > div > ul > li:nth-child("+j+") > table > tbody > tr > td.menu-text > div.menu-name.ng-binding");
    				M++;
                	if(element==null) {
    					break;
    				}
    			}
//                System.out.println("M:"+M);
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
            int ss=list.size();
//            int sss=Integer.parseInt(list.get(ss-1).split(",")[0])+1;
            int sss=156;
            int food_cnt1=0;
        	for(int j=1;j<M;j++) {
        		element=doc.selectFirst("#menu > div > div:nth-child(2) > div.panel-collapse.collapse.in.btn-scroll-container > div > ul > li:nth-child("+j+") > table > tbody > tr > td.menu-text > div.menu-name.ng-binding");
        		for (String s:set) {
        			if(element.html().equals(s.split(",")[0])) {
        				food_cnt1++;
        				FoodList.add(sss+","+s+",1");
        			}
				}
        	}
            
        	int food_cnt2=food_cnt1;
    		for (String s:set) {
    			boolean flag=true;
    			for (int j = 0; j < FoodList.size(); j++) {
    				if(FoodList.get(j).split(",")[0].equals(s.split(",")[0])) {
    					flag=false;
    					break;
    				}
				}
    			if(flag) {
    				food_cnt2++;
    				FoodList0.add(sss+","+s+",0");
    			}
			}
			
            
            
			for (int i=0;i<FoodList.size();i++) {
				System.out.println(FoodList.get(i));
			}
              
			for (int i = 0; i < FoodList0.size(); i++) {
				System.out.println(FoodList0.get(i));
			}
			
			
        } catch (Exception e) {
            e.printStackTrace();
        
        } finally {
            driver.close();
        } 
    }
    
}
