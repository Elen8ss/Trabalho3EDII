package structures.graph;

public class Vertices {
	private int[] vertices;
	private int index;
	private int numVertex;
	
	public Vertices (int numVertex) {
		vertices = new int[numVertex];
		this.numVertex = numVertex;
		index = 0;
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = 0;
		}
	}
	
	public boolean contains(int v) {
		for (int s : this.vertices) {
			if (s == v)
				return true;
		}
		return false;
	}
	
	public int vertexIndex(int v1) {
		for (int i = 0; i < index; i++) {
			if (this.vertices[i] == v1)
				return i;
		}
		return -1; 
	}
	
	public void verticeInsert(int v) {
		if (!contains(v) && index < numVertex) {
			vertices[index] = v;
			index++;
		}
		
	}
	
	public int getVertex(int index) {
		return vertices[index];
	}
}
