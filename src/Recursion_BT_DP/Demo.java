package Recursion_BT_DP;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		lexico(0, n);

	}

	private static void lexico(int curr, int end) {

		// logic ...

		if(curr > end)
			return ;
		
		System.out.println(curr);

		int i = 0;

		if (curr == 0)
			i = 1;

		while (i <= 9) {

			lexico(curr * 10 + i, end);
			i++;
		}

	}

}
