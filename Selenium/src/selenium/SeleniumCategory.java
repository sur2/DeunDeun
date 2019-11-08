package selenium;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCategory {
    public static void main(String[] args) {
        SeleniumCategory selTest = new SeleniumCategory();
        selTest.crawl();
    }
    
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Users/multicampus/Desktop/PJT3/chromedriver_win32/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumCategory() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://www.yogiyo.co.kr/mobile/#/";
    }
 
    public void crawl() {
       
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
    		JavascriptExecutor jse = (JavascriptExecutor)driver;
    		//get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
    		driver.get(base_url);
    		//            System.out.println(driver.getPageSource());
    		Thread.sleep(2000);
    		//            driver.findElement(By.cssSelector("#content > div > div.restaurant-list > div:nth-child(2) > div > table > tbody > tr > td:nth-child(2) > div > div.restaurant-name.ng-binding")).click();
    		driver.findElement(By.cssSelector("#search > div > form > input")).clear();
    		driver.findElement(By.cssSelector("#search > div > form > input")).sendKeys("대전광역시 유성구 덕명동 16-1 한밭대학교");            
    		driver.findElement(By.cssSelector("#button_search_address > button.btn.btn-default.ico-pick")).click();
    		List<String> list=new ArrayList<String>();
    		Thread.sleep(2000);
    		int cnt=1;
    		for (int i = 3; i < 14; i++) {
    			list.add((++cnt)+","+driver.findElement(By.cssSelector("#category > ul > li:nth-child("+i+") > span")).getText());
			}
    		
    		for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
 
    }
}
