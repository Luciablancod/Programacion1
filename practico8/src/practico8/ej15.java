package practico8;

import java.util.Random;

//Hacer un programa que dada la matriz de secuencias de caracteres definida y
//precargada elimine todas las secuencias que tienen orden descendente entre sus elementos.

public class ej15 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero= 0.4;
	
	public static void main (String [] args) {
		int [][] matInt = new int [MAXFILA][MAXCOLUMNA];
		
		System.out.println("Matriz inicial");
		cargar_matriz_aleatorio_secuencias_int(matInt);
		imprimir_matriz_int(matInt);
		
		System.out.println("Matriz final");
		elimina_secuencias_descendente(matInt);
		imprimir_matriz_int(matInt);
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
	
	public static void elimina_secuencias_descendente(int [][]mat) {
		for(int fila =0; fila< MAXFILA; fila++) {
			elimina_secuencia_por_fila(mat[fila]);
		}
	}
	
	public static void elimina_secuencia_por_fila(int [] arr) {
		int inicio= busca_inicio(arr,0);
		int fin= -1;
		
		while(inicio != -1) {
			fin= busca_fin(arr,inicio);
			if(fin != -1) {
				if(esDescendente(arr,inicio,fin)) {
					elimina_secuencia(arr, inicio,fin);
				}
			}
			inicio= busca_inicio(arr,fin+1);
		}
		
	}
	
	public static int busca_inicio(int []arr, int indiceprevio) {
		int i= indiceprevio;
		
		while((i<MAXCOLUMNA)&&(arr[i] == 0)) {
			i++;
		}
		if(i<MAXCOLUMNA) {
			return i;
		}else {
			return -1;
		}
	}
	
	public static int busca_fin(int [] arr, int inicio) {
		int i= inicio;
		
		while((i<MAXCOLUMNA)&&(arr[i] != 0)) {
			i++;
		}
		if(i<MAXCOLUMNA) {
			return i-1;
		}else {
			return -1;
		}
	}
	
//	public static boolean esDescendente(int []arr, int inicio,int fin) {
//		boolean descendente = false;
//		
//		int i= inicio;
//		
//		while((arr[i]> arr[i+1])&&(i<fin)) {
//			i++;
//		}
////		if(arr[i] > arr[i+1]) {
////			descendente = true;
////		}
//		if(i == fin) {
//			descendente = true;
//		}
//		System.out.println("descendente: "+ descendente);
//		return descendente;
//	}
	
	public static boolean esDescendente(int []arr, int inicio,int fin) {
		boolean descendente = true;
		
		for(int i= inicio;i<=fin-1; i++){
			if(arr[i] < arr[i+1]) {
				descendente = false;
			}
		}

		return descendente;
	}
	
	public static void elimina_secuencia(int []arr, int inicio, int fin) {
		int tamanio= fin-inicio+1;
		
		for(int i = fin+1; i<MAXCOLUMNA; i++) {
			arr[i-tamanio]= arr[i];
		}
	}
}
