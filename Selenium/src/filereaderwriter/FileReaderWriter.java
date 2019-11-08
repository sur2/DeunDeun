package filereaderwriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FileReaderWriter {
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws IOException {
		System.setIn(new java.io.FileInputStream("C:/Users/multicampus/Desktop/FoodData.txt"));
		Scanner sc=new Scanner(System.in);
		Set<String> set=new HashSet<>();
		List<String> list=new ArrayList<String>();
		int cnt=0;
		while(sc.hasNext()) {
			int N=set.size();
			String s=sc.nextLine();
			set.add(s.split(",")[0]);
			if(set.size()==N+1) {
				cnt++;
			}			
			StringBuilder sb2=new StringBuilder();
			for (int i = 1; i < s.split(",").length; i++) {
				sb2.append(s.split(",")[i]);
				if(i!=s.split(",").length-1) {
					sb2.append(",");
				}
			}
			list.add((cnt)+","+sb2.toString());
		}
		int size=list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
			sb.append(list.get(i)+"\n");
		}
		
		String s=sb.toString();
	    OutputStream input= new FileOutputStream("C:/Users/multicampus/Desktop/output.txt");
	    byte[] by=s.getBytes();
	    input.write(by);
	}
}

