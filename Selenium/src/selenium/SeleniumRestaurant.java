package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SeleniumRestaurant {
    public static void main(String[] args) {
    	SeleniumRestaurant selTest = new SeleniumRestaurant();
        selTest.crawl();
    }
    
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Users/multicampus/Desktop/PJT3/chromedriver_win32/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumRestaurant() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://www.yogiyo.co.kr/mobile/#/284394/";
    }
 
    public void crawl() {
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
    		driver.get(base_url);
        	String html=driver.getPageSource();
    		Document doc= Jsoup.parseBodyFragment(html);            
    		Element element=doc.selectFirst("#content > div.restaurant-detail.row.ng-scope > div.col-sm-8 > div.restaurant-info > div.restaurant-title > span");
//    		driver.findElement(By.cssSelector("#content > div.restaurant-detail.row.ng-scope > div.col-sm-8 > ul > li:nth-child(3) > a")).click();
    		Element element2=doc.selectFirst("#info > div:nth-child(4) > p:nth-child(2) > span");
    		Element element3=doc.selectFirst("#info > div:nth-child(2) > p:nth-child(2) > span");
    		List<String> rList=new ArrayList<>();
    		String s=element.html()+","+element2.html()+","+element3.html()+","+","+",";
    		rList.add(s);
    		System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
 
    }
}