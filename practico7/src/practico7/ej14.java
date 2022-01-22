package practico7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado el arreglo definido y precargado, y un número
//entero ingresado por el usuario, copie de forma continua las secuencias de
//tamaño igual al número ingresado en otro arreglo de iguales características e
//inicializado con 0. La copia en este último arreglo deben comenzar desde el
//principio del mismo.

public class ej14 {
	public static final int MAX = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero= 0.4;


	public static void main(String [] args) {
		int [] arrInt = new int [MAX];
		int [] arrCeros = new int[MAX];
		

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			cargar_arreglo_aleatorio_secuencias_int(arrInt);
			imprimir_arreglo_secuencias_int(arrInt);
			cargar_arreglo_ceros(arrCeros);
			imprimir_arreglo_secuencias_int(arrCeros);
			
			System.out.println("Ingrese un numero entero: ");
			int num = Integer.valueOf(entrada.readLine());
			
			copia_a_array_ceros( arrInt, num, arrCeros);
			
			System.out.println("Array de ceros final: ");
			imprimir_arreglo_secuencias_int(arrCeros);
			
		}
		catch(Exception exc){
			System.out.println(exc);
		}
	}
	

	//carga arreglo de secuencias
	public static void cargar_arreglo_aleatorio_secuencias_int(int []
			arr){
		Random r = new Random();
		arr[0] = 0;
		arr[MAX-1] = 0;
		for (int pos = 1; pos < MAX-1; pos++){
			if (r.nextDouble()>probabilidad_numero){
				arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
			}
			else{
				arr[pos]=0;
			}
		}
	}

	//imprime arreglo de secuencias
	public static void imprimir_arreglo_secuencias_int(int [] arr){
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}
	
	//carga arreglo con ceros
	public static void cargar_arreglo_ceros(int []arr) {
		for(int pos=0;pos < MAX;pos++) {
			arr[pos]=0;
		}
	}
	
	public static int busca_inicio(int [] arr, int indiceprevio) {
		int i = indiceprevio;
		
		while((i<MAX)&&(arr[i] == 0)){
			i++;
		}
		if(i<MAX) {
			return i;
		}else {
			return -1;
		}
	}
	
	public static int busca_fin(int [] arr, int inicio) {
		int i= inicio;
		
		while((i<MAX)&&(arr[i]!= 0)) {
			i++;
		}
		if(i<MAX) {
			return i-1;
		}else {
			return -1;
		}
	}
	
	public static int devuelve_primer_cero(int [] arrCeros) {
		int i=0;
		while((i<MAX)&&(arrCeros[i] != 0)) {
			i++;
		}
		if(i<MAX) {
		return i;
		}else {
			return -1;
		}
	}
	
	public static void pasa_secuencia(int [] arr, int inicio, int fin, int [] arrCeros) {
		int pos = devuelve_primer_cero(arrCeros);
		
		for(int i = inicio; i<= fin; i++) {
			
			arrCeros[pos]= arr[i];
			pos++;
		}
	}
	
	public static void copia_a_array_ceros(int [] arr, int num, int [] arrCeros) {
		int inicio = busca_inicio(arr,0);
		int fin =0;
		
		while(inicio != -1) {
			fin= busca_fin(arr,inicio);
			if(fin != -1) {
				if((fin-inicio+1) == num) {
					pasa_secuencia(arr, inicio,fin,arrCeros);
				}
			}
			inicio = busca_inicio(arr,fin+1);
		}
	}
	

	
}
