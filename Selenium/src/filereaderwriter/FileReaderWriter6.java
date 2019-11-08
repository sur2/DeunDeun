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

public class FileReaderWriter6 {
	static StringBuilder sb=new StringBuilder();
	static boolean used[]=new boolean[356];

	public static void main(String[] args) throws IOException {
		System.setIn(new java.io.FileInputStream("C:/Users/multicampus/Desktop/FoodReRe.txt"));
		Scanner sc=new Scanner(System.in);
//		Set<String> set=new HashSet<>();
		List<String> list=new ArrayList<String>();
		sc.nextLine();
		int cnt=1;
		Set<String> set=new HashSet<>();
		while(sc.hasNext()) {
			cnt++;
			String s=sc.nextLine();
			int size=set.size();
			set.add(s.split(",")[0]+","+s.split(",")[1]);
			if(set.size()!=size+1) {
				System.out.println(cnt);
			}
		}
	}
}

