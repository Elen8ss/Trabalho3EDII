package structures.graph;

import structures.list.List;

public class Graph {
	private List<Cell> adj[ ];
	private int numVertex;
	private Vertices vertices;
	
	public Graph (int numVertex) {
	    this.adj = new List [numVertex]; 
		this.numVertex = numVertex;
		vertices = new Vertices(numVertex);

	    for (int i = 0; i < this.numVertex; i ++) 
	        this.adj[i] = new List<Cell> ();

	}
	
	public static class Edge {
		private String v1, v2;
		private float weight;
		public Edge (String v1, String v2, float weight) {
			this.v1 = v1; 
			this.v2 = v2; 
			this.weight = weight;
		}

		public float getWeight( ) { 
			return this.weight; 
		}	
		public String getV1 ( ) { 
			return this.v1; 
		}
		public String v2 ( ) { 
			return this.v2; 
		}
	}
	
	private static class Cell {
	    String vertex; 
	    float weight;
	    
		public Cell (String v, float p) { 
	        this.vertex = v; 
	        this.weight = p;
	    }

		public boolean equals (Object obj) {
		    Cell item = (Cell) obj;
		    return (this.vertex.equals(item.vertex));
		}
	}
	

	public void insereArestaOrientado (String v1, String v2, float weight) {
		vertices.verticeInsert(v1);
		vertices.verticeInsert(v2);
		Cell item = new Cell (v2, weight);
		int index = vertices.vertexIndex(v1);
		if (index != -1)
			this.adj[index].put (item);			
		
	}
	
	public void insereAresta (String v1, String v2, float weight) {
		vertices.verticeInsert(v1);
		vertices.verticeInsert(v2);
		Cell item = new Cell (v2, weight);
		int index = vertices.vertexIndex(v1);
		if (index != -1)
			this.adj[index].put (item);
		
		item = new Cell (v1, weight);
		index = vertices.vertexIndex(v2);
		if (index != -1)
			this.adj[index].put (item);
	}

	public boolean existeAresta (String v1, String v2) {
	    Cell item = new Cell (v2, 0);
	    int index = vertices.vertexIndex(v1);
		if (index != -1)
			return (this.adj[index].search (item) != null);
		return false;
	}

	public boolean listaAdjVazia (String v) {
		int index = vertices.vertexIndex(v);
		if (index != -1)
			return this.adj[index].empty ( );
		return false;
	}

	public Edge primeiroListaAdj (String v) {
	    // Retorna a primeira aresta que o vértice v participa ou
	    // null se a lista de adjacência de v for vazia
		int index = vertices.vertexIndex(v);
		if (index != -1) {
			Cell item = (Cell) this.adj[index].listFirst();
			if (item != null)
				return new Edge (v, item.vertex, item.weight);			
		}
	    return null;
	}

	public Edge proxAdj (String v) {
	    // Retorna a próxima aresta que o vértice v participa ou
	    // null se a lista de adjacência de v estiver no fim
		int index = vertices.vertexIndex(v);
		if (index != -1) {
			Cell item = (Cell) this.adj[index].listNext();
			if (item != null)
				return new Edge (v, item.vertex, item.weight);			
		}
	    return null;
	}

	public Edge retiraAresta (String v1, String v2) throws Exception {
	    Cell key = new Cell (v2, 0);
	    int index = vertices.vertexIndex(v1);
		if (index != -1) {
		    Cell item = (Cell) this.adj[index].delete (key);
		    if (item != null)
		        return new Edge (v1, v2, item.weight);
		}
	    return null;
	}

	public void print ( ) {
	    for (int i = 0; i < this.numVertex; i ++) {
	        System.out.println ("Vertice " + i + " : ");
	        Cell item = (Cell) this.adj[i].listFirst();
	        
	        while (item != null) {
	            System.out.println (vertices.getVertex(i)+" - " + item.vertex + " ( " +item.weight+ " )");
	            item = (Cell) this.adj[i].listNext();
	        }
	    }
	}

	public int numVertex ( ) {
	    return this.numVertex;
	}
}
