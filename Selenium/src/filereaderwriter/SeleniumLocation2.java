package filereaderwriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocation2 {
	static StringBuilder sb=new StringBuilder();
	
	static List<String> list=new ArrayList<String>();
	static List<String> list2=new ArrayList<String>();
    public static void main(String[] args) throws IOException {
    	SeleniumLocation2 selTest = new SeleniumLocation2();
    	System.setIn(new java.io.FileInputStream("C:/Users/multicampus/Desktop/RestaurantData.txt"));
    	Scanner sc=new Scanner(System.in);
    	sc.nextLine();
		while(sc.hasNext()) {
			String s=sc.nextLine();
			list.add(s);
		}
		
		System.setIn(new java.io.FileInputStream("C:/Users/multicampus/Desktop/cate2.txt"));
		sc=new Scanner(System.in);
		while(sc.hasNext()) {
			String s=sc.nextLine();
			list2.add(s);
		}
		
		int size1=list.size();
		int size2=list2.size();
		
		Map<String, Integer> map=new HashMap<>();
		
		for (int i = 0; i < size1; i++) {
			map.put(list.get(i).split(",")[0], i+1);
		}
		
		for (int i = 0; i < size2; i++) {
			if(map.containsKey(list2.get(i).split(",")[1])) {
				sb.append(list2.get(i).split(",")[0]+","+map.get(list2.get(i).split(",")[1])+"\n");
			}
		}
		
		
		String s=sb.toString();
	    OutputStream input= new FileOutputStream("C:/Users/multicampus/Desktop/r2c.txt");
	    byte[] by=s.getBytes();
	    input.write(by);
    }
}
