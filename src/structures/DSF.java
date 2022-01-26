/*package structures;

import structures.graph.*;
import structures.graph.Graph.Edge;

public class DSF {
    
    static int visita[], low[], parent[];

    private void DFSbridges(Graph graph){
        int vertice = new int[numVertex];
        
        for (int i=0; i<graph.numVertex(); i++) {
			visita[i] = -1;
            for (int j=0; j<graph.numVertex(); j++){
                if(visita[j] == -1){//se nao foi visitado
                    parent[j] = vertice; //cria uma nova raiz de aborescencia
                    DFSbridgesRecursive(graph, vertice);
                }
            }
		}
    }

    private void DFSbridgesRecursive(Graph graph, int vertice) {
        if(!graph.listaAdjVazia(vertice)) {
            Edge aresta = graph.primeiroListaAdj(vertice);
            while(aresta!=null){
                int a = aresta.v2();
                if (visita[a] == -1){ //se adj nao foi visitado
                    parent[a] = vertice;

                    DFSbridgesRecursive(graph, a);
                    if (low[vertice] > low[a]){
                        low[vertice] = low[a];
                    }
                    if (low[a] == visita[a]){
                        System.out.println("Achou ponte!");
                    }
                
                }else if(a != parent[vertice] && low[vertice]>visita[a]){ //se ja foi visitado
                    low[vertice] = visita[a];
                    System.out.println("Conectado por aresta");
                }

            }
        }
    }
}*/
