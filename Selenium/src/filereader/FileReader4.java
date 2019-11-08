package filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FileReader4 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new java.io.FileInputStream("C:/Users/multicampus/Desktop/r2c.txt"));
		Scanner sc=new Scanner(System.in);
		Set<String> set=new HashSet<>();
		List<String> list=new ArrayList<String>();
		while(sc.hasNext()) {
			int N=set.size();
			String s=sc.nextLine();
			set.add(s.split(",")[0]);
			
			if(set.size()==N+1) {
				list.add(s);
			}
		}
		int size=list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
		
	}
}
