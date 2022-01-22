package practico8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado una matriz de enteros de tamaño 4*5 que
//se encuentra precargada, solicite al usuario el ingreso de una fila y dos
//números enteros (columnas de la matriz), y ordene de forma creciente la
//matriz en la fila indicada entre las dos posiciones columnas ingresadas.

public class ej9 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 5;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR= 1;

	public static void main (String[]args) {
		int [][] matInt =  new int [MAXFILA][MAXCOLUMNA];

		int pos1,pos2,fila;

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("Matriz:");
			cargar_matriz_aleatorio_int(matInt);
			imprimir_matriz_int(matInt);

			System.out.println("Ingrese un numero");
			pos1 =Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese un numero");
			pos2 =Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese una fila");
			fila =Integer.valueOf(entrada.readLine());

			System.out.println("Matriz resultado:");
			ordena_fila_entre_pos(matInt, pos1, pos2, fila);
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
	
	public static void ordena_fila_entre_pos(int [][] mat, int pos1, int pos2, int fila) {
		int i=0;
		while((i<MAXFILA)&&( i != fila)){
			i++;
		}
		if(i<MAXFILA) {
			ordenar_arreglo_seleccion(mat[i], pos1, pos2);
		}
	}
	
	public static void ordenar_arreglo_seleccion(int[]arr, int pos1, int pos2) {
		int pos_menor, tmp;
		for (int i = pos1; i < MAXCOLUMNA; i++) {
			pos_menor = i;
			for (int j = i + 1; j < pos2+1; j++){
				if (arr[j] < arr[pos_menor]) {
					pos_menor = j;
				}
			}
			if (pos_menor != i){
				tmp = arr[i];
				arr[i] = arr[pos_menor];
				arr[pos_menor] = tmp;
			}
		}
	}

}
