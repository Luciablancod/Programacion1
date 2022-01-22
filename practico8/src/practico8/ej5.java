package practico8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
//precargada, solicite al usuario un numero entero y elimine la primer ocurrencia de numero
//en la matriz (un número igual) si existe. Para ello tendrá que buscar la posición y si está,
//realizar un corrimiento a izquierda y no continuar buscando.

public class ej5 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MAXVALOR=9;
	public static final int MINVALOR = 1;

	public static void main (String [] args) {
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
			elimina_primera_ocurrencia(matInt, num);
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
	
	public static void elimina_primera_ocurrencia(int [][] mat, int num) {
		int i =0;
		int pos;
		while((i<MAXFILA)&&(existe(mat[i], num)== false)) {
			i++;
		}
		if (i<MAXFILA) {
			pos = busca_posicion(mat[i],num);
			corrimiento_izq(mat[i],pos);
		}
	}
	
	public static boolean existe(int [] arr, int num) {
		boolean existe = false;
		
		int i=0;
		while((i<MAXCOLUMNA)&&(arr[i] != num)){
			i++;
		}
		if((arr[i] == num)&&(i<MAXCOLUMNA)) {
			existe = true;
		}
		return existe;
	}
	
	public static int busca_posicion(int [] arr,int num) {
		int i=0;
		while((i<MAXCOLUMNA)&&(arr[i] != num)){
			i++;
		}
			return i;
		
	}
	
	public static void corrimiento_izq(int [] arr, int pos) {
		for(int i=pos; i<MAXCOLUMNA-1;i++) {
			arr[i] = arr[i+1];
		}
	}
}


