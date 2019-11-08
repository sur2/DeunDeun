import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc=new Scanner(System.in);
	static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
    	int N; // 점의 개수
    	N=739;
    	
    	Coordinate[] coord;
        coord = new Coordinate[N];

        for (int i = 0; i < N; i++) {
        	String s=sc.nextLine();
        	int c1=Integer.parseInt(s.split(",")[0]);
        	int c2=Integer.parseInt(s.split(",")[1]);
            coord[i] = new Coordinate(c1, c2);
        }

        Arrays.sort(coord);
        
		for (int i = 0; i < coord.length; i++) {
			sb.append(coord[i].x+","+coord[i].y+"\n");
		}
		
		String s=sb.toString();
	    OutputStream input= new FileOutputStream("C:/Users/multicampus/Desktop/cate2.txt");
	    byte[] by=s.getBytes();
	    input.write(by);
    }
}

class Coordinate implements Comparable<Coordinate> {

    int x;
    int y;

    Coordinate(int x, int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate o) {

        return this.x < o.x ? -1 : this.x > o.x ? 1 : this.y < o.y ? -1 : 1;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
