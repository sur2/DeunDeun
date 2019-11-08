package filewriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileWriter {
   static StringBuilder sb=new StringBuilder();
   static int N;
   public static void main(String[] args) throws IOException {
      int N=(int)(Math.random()*100+1);
      sb.append(N);
      sb.append("\n");
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < 2; j++) {
            int a=(int)(Math.random()*100+1);
            sb.append(a+" ");
         }
         sb.append("\n");
      }
      String s=sb.toString();
      OutputStream input= new FileOutputStream("C:/Users/multicampus/Desktop/input.txt");
      byte[] by=s.getBytes();
      input.write(by);
      
      System.out.println(s);
   }
}