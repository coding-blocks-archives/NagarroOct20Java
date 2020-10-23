package Graph;

public class GraphClient {

	public static void main(String[] args) {

		Graph g = new Graph(5);

		// g.addEdge(0, 1, 2);
		// g.addEdge(0, 3, 10);
		// g.addEdge(1, 2, 3);
		// g.addEdge(2, 3, 1);
		// g.addEdge(3, 4, 4);
		// g.addEdge(4, 5, 5);
		// g.addEdge(4, 6, 6);
		// g.addEdge(5, 6, 3);

		g.addEdge(0, 1, 8);
		g.addEdge(0, 2, 4);
		g.addEdge(0, 3, 5);
		g.addEdge(2, 3, -3);
		g.addEdge(1, 4, -2);
		g.addEdge(4, 1, 1);
		g.addEdge(3, 4, 4);

		g.display();

		// g.dft();
		// g.prims();
		// g.dijkstra(0);
		
		g.bellmanFord(0) ;

	}
}





