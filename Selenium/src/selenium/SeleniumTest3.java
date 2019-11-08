package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SeleniumTest3 {
    public static void main(String[] args) {
        SeleniumTest3 selTest = new SeleniumTest3();
        selTest.crawl();
    }
 
    
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Users/multicampus/Desktop/PJT3/chromedriver_win32/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumTest3() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://www.yogiyo.co.kr/mobile/#/";
    }//
    public void crawl() {
        try {
        	for (int i = 2; i < 20; i++) {
        		JavascriptExecutor jse = (JavascriptExecutor)driver;
        		//get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
        		driver.get(base_url);
        		//            System.out.println(driver.getPageSource());
        		Thread.sleep(2000);
        		//            driver.findElement(By.cssSelector("#content > div > div.restaurant-list > div:nth-child(2) > div > table > tbody > tr > td:nth-child(2) > div > div.restaurant-name.ng-binding")).click();
        		driver.findElement(By.cssSelector("#search > div > form > input")).clear();
        		driver.findElement(By.cssSelector("#search > div > form > input")).sendKeys("대전광역시 유성구 덕명동 16-1 한밭대학교");            
        		driver.findElement(By.cssSelector("#button_search_address > button.btn.btn-default.ico-pick")).click();            
        		Thread.sleep(1000);
        		for (int j = 0; j < 2; j++) {
        			jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
        			Thread.sleep(1000);
        		}
        		Thread.sleep(1000);
        		jse.executeScript("window.scrollTo(0,0);");
        		
        		Actions actions = new Actions(driver);
        		actions.moveToElement(driver.findElement(By.cssSelector("#content > div > div.restaurant-list > div:nth-child("+i+") > div > table > tbody > tr > td:nth-child(2) > div > div.restaurant-name.ng-binding"))).click().perform();
        		
//        		driver.findElement(By.cssSelector("#content > div > div.restaurant-list > div:nth-child("+i+") > div > table > tbody > tr > td:nth-child(2) > div > div.restaurant-name.ng-binding")).click();
        		Thread.sleep(1000);
        		driver.findElement(By.cssSelector("#content > div.restaurant-detail.row.ng-scope > div.col-sm-8 > ul > li:nth-child(3) > a")).click() ;
        		Thread.sleep(1000);            
        		driver.get(driver.getCurrentUrl());
        		Thread.sleep(1000);
        		String html=driver.getPageSource();
        		Document doc= Jsoup.parseBodyFragment(html);            
        		Element element=doc.selectFirst("#content > div.restaurant-detail.row.ng-scope > div.col-sm-8 > div.restaurant-info > div.restaurant-title > span");
        		driver.findElement(By.cssSelector("#content > div.restaurant-detail.row.ng-scope > div.col-sm-8 > ul > li:nth-child(3) > a")).click();
        		Element element2=doc.selectFirst("#info > div:nth-child(4) > p:nth-child(2) > span");
        		Element element3=doc.selectFirst("#info > div:nth-child(2) > p:nth-child(2) > span");
        		List<String> rList=new ArrayList<>();
        		String s=element.html()+","+element2.html()+","+element3.html()+","+","+",";
        		rList.add(s);
        		System.out.println(s);
        		Thread.sleep(1000);            
			}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }
}