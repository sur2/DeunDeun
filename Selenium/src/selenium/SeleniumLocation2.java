package selenium;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocation2 {
	static List<String> list=new ArrayList<String>();
	static List<String> list2=new ArrayList<String>();
    public static void main(String[] args) throws FileNotFoundException {
    	SeleniumLocation2 selTest = new SeleniumLocation2();
    	System.setIn(new java.io.FileInputStream("C:/Users/multicampus/Desktop/restaurant.txt"));
    	Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			String s=sc.nextLine();
			list.add(s);
		}
		
		System.setIn(new java.io.FileInputStream("C:/Users/multicampus/Desktop/addtel.txt"));
		sc=new Scanner(System.in);
		while(sc.hasNext()) {
			String s=sc.nextLine();
			list2.add(s);
		}
		
		selTest.crawl(list2,list);
    }
    
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/Users/multicampus/Desktop/PJT3/chromedriver_win32/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumLocation2() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "http://www.dawuljuso.com";
    }
 
    public void crawl(List<String> list,List<String> abc) {
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
        	int s=list.size();
        	for (int i = 1; i < s; i++) {
                driver.get(base_url);
//              System.out.println(driver.getPageSource());
	            driver.findElement(By.cssSelector("#input_juso")).clear();
	            driver.findElement(By.cssSelector("#input_juso")).sendKeys(list.get(i).split(",")[1]);
	            driver.findElement(By.cssSelector("#input_juso")).sendKeys(Keys.RETURN);
	            Thread.sleep(1000);

	            String url=driver.getCurrentUrl();
	            String html=driver.getPageSource();
	            Document doc= Jsoup.parseBodyFragment(html);

	            String location_x,location_y;
	            Element element=doc.selectFirst("#insert_data_5");
        		if(element==null) {
        			location_x="NULL";
        			location_y="NULL";
        		}
        		else {
        			location_x=element.text().split(",")[0].split(":")[1];
        			location_y=element.text().split(",")[1].split(":")[1];
        			if(location_x.equals("x좌표없음") && location_y.equals("y좌표없음")) {
        				location_x="NULL";
            			location_y="NULL";
        			}
        		}
        		
	            System.out.print(abc.get(i).split(",")[0]+","+abc.get(i).split(",")[1]+","+abc.get(i).split(",")[2]+","+list.get(i).split(",")[2]+","+location_x+","+location_y);
	            System.out.println();
			}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
 
    }
}
