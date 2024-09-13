//Baekjoon - 1373

import java.io.*;
import java.util.Arrays;
public class Main {
	static StringBuilder answer = new StringBuilder();
	static int[] pow = {1,2,4};
	static int startI = 0;
	static String inputs;
	
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputs = br.readLine();
		String temp ;
		int len = inputs.length();
		if(len%3 ==1) {
			cal(0,1);
			startI +=1;
		}
		else if(len%3 ==2) {
			cal(0,2);
			startI +=2;
		}
		for(int i=startI; i<len-1;  i+=3) {
			cal(i,3);
			
		}
		System.out.println(answer);
	}	
	static void cal(int i, int len) {
		int tempsum =0;
		for(int j=0; j<len; j++) {
			tempsum += (inputs.charAt(i+j)-'0')*pow[len-j-1];
		}
		answer.append(tempsum);
	}
}