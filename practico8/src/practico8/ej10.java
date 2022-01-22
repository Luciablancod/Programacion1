package practico8;
//Se tiene una matriz de enteros de tamaño 4*20 de secuencias de números
//entre 1 y 9 (por cada fila), separadas por 0. La matriz esta precargada, y
//además cada fila empieza y termina con uno o más separadores 0.
//Además, se tiene una matriz de caracteres de tamaño 4*20 de secuencias de
//caracteres letras minúsculas entre ‘a’ y ‘z’ (por cada fila), separadas por ‘ ’
//(espacios). La matriz esta precargada, y además cada fila empieza y termina
//con uno o más separadores ‘ ’.
//Considere para los siguientes ejercicios estos tipos de matriz.
//
//Hacer un programa que dada la matriz de secuencias de enteros definida
//y precargada, permita obtener a través de métodos la posición de inicio y
//la posición de fin de la secuencia ubicada a partir de una posición entera
//y una fila, ambas ingresadas por el usuario. Finalmente, si existen imprima
//por pantalla ambas posiciones obtenidas.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ej10 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero= 0.3;
	
	public static void main (String [] args) {
		int [][] matInt = new int [MAXFILA][MAXCOLUMNA];
		
		int pos,fila;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			cargar_matriz_aleatorio_secuencias_int(matInt);
			imprimir_matriz_int(matInt);
			
			System.out.println("Ingrese una fila de la matriz: ");
			fila= Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese una posicion de la fila ingresada: ");
			pos= Integer.valueOf(entrada.readLine());
			
			devuelve_inicio_fin(matInt, fila, pos);
            
		}
		catch (Exception exc){
			System.out.println(exc);
		}
	}
	
	public static void cargar_matriz_aleatorio_secuencias_int(int [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			cargar_arreglo_aleatorio_secuencias_int(mat[fila]);
		}
		System.out.println("");
	}

	public static void cargar_arreglo_aleatorio_secuencias_int(int [] arr){
			Random r = new Random();
			arr[0] = 0;
			arr[MAXCOLUMNA-1] = 0;
			for (int pos = 1; pos < MAXCOLUMNA-1; pos++){
				if (r.nextDouble()>probabilidad_numero){
					arr[pos]=(r.nextInt(MAXVALOR+MINVALOR-1) + MINVALOR); 
				}
				else{
					arr[pos]=0;				
				}
			}
		}
	
	public static void imprimir_matriz_int(int [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			imprimir_arreglo_secuencias_int(mat[fila]);
			System.out.println("");
		}
	}

	public static void imprimir_arreglo_secuencias_int(int [] arr){
			System.out.print("|");
			for (int pos = 0; pos < MAXCOLUMNA; pos++){
				System.out.print(arr[pos]+"|");
			}
		}
	
	public static void devuelve_inicio_fin(int [][] mat, int fila, int pos) {
		int i=0;
		int inicio, fin;
		while((i<MAXFILA) && (i != fila)) {
			i++;
		}
		if(i<MAXFILA) {
			inicio = busca_inicio(mat[i], pos);
			fin = busca_fin(mat[i],pos);
			
			System.out.println("El inicio de la secuencia es:" +inicio + " y el fin es en la posicion "+fin);
		}
		
	}
	
	public static int busca_inicio(int []arr, int pos) {
		int i=pos;
		while((i<MAXCOLUMNA)&&(arr[i] != 0)&&(i>0)){
			i--;
		}
		if(i>0) {
			return  i+1;
		}else {
			return -1;
		}
	}
	
	public static int busca_fin(int []arr, int pos) {
		int i=pos;
		while((i<MAXCOLUMNA)&&(arr[i] != 0)) {
			i++;
		}
		if(i<MAXCOLUMNA) {
			return i-1;
		}else {
			return -1;
		}
	}

}
