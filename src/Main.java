import structures.graph.*;

public class Main {
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.insereAresta("1", "2", 0);
		g.insereAresta("2", "5", 0);
		g.insereAresta("5", "3", 0);
		g.insereAresta("4", "5", 0);
		g.insereAresta("1", "5", 0);
		g.print();
	}
}