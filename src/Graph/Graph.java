package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	private HashMap<Integer, HashMap<Integer, Integer>> map;
	private int V;

	public Graph(int V) {

		this.map = new HashMap<>();
		this.V = V;

		for (int i = 0; i < V; i++) {
			map.put(i, new HashMap<>());
		}

	}

	public void addEdge(int u, int v, int wt) {

		map.get(u).put(v, wt);
		// map.get(v).put(u, wt);

	}

	public void display() {

		for (int key : map.keySet()) {
			System.out.println(key + " -> " + map.get(key));
		}
	}

	public void bft() {

		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {

			if (visited[i]) {
				continue;
			}

			q.add(i);
			visited[i] = true;

			while (!q.isEmpty()) {

				int re = q.remove();

				System.out.print(re + " ");

				for (int nbr : map.get(re).keySet()) {

					if (!visited[nbr]) {
						q.add(nbr);
						visited[nbr] = true;
					}
				}

			}
		}
		System.out.println();

	}

	public void dft() {

		Stack<Integer> s = new Stack<>();
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {

			if (visited[i]) {
				continue;
			}

			s.push(i);
			visited[i] = true;

			while (!s.isEmpty()) {

				int re = s.pop();

				System.out.print(re + " ");

				for (int nbr : map.get(re).keySet()) {

					if (!visited[nbr]) {
						s.push(nbr);
						visited[nbr] = true;
					}
				}

			}
		}
		System.out.println();

	}

	public int minCost(boolean[] added, int[] cost) {

		int min = Integer.MAX_VALUE;
		int minidx = -1;

		for (int i = 0; i < cost.length; i++) {
			if (cost[i] < min && !added[i]) {
				min = cost[i];
				minidx = i;
			}
		}

		return minidx;
	}

	public void prims() {

		boolean[] added = new boolean[V];
		int[] parent = new int[V];
		int[] cost = new int[V];

		for (int i = 0; i < V; i++) {
			cost[i] = Integer.MAX_VALUE;
		}

		cost[0] = 0;
		parent[0] = -1;

		for (int i = 1; i <= V; i++) {

			int u = minCost(added, cost);

			added[u] = true;

			for (int v : map.get(u).keySet()) {

				if (!added[v]) {

					if (cost[v] > map.get(u).get(v)) {
						cost[v] = map.get(u).get(v);
						parent[v] = u;
					}
				}
			}

		}

		for (int i = 0; i < V; i++) {
			System.out.println(parent[i] + " - " + i + " -> " + cost[i]);
		}

	}

	public void dijkstra(int src) {

		boolean[] added = new boolean[V];
		int[] cost = new int[V];

		for (int i = 0; i < V; i++) {
			cost[i] = Integer.MAX_VALUE;
		}

		cost[src] = 0;

		for (int i = 1; i <= V; i++) {

			int u = minCost(added, cost);

			added[u] = true;

			for (int v : map.get(u).keySet()) {

				if (!added[v]) {

					if (cost[v] > cost[u] + map.get(u).get(v)) {
						cost[v] = cost[u] + map.get(u).get(v);
					}
				}
			}

		}

		for (int i = 0; i < V; i++) {
			System.out.println(src + " - " + i + " -> " + cost[i]);
		}

	}

	private class EdgePair {

		int u;
		int v;
		int wt;

		public EdgePair(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}
	}

	public ArrayList<EdgePair> getAllEdges() {

		ArrayList<EdgePair> edges = new ArrayList<>();

		// 0 -> V-1
		for (int key : map.keySet()) {

			HashMap<Integer, Integer> imap = map.get(key);

			for (int nbr : imap.keySet()) {

				EdgePair ep = new EdgePair(key, nbr, imap.get(nbr));
				edges.add(ep);
			}

		}

		return edges;

	}

	public void bellmanFord(int src) {

		ArrayList<EdgePair> edges = getAllEdges();

		int[] cost = new int[V];

		for (int i = 0; i < V; i++) {
			cost[i] = 100000;
		}

		cost[src] = 0;

		for (int i = 1; i <= V; i++) {

			for (EdgePair ep : edges) {

				int oc = cost[ep.v];
				int nc = cost[ep.u] + ep.wt;

				if (nc < oc) {

					if (i <= V - 1)
						cost[ep.v] = nc;
					else {
						System.out.println("-ve wt cycle");
						return;
					}
				}

			}

		}

		// ans
		for (int i = 0; i < cost.length; i++) {
			System.out.println(i + " -> " + cost[i]);
		}

	}

}
