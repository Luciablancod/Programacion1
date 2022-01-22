package practico8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dada la matriz de secuencias de enteros definida y
//precargada, y un número entero ingresado por el usuario, elimine de cada fila
//las secuencias de tamaño igual al número ingresado.

public class ej13 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero= 0.4;
	
	public static void main (String [] args) {
		int [][] matInt = new int [MAXFILA][MAXCOLUMNA];
		
		int num;
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Matriz inicial ");
			cargar_matriz_aleatorio_secuencias_int(matInt);
			imprimir_matriz_int(matInt);
			
			System.out.println("Ingrese una fila de la matriz: ");
			num= Integer.valueOf(entrada.readLine());
			
			System.out.println("Matriz final ");
			elimina_secuencias_num(matInt,num);
			imprimir_matriz_int(matInt);
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

	public static void elimina_secuencias_num(int [][] mat,int num) {
		for(int fila=0; fila<MAXFILA; fila++) {
			elimina_secuencia_num(mat[fila], num);
		}
	}
	
	public static void elimina_secuencia_num(int []arr, int num) {
		int inicio= busca_inicio(arr,0);
		int fin = -1;
		int cant;
		
		while(inicio != -1) {
			fin = busca_fin(arr, inicio);
			if(fin != -1) {
			
				cant = fin-inicio+1;
				
				if(cant ==  num) {
					elimina_secuencia(arr,inicio,fin);
				}
			}
			 inicio= busca_inicio(arr,fin+1);
		}	
	}
	
	public static int busca_inicio(int [] arr, int indiceprevio) {
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
	
	public static int busca_fin(int []arr, int inicio) {
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
	
	//elimina y completa con ceros
	public static void elimina_secuencia(int [] arr, int inicio, int fin) {
		for(int i= fin; i>=inicio; i--) {
			arr[i] = arr[i+1];
		}
	}
	
}
