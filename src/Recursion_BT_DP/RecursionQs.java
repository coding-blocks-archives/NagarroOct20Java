package Recursion_BT_DP;

public class RecursionQs {

	public static void main(String[] args) {

		// PDI(3);
		// coinToss(4, "");
		// climbStairs(0, 5, "");
		// mazePath(0, 0, 2, 2, "");
		// validParenthesis(0, 0, 2, "");
	}

	public static void PDI(int n) {

		if (n == 0) {
			return;
		}

		System.out.println("hii " + n);
		PDI(n-1);
		System.out.println("bye " + n);
	}

	public static void coinToss(int n, String ans) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		coinToss(n - 1, ans + "H");
		coinToss(n - 1, ans + "T");
	}

	public static void climbStairs(int curr, int n, String ans) {

		if (curr == n) {
			System.out.println(ans);
			return;
		}

		if (curr > n) {
			return;
		}

		// climbStairs(curr + 1, n, ans + "1");
		// climbStairs(curr + 2, n, ans + "2");
		// climbStairs(curr + 3, n, ans + "3");

		for (int jump = 1; jump <= 3; jump++) {
			climbStairs(curr + jump, n, ans + jump);
		}

	}

	public static void mazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}

		// if (cr > er || cc > ec) {
		// return;
		// }

		if (cc + 1 <= ec)
			mazePath(cr, cc + 1, er, ec, ans + "H");

		if (cr + 1 <= er)
			mazePath(cr + 1, cc, er, ec, ans + "V");
	}

	public static void validParenthesis(int open, int close, int n, String ans) {

		if (open == n && close == n) {
			System.out.println(ans);
			return;
		}

		if (open > n || close > open) {
			return;
		}

		validParenthesis(open + 1, close, n, ans + "(");
		validParenthesis(open, close + 1, n, ans + ")");
	}

}
