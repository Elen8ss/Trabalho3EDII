package structures;
import java.util.Iterator;
import java.util.Vector;

import structures.graph.*;

public class DSF {
    static final int numVertex=4;
    
    static String visita[], low[], parent[];

    private void DFSbridges(Graph graph){
        String vertice;
        
        for (int i=0; i<graph.numVertex(); i++) {
			visita[i].equals("branco");
            for (int j=0; j<graph.numVertex(); j++){
                if(visita[j].equals("branco")){//se nao foi visitado
                    parent[j] = vertice; //cria uma nova raiz de aborescencia
                    DFSbridgesRecursive(graph, vertice);
                }
            }
		}
    }

    private void DFSbridgesRecursive(Graph graph, String vertice) {
        if(!graph.listaAdjVazia(vertice)) {
            Edge aresta = graph.primeiroListaAdj(vertice);
            while(aresta!=null){
                String a = aresta.v2();
                if (visita[a].equals("branco")){ //se adj nao foi visitado
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
}
