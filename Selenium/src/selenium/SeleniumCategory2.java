package selenium;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCategory2 {
	static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) {
        SeleniumCategory2 selTest = new SeleniumCategory2();
        selTest.crawl();
    }
    
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Users/multicampus/Desktop/PJT3/chromedriver_win32/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumCategory2() {
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
    		driver.get(base_url);
    		//            System.out.println(driver.getPageSource());
    		Thread.sleep(2000);
    		//            driver.findElement(By.cssSelector("#content > div > div.restaurant-list > div:nth-child(2) > div > table > tbody > tr > td:nth-child(2) > div > div.restaurant-name.ng-binding")).click();
    		driver.findElement(By.cssSelector("#search > div > form > input")).clear();
    		driver.findElement(By.cssSelector("#search > div > form > input")).sendKeys("대전광역시 유성구 덕명동 16-1 한밭대학교");            
    		driver.findElement(By.cssSelector("#button_search_address > button.btn.btn-default.ico-pick")).click();
    		Thread.sleep(2000);
    		int cnt=1;
    		for (int i = 3; i < 14; i++) {
    			List<String> list=new ArrayList<String>();
    			driver.findElement(By.cssSelector("#category > ul > li:nth-child("+i+") > span")).click();
    			Thread.sleep(1000);
    			for (int j = 0; j < 10; j++) {
        			jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
        			Thread.sleep(1000);
        		}
    			String s1=jse.executeScript("return document.querySelector('#content > div > div.restaurant-list').childElementCount;").toString();
    			int size=Integer.parseInt(s1);
    			System.out.println(size);
    			for (int j = 2; j <= size; j++) {
    				String path="#content > div > div.restaurant-list > div:nth-child("+j+") > div > table > tbody > tr > td:nth-child(2) > div > div.restaurant-name.ng-binding";
    				String s2=driver.findElement(By.cssSelector(path)).getText();
					sb.append(cnt+","+s2+"\n");
				}
    			cnt++;
			}
    		
    	      String s=sb.toString();
    	      OutputStream input= new FileOutputStream("C:/Users/multicampus/Desktop/cate.txt");
    	      byte[] by=s.getBytes();
    	      input.write(by);
    		
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
 
    }
}
