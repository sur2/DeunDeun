package filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FileReader2 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new java.io.FileInputStream("C:/Users/multicampus/Desktop/addtel.txt"));
		Scanner sc=new Scanner(System.in);
		Set<String> set=new HashSet<>();
		List<String> list=new ArrayList<String>();
		int cnt=0;
		while(sc.hasNext()) {
			int N=set.size();
			String s=sc.nextLine();
			s=s.replace(" Áö¹ø", "");
			list.add(s);
		}
		int size=list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
		
	}
}
