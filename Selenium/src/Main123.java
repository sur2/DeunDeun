import java.util.Arrays;
import java.util.Scanner;

public class Main123 {
	static Scanner sc=new Scanner(System.in);
	static int N=sc.nextInt();
	static int M=sc.nextInt();
	static int T=sc.nextInt();
	static int map[][]=new int [N][M];
	static int cmd[][]=new int [T][3];
	static int dx[]= {1,0,-1,0};
	static int dy[]= {0,1,0,-1};
	static boolean visited[][]=new boolean [N][M];
	static boolean flag=false;
	static boolean pmFlag=false;
	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		for (int i = 0; i < T; i++) {
			cmd[i][0]=sc.nextInt();
			cmd[i][1]=sc.nextInt();
			cmd[i][2]=sc.nextInt();
		}
		
		for (int i = 0; i < T; i++) {
			int x=cmd[i][0];
			int d=cmd[i][1];
			int k=cmd[i][2];
			for (int j = 0; j < N; j++) {
				if((j+1)%x==0) {
					if(d==0) CW(map,j,k);
					else CCW(map,j,k);
				}
			}
			pmFlag=false;
			erase();
			if(!pmFlag) pmOne();
		}
		int ans=0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans+=map[i][j];
			}
		}
		System.out.println(ans);
	}
	
	public static void CCW(int arr[][],int x,int k) {
		for (int r = 0; r < k; r++) {
			int temp=arr[x][0];
			for (int i = 1; i < M; i++) {
				arr[x][i-1]=arr[x][i];
			}
			arr[x][M-1]=temp;
		}
	}
	
	public static void CW(int arr[][],int x,int k) {
		for (int r = 0; r < k; r++) {
			int temp=arr[x][M-1];
			for (int i = M-1; i > 0; i--) {
				arr[x][i]=arr[x][i-1];
			}
			arr[x][0]=temp;
		}
	}
	
	public static void go(int x, int y,int val) {
		visited[x][y%M]=true;
		int nx,ny;
		for (int i = 0; i < 4; i++) {
			nx=x+dx[i];
			ny=y+dy[i];
			if(ny==-1) ny=M-1;
			if(nx<0 || nx > N-1 || ny<0 || ny>M) continue;
			if(!visited[nx][(ny%M)] && map[nx][(ny%M)]==val) {
				visited[nx][(ny%M)]=true;
				flag=true;
				pmFlag=true;
				map[nx][(ny%M)]=0;
				go(nx,ny,val);
			}
		}
	}
	
	public static void erase() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j]=false;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j]!=0) {
					flag=false;
					go(i,j,map[i][j]);
					if(flag) map[i][j]=0;
				}
			}
		}
	}
	
	public static void pmOne() {
		int cnt=0;
		int sum=0;
		double avg=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=0) {
					cnt++;
					sum+=map[i][j];
				}
			}
		}
		if(cnt!=0) {
			avg=(double)sum/cnt;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==0) continue;
					if(map[i][j]>avg) {
						map[i][j]-=1;
					}else if(map[i][j]<avg){
						map[i][j]+=1;
					}
				}
			}
		}
	}
}
