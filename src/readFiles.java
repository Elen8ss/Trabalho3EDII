import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import structures.graph.Graph;

public class readFiles {
	public String[] nameFiles() {
		String [] arq;
		File myObj = new File("./docs/");
		arq = myObj.list();
		return arq;
	}
	
	public Graph initGraph(boolean isOriented, boolean isWeighted, String nameFile) {
		      //File myObj = new File("./docs/"+nameFile);
		      //Scanner myReader = new Scanner(myObj);
		Graph g = null;
		try {
			String data;
			int cont = 0;
			//while (myReader.hasNextLine()) {
			//data = myReader.nextLine();
			BufferedReader buffRead = new BufferedReader(new FileReader("./docs/"+nameFile));
			data = buffRead.readLine();
			while (true) {
				if (data != null) {
					if (cont <= 0) {
						cont = Integer.parseInt(data);
						g = new Graph(cont, isWeighted);
					} else if (isOriented) {
						String[] aux = data.split(" ");
						if (aux.length >= 2 && !isWeighted) {
							g.insereArestaOrientado(aux[0],aux[1],0f);	
						} else if (aux.length == 3 && isWeighted) {
							g.insereArestaOrientado(aux[0],aux[1], Float.parseFloat(aux[2])); 		        		
						}
					} else {
						String[] aux = data.split(" ");
						if (aux.length >=2 && !isWeighted) { 
							g.insereAresta(aux[0],aux[1],0);			        			
						} else if (aux.length == 3 && isWeighted) {
							g.insereAresta(aux[0],aux[1], Float.parseFloat(aux[2]));		        		
						}
					}
				} else {
					break;
				}
				data = buffRead.readLine();
			}
			buffRead.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("Não foi possível abrir o arquivo tente, novamente");
	    } catch (IOException e) {
	    	
	    }
		return g;
	}

}
