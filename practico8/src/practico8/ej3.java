package practico8;

//Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
//precargada, solicite al usuario una posición fila, columna y realice un corrimiento a izquierda.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

class ej3 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MAXVALOR =9;
	public static final int MINVALOR =1;

	public static void main(String[] args) {
		int [][] matInt = new int [MAXFILA][MAXCOLUMNA];
		int fila, columna;

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("Matriz:");
			cargar_matriz_aleatorio_int(matInt);
			imprimir_matriz_int(matInt);

			System.out.println("Ingrese una fila");
			fila =Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese una columna");
			columna =Integer.valueOf(entrada.readLine());

			System.out.println("Matriz final:");
			recorro_fila(matInt,  fila, columna);
			imprimir_matriz_int(matInt);

		}
		catch(Exception exc) {
			System.out.println(exc);
		}
	}


	public static void cargar_matriz_aleatorio_int(int [][] mat){
		Random r = new Random();
		for (int fila = 0; fila < MAXFILA; fila++){
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				mat[fila][columna]=(r.nextInt(MAXVALOR+MINVALOR-1) + MINVALOR);
			}
		}
	}

	public static void imprimir_matriz_int(int [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			System.out.print("|");
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				System.out.print(mat[fila][columna]+"|");
			}
			System.out.println("");
		}
	}

	public static void recorro_fila(int [][] matInt, int fila, int columna){
		if(fila< MAXFILA){
			corrimiento_izq(matInt[fila], columna);
		}
	}

	public static void corrimiento_izq(int [] arr, int columna){
		int i =0;
		while((i<columna)){
			arr[i] = arr[i+1];
			i++;
		}

	}
}
