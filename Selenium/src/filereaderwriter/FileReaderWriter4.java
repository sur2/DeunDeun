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

public class FileReaderWriter4 {
	static StringBuilder sb=new StringBuilder();
	static boolean used[]=new boolean[356];

	public static void main(String[] args) throws IOException {
		System.setIn(new java.io.FileInputStream("C:/Users/multicampus/Desktop/FoodReRe.txt"));
		Scanner sc=new Scanner(System.in);
		Set<String> set=new HashSet<>();
		List<String> list=new ArrayList<String>();
		sc.nextLine();
		while(sc.hasNext()) {
			String s=sc.nextLine();
			used[Integer.parseInt(s.split(",")[0])]=true;
		}
		for (int i = 1; i < 356; i++) {
			if(!used[i]) {
				System.out.println(i);
			}
		}
	}
}

