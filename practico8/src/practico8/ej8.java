package practico8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Hacer un programa que dado una matriz ordenada creciente por filas de
//enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
//numero entero y una fila, y elimine la primer ocurrencia de numero en la
//fila indicada (un número igual) si existe.

public class ej8 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 5;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR= 1;

	public static void main (String[]args) {
		int [][] matInt =   {{1,1,3,6,9},
				{2,3,4,7,9},
				{3,3,6,7,9},
				{2,2,3,7,8}};

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
			elimina_primer_ocurrencia(matInt, num, fila);
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
	
	public static void elimina_primer_ocurrencia(int [][] mat, int num, int fila) {
		int i=0;
		int pos;
		
		while((i<MAXFILA)&&(i != fila)) {
			i++;
		}
		if((i<MAXFILA)&&(existe(mat[i],num) == true)) {
			pos = busca_pos(mat[i], num);
			if(pos == MAXCOLUMNA -1) {
				elimina_con_corrimiento_der(mat[i],pos);
			}else {
			elimina_con_corrimiento_izq(mat[i],pos);
			}
		}
	}
	
	public static boolean existe (int [] arr, int num) {
		boolean tiene = false;
		int pos =0;
	
		while((pos<MAXCOLUMNA) && (arr[pos] != num)) {
			pos++;
		}
		if(pos <MAXCOLUMNA) {
			tiene = true;
		}
		return tiene;
	}
	
	public static int busca_pos(int [] arr, int num) {
		int pos=0;
		
		while((pos<MAXCOLUMNA)&&(arr[pos] != num)) {
			pos++;
		}
		return pos;
	}
	
	public static void elimina_con_corrimiento_izq(int []arr, int pos) {
		for(int i= pos; i<MAXCOLUMNA-1; i++) {
			arr[i]= arr[i+1];
		}
	}
	
	public static void elimina_con_corrimiento_der(int []arr, int pos) {
		for(int i= MAXCOLUMNA-1; i >= pos; i--) {
			arr[i]= arr[i-1];
		}
	}

}


