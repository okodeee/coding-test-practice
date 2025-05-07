import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static int dice[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n=Integer.parseInt(br.readLine());
		dice=new int[n][6];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max= 0 ;
		for(int i=0;i<6;i++) {
			int sum = maxDice(i);
			max=Math.max(sum,max);
		}

		System.out.println(max);


	}
	public static int maxDice(int idx) {
		
		//newDice의 0번째 인덱스는 윗면, 1번째 인덱스는 아랫면으로 봄.
		int newDice[] = new int[2];
		//윗면을 구함.
		newDice[0] = dice[0][idx];
		//윗면에 따라서 아랫면을 구함.
		//주사위의 전개도를 보면 알 수 있음.
		switch(idx) {
		case 0: newDice[1] = dice[0][5]; break;
		case 1: newDice[1] = dice[0][3]; break;
		case 2: newDice[1] = dice[0][4]; break;
		case 3: newDice[1] = dice[0][1]; break;
		case 4: newDice[1] = dice[0][2]; break;
		case 5: newDice[1] = dice[0][0]; break;
		}
		int sum = 0;
		//sum은 윗면, 아랫면이 아닌 것들 중 가장 높은 숫자
		for(int i=0;i<6;i++) {
			if(dice[0][i]==newDice[0]||dice[0][i]==newDice[1]) continue;
			sum=Math.max(sum,dice[0][i]);
		}
		
		for(int i=1;i<dice.length;i++) {
			int max = 0;
			newDice = dice(i,newDice[0]);
			for(int j=0;j<dice[0].length;j++) {
				if(dice[i][j]==newDice[0]||dice[i][j]==newDice[1]) continue;
				max=Math.max(max,dice[i][j]);
			}
			sum+=max;

			
		}

		return sum;
	}

	public static int [] dice (int idx,int prevTop) {
	
		//다음 주사위의 아랫면 숫자는 이전 주사위의 윗면 숫자
		int bottom = prevTop;

		//다음 주사위의 윗면을 구함
		int top = otherSideDice(idx,prevTop); 
	
		//위, 아래 숫자를 리턴
		return new int[] {top,bottom};
		
	}
	
	public static int otherSideDice(int idx,int prevTop) {
		int index= -1;
		int result = -1;

		for(int i=0;i<6;i++) {
			if(dice[idx][i]==prevTop)
				index = i;
		}

		switch(index) {
		case 0 : result = dice[idx][5]; break;
		case 1 : result = dice[idx][3]; break;
		case 2 : result = dice[idx][4]; break;
		case 3 : result = dice[idx][1]; break;
		case 4 : result = dice[idx][2]; break;
		case 5 : result = dice[idx][0]; break;
		}

		return result;	
	}
}