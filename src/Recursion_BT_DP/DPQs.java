package Recursion_BT_DP;

public class DPQs {

	public static void main(String[] args) {

		int n = 100;

		// System.out.println(Fib(n));
		// System.out.println(FibTD(n, new int[n+1]));
		// System.out.println(FibBU(n));
		// System.out.println(climbStairsTD(0, n, new int[n]));
		// System.out.println(ClimbStairsBU(n));
		// System.out.println(mazePath(0, 0, n, n));
		// System.out.println(mazePathTD(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(mazePathBU(n, n));

		int[] arr = { 2, 3, 5, 1, 4 };

		// int[] arr = new int[n];
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = i + 1;
		// }
		// System.out.println(wineProblem(arr, 0, arr.length - 1, 1));
		System.out.println(wineProblemTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
	}

	public static int Fib(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = Fib(n - 1);
		int fnm2 = Fib(n - 2);

		int fn = fnm1 + fnm2;

		return fn;
	}

	public static int FibTD(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = FibTD(n - 1, strg);
		int fnm2 = FibTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		strg[n] = fn;

		return fn;
	}

	public static int FibBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];

	}

	public static int climbStairs(int curr, int n) {

		if (curr == n) {
			return 1;
		}

		if (curr > n) {
			return 0;
		}

		int o1 = climbStairs(curr + 1, n);
		int o2 = climbStairs(curr + 2, n);
		int o3 = climbStairs(curr + 3, n);

		return o1 + o2 + o3;

	}

	public static int climbStairsTD(int curr, int n, int[] strg) {

		if (curr == n) {
			return 1;
		}

		if (curr > n) {
			return 0;
		}

		if (strg[curr] != 0) { // re-use
			return strg[curr];
		}

		int o1 = climbStairsTD(curr + 1, n, strg);
		int o2 = climbStairsTD(curr + 2, n, strg);
		int o3 = climbStairsTD(curr + 3, n, strg);

		strg[curr] = o1 + o2 + o3; // store

		return o1 + o2 + o3;

	}

	public static int ClimbStairsBU(int n) {

		int[] strg = new int[n + 3];

		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3];
		}

		return strg[0];

	}

	public static int mazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int ch = mazePath(cr, cc + 1, er, ec);
		int cv = mazePath(cr + 1, cc, er, ec);

		return ch + cv;
	}

	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) { // re-use
			return strg[cr][cc];
		}

		int ch = mazePathTD(cr, cc + 1, er, ec, strg);
		int cv = mazePathTD(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv; // store

		return ch + cv;
	}

	public static int mazePathBU(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		for (int r = er; r >= 0; r--) {

			for (int c = ec; c >= 0; c--) {

				if (r == er && c == ec) {
					strg[r][c] = 1;
				} else {
					strg[r][c] = strg[r][c + 1] + strg[r + 1][c];
				}

			}
		}

		return strg[0][0];
	}

	public static int wineProblem(int[] arr, int si, int ei, int yr) {

		if (si == ei) {
			return arr[si] * yr;
		}

		int left = wineProblem(arr, si + 1, ei, yr + 1) + arr[si] * yr;
		int right = wineProblem(arr, si, ei - 1, yr + 1) + arr[ei] * yr;

		int res = Math.max(left, right);

		return res;

	}

	public static int wineProblemTD(int[] arr, int si, int ei, int[][] strg) {

		int yr = arr.length - (ei - si + 1) + 1;

		if (si == ei) {
			return arr[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int left = wineProblemTD(arr, si + 1, ei, strg) + arr[si] * yr;
		int right = wineProblemTD(arr, si, ei - 1, strg) + arr[ei] * yr;

		int res = Math.max(left, right);

		strg[si][ei] = res;

		return res;

	}
}
