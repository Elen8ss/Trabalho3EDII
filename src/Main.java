import java.util.InputMismatchException;
import java.util.Scanner;

import structures.graph.*;

public class Main {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String opction = "";
		readFiles readArq = new readFiles();
		int op = 1, aux;
		boolean isOriented = false;
		boolean isWeighted = false;
		Graph g = null;
		
		do {
			switch (op) {
				case 1: {
					try {
						String[] nameFiles = readArq.nameFiles();
						System.out.println("Escolha o arquivo");
						for (int i = 0; i < nameFiles.length; i++) {
							System.out.println((i+1)+" - "+nameFiles[i]);
						}
						
						aux = read.nextInt()-1;
						read.nextLine();
						
						System.out.println("Escolha o grafo\n1-não direcionado\n2-direcionado");
						opction = read.nextLine();
						if (opction.equals("1")) {
							isOriented = false;			
						} else if (opction.equals("2")) {
							isOriented = true;
						}
						
						System.out.println("Escolha o grafo\n1-não ponderado\n2-ponderado");
						opction = read.nextLine();
						if (opction.equals("1")) {
							isWeighted = false;			
						} else if (opction.equals("2")) {
							isWeighted = true;
						} 
						g = readArq.initGraph(isOriented, isWeighted, nameFiles[aux]);
						
					} catch (InputMismatchException e) {
						System.out.println("Digite um número, por favor.");
					}
					break;
				}
				
				case 2: {
					if (g != null) {
						g.print();
					}
					break;
				}
				
				case 3: {
					//TODO exenctridade de um vértice
					break;
				}
				case 4: {
					//TODO pontes de um grafo
				}
			}
			System.out.println("1 - iniciar outro grafo");
			if (g != null) {
				System.out.println("2 - imprime o grafo");
			}
			op = read.nextInt();
			read.nextLine();
		} while (op > 0);
		
	}
}