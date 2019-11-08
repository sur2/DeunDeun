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

public class FileReaderWriter2 {
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws IOException {
		System.setIn(new java.io.FileInputStream("C:/Users/multicampus/Desktop/cate.txt"));
		Scanner sc=new Scanner(System.in);
		Set<String> set=new HashSet<>();
		List<String> list=new ArrayList<String>();
		while(sc.hasNext()) {
			int N=set.size();
			String s=sc.nextLine();
			set.add(s);
			if(set.size()==N+1) {
				list.add(s);
			}			
		}
		int size=list.size();
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i)+"\n");
		}
		
		String s=sb.toString();
	    OutputStream input= new FileOutputStream("C:/Users/multicampus/Desktop/cate2.txt");
	    byte[] by=s.getBytes();
	    input.write(by);
	}
}

