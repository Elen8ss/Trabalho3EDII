package structures.graph;

public class Vertices {
	private String[] vertices;
	private int index;
	private int numVertex;
	
	public Vertices (int numVertex) {
		vertices = new String[numVertex];
		this.numVertex = numVertex;
		index = 0;
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = "";
		}
	}
	
	public boolean contains(String v) {
		for (String s : this.vertices) {
			if (s.equals(v))
				return true;
		}
		return false;
	}
	
	public int vertexIndex(String v) {
		for (int i = 0; i < index; i++) {
			if (this.vertices[i].equals(v))
				return i;
		}
		return -1; 
	}
	
	public void verticeInsert(String v) {
		if (!contains(v) && index < numVertex) {
			vertices[index] = v;
			index++;
		}
		
	}
	
	public String getVertex(int index) {
		return vertices[index];
	}
}
