package practico8;

import java.util.Random;

//Hacer un programa que dada la matriz de secuencias de enteros definida y
//precargada permita encontrar por cada fila la posición de inicio y fin de la
//secuencia cuya suma de valores sea mayor.

public class ej11 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero= 0.2;
	
	public static void main (String [] args) {
		int [][] matInt = new int [MAXFILA][MAXCOLUMNA];
		
		cargar_matriz_aleatorio_secuencias_int(matInt);
		imprimir_matriz_int(matInt);
		
		imprime_secuencia_mayor(matInt);
		
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
	
	public static void imprime_secuencia_mayor(int [][] mat) {

		for(int i= 0; i< MAXFILA; i++) {
			System.out.println("Fila "+i);
			busca_secuencia_mayor(mat[i]);
			
		}
	}
	
	public static void busca_secuencia_mayor(int [] arr) {
		int sumaMayor=0;
		int suma=0;
		
		int fin=0;
		int inicio = busca_inicio(arr,fin);
		
		int inicioM=0;
		int finM = 0;
		
		while(inicio != -1) {
			fin= busca_fin(arr,inicio);
			if(fin != -1) {
				suma= suma_secuencia(arr,inicio,fin);
				
				if(suma > sumaMayor) {
					sumaMayor=suma;
					inicioM = inicio;
					finM = fin;
				}
				inicio = busca_inicio(arr,fin+1);
				
			}
		}
		System.out.println("El inicio de la secuencia mayor esta en la posiccion: "+inicioM + " y el fin en: "+finM);
	}
	
	public static int busca_inicio(int [] arr, int posprevia){
		int i= posprevia;
		
		while((i<MAXCOLUMNA)&&(arr[i] == 0)){
			i++;
		}
		if(i<MAXCOLUMNA) {
			return i;
		}else {
			return -1;
		}
	}
	
	public static int busca_fin(int []arr, int inicio){
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
	
	public static int suma_secuencia(int []arr, int inicio, int fin) {
		int suma=0;
		for(int i=inicio; i<= fin; i++) {
			suma += arr[i];
		}
		return suma;
	}
}
