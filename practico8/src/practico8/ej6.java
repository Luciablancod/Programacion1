package practico8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
//precargada, solicite al usuario un numero entero y elimine todas las ocurrencia de numero
//en la matriz si existe. Mientras exista (en cada iteración tiene que buscar la posición fila y
//columna) tendrá que usar dicha posición para realizar un corrimiento a izquierda.

public class ej6 {
	public static final int MAXFILA= 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	
	public static void main (String[]args) {
		int [][] matInt = new int [MAXFILA][MAXCOLUMNA];
		int num;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("Matriz:");
			cargar_matriz_aleatorio_int(matInt);
			imprimir_matriz_int(matInt);

			System.out.println("Ingrese un numero");
			num =Integer.valueOf(entrada.readLine());

			System.out.println("Matriz resultado:");
			elimina_ocurrencias(matInt, num);
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
	
	public static void elimina_ocurrencias(int [][] mat, int num) {
		int pos, cant;
		for(int fila = 0; fila<MAXFILA;fila++) {
			if(existe(mat[fila],num)) {
				cant = cant_repetidos(mat[fila],num);
				for(int rep= 0; rep <= cant; rep++) {
					pos = busca_pos(mat[fila],num);
					corrimiento_izq(mat[fila],pos);
				}
			}
		}
	}
	
	public static boolean existe(int [] arr,int num) {
		boolean existe= false;
		int i=0;
		
		while((i<MAXCOLUMNA)&&(arr[i] != num)) {
			i++;
		}
		if(i<MAXCOLUMNA) {
			existe = true;
		}
		return existe;
	}
	
	public static int cant_repetidos(int [] arr,int num) {
		int cant=0;
		for(int i=0; i<MAXCOLUMNA;i++) {
			if(arr[i] == num) {
				cant++;
			}
		}
		return cant;
	}
	
	public static int busca_pos(int [] arr,int num) {
		int i=0;
		
		while((i<MAXCOLUMNA)&&(arr[i] != num)) {
			i++;
		}
	return i;
	}
	
	public static void corrimiento_izq(int [] arr, int pos) {
		for(int i=pos; i<MAXCOLUMNA-1; i++) {
			arr[i]=arr[i+1];
		}
			
		
	}

}
