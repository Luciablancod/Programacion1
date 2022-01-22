package practico8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Hacer un programa que dado una matriz ordenada creciente por filas de
//enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
//numero entero y una fila, y luego inserte el numero en la matriz en la fila
//indicada manteniendo su orden.

public class ej7 {
	public static final int MAXFILA= 4;
	public static final int MAXCOLUMNA = 5;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	
	public static void main (String[]args) {
		int [][] matInt = {{1, 3, 3, 8, 9},
						 {2, 2, 7, 9, 9},
						 {3, 4, 5, 6, 7},
						 {4, 5, 6, 7, 8}};
		
		int num,fila;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("Matriz:");
			imprimir_matriz_int(matInt);

			System.out.println("Ingrese un numero");
			num =Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese una fila");
			fila =Integer.valueOf(entrada.readLine());

			System.out.println("Matriz resultado:");
			inserta_numero(matInt, num,fila);
			imprimir_matriz_int(matInt);

		}
		catch(Exception exc) {
			System.out.println(exc);
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
	
	public static void inserta_numero(int [][] mat, int num, int fila) {
		int i=fila;
		
		while((i<MAXFILA)&&(i != fila)) {
			i++;
		}
		if(i<MAXFILA) {
			inserta_numero_fila(mat[i],num);
		}
	}
	
	public static void inserta_numero_fila(int []arr, int num) {
		int pos = busca_pos_ord(arr,num);
		corrimiento_der(arr,pos);
		arr[pos] = num;
	}
	
	public static int busca_pos_ord(int []arr,int num) {
		int i=0;
		
		while((i<MAXCOLUMNA)&&(arr[i]<num)) {
			i++;
		}
		return i;
	}
	
	public static void corrimiento_der(int []arr, int pos) {
		for(int i= MAXCOLUMNA-1; i> pos; i--) {
			arr[i]= arr[i-1];
		}
		
	}

}
