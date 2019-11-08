package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class SeleniumLocationOne {
    public static void main(String[] args) throws FileNotFoundException {
    	SeleniumLocationOne selTest = new SeleniumLocationOne();

    	System.setIn(new java.io.FileInputStream("C:/Users/multicampus/Desktop/restaurant.txt"));
		Scanner sc=new Scanner(System.in);
		List<String> list=new ArrayList<String>();
		while(sc.hasNext()) {
			String s=sc.nextLine();
			list.add(s);
		}
		selTest.crawl(list);
    }
    
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Users/multicampus/Desktop/PJT3/chromedriver_win32/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumLocationOne() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://map.naver.com/";
    }
 
    public void crawl(List<String> list) {
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
                driver.get(base_url);
//              System.out.println(driver.getPageSource());
	            driver.findElement(By.cssSelector("#search-input")).clear();
	            String str="펄스맥팩토리";
	            driver.findElement(By.cssSelector("#search-input")).sendKeys(str);
	            driver.findElement(By.cssSelector("#search-input")).sendKeys(Keys.RETURN);
	            Thread.sleep(2000);

	            String url=driver.getCurrentUrl();
	            String html=driver.getPageSource();
	            Document doc= Jsoup.parseBodyFragment(html);

	            String address,tel;
	            Element element=doc.selectFirst("#panel > div.panel_content.nano.has-scrollbar > div.scroll_pane.content > div.panel_content_flexible > div.search_result > ul > li > div.lsnx > dl > dd.addr");
        		if(element==null) address="NULL";
        		else address=element.text().replace(" 지번", "");
        		
        		element=doc.selectFirst("#panel > div.panel_content.nano.has-scrollbar > div.scroll_pane.content > div.panel_content_flexible > div.search_result > ul > li > div.lsnx > dl > dd.tel");        		
        		if(element==null) tel="NULL";
        		else tel=element.text();
        		
	            System.out.print(str+","+address+","+tel);
	            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
 
    }
}