package practico8;

import java.util.Random;

//Hacer un programa que dada la matriz de secuencias de caracteres definida y
//precargada, permita encontrar por cada fila la posición de inicio y fin de la
//anteúltima secuencia (considerar comenzar a buscarla a partir de la ultima
//posición de la fila).

public class ej12 {
	public static final int MAXFILA=4;
	public static final int MAXCOLUMNA= 20;
	public static final char MAXVALOR = 'z';
	public static final char MINVALOR = 'a';
	public static final double probabilidad_letra = 0.3;
	
	public static void main(String[]args) {
		char [][] matchar = new char [MAXFILA][ MAXCOLUMNA];
		
		cargar_matriz_aleatorio_secuencias_char(matchar);
		imprimir_matriz_char(matchar);
		
		busca_inicio_fin_anteultima(matchar); 
		
		
	}
	
	
	
	public static void cargar_matriz_aleatorio_secuencias_char(char [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			cargar_arreglo_aleatorio_secuencias_char(mat[fila]);
		}
		System.out.println("");
	}

	public static void cargar_arreglo_aleatorio_secuencias_char(char [] arr){
			Random r = new Random();
			arr[0] = ' ';
			arr[MAXCOLUMNA-1] = ' ';
			for (int pos = 1; pos < MAXCOLUMNA-1; pos++){
				if (r.nextDouble()>probabilidad_letra){
					arr[pos]=(char)(r.nextInt(26) + 'a');
				}
				else{
					arr[pos]=' ';				
				}
			}
		}
	
	public static void imprimir_matriz_char(char [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			imprimir_arreglo_secuencias_char(mat[fila]);
			System.out.println("");
		}
	}

	public static void imprimir_arreglo_secuencias_char(char [] arr){
			System.out.print("|");
			for (int pos = 0; pos < MAXCOLUMNA; pos++){
				System.out.print(arr[pos]+"|");
			}
		}
	
	public static void busca_inicio_fin_anteultima(char [][] mat) {
		for(int fila =0; fila<MAXFILA; fila++) {
			System.out.println("Fila "+fila);
			busca_anteultima_secuencia(mat[fila]);
		}
	}
	
	public static void busca_anteultima_secuencia(char []arr) {
		int fin = busca_fin(arr, MAXCOLUMNA-1);
		int inicio=-1; ;
		int contador=0;
		
		while((fin != -1)&&(contador <2)) {
			inicio= busca_inicio(arr,fin);
			if(inicio != -1) {
				contador++;
				
				if(contador <2) {
				fin =busca_fin(arr, inicio-1);
				}
			}
		}
		System.out.println("Anteultima secuencia inicia en la posicion "+inicio + " y el fin esta en "+fin);
	}
	
	public static int busca_inicio(char []arr, int fin) {
		int i= fin;
		
		while((i>0)&&(arr[i] != ' ')) {
			i--;
		}
		if(i>0) {
			return i+1;
		}else {
			return -1;
		}
	}
	
	public static int busca_fin(char []arr, int indiceprevio) {
		int i= indiceprevio;
		
		while((i>0)&&(arr[i] == ' ')) {
			i--;
		}
		if(i>0) {
			return i;
		}else {
			return -1;
		}
	}


}
