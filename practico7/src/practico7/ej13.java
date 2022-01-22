package practico7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado el arreglo definido y precargado, y un número
//entero ingresado por el usuario, elimine las secuencias de tamaño igual al número ingresado.

public class ej13 {
	public static final int MAX = 20;
	public static final int MAXVALOR =9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;

	public static void main (String [] args) {
		int [] arrInt = new int[MAX];

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			cargar_arreglo_aleatorio_secuencias_int(arrInt);
			System.out.println("Array de seuencia completo : ");
			imprimir_arreglo_secuencias_int(arrInt);
			
			System.out.println("Ingrese un numero entero: ");
			int num = Integer.valueOf(entrada.readLine());
			
			elimina_secuencias(arrInt,num);
			
			System.out.println("Array de secuencias final : ");
			imprimir_arreglo_secuencias_int(arrInt);
			
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
	
	
	public static int devuelve_inicio(int [] arr, int indiceprevio) {
		int i=indiceprevio;
		
		while((i<MAX)&&(arr[i] == 0)) {
			i++;
		}
		if(i<MAX) {
			return i;
		}else {
			return -1;
		}
	}
	
	public static int devuelve_fin(int []arr, int inicio) {
		int i= inicio;
		
		while((i<MAX)&&(arr[i] != 0)) {
			i++;
		}
		if(i<MAX) {
		return i-1;
		}else {
			return -1;
		}
	}
	
	public static void elimina_secuencia(int [] arr, int inicio, int fin) {
		
		for(int i= inicio; i<= fin; i++) {
			arr[i]=0;
		}		
		
	}
	
	public static void elimina_secuencia_corrimientoIzq(int [] arr, int inicio, int fin) {

		for(int pos = fin; pos >= inicio; pos--) {
			arr[pos] = arr[pos+1];
		}
		
	}
	
	
	
	public static void elimina_secuencias(int [] arr, int num) {
		int inicio = devuelve_inicio(arr,0);
		int fin =0;
		
		while(inicio != -1) {
			fin =  devuelve_fin(arr, inicio);
			
			if(fin != -1) {
				if((fin -inicio+1)== num) {
//					elimina_secuencia(arr, inicio,  fin);
					elimina_secuencia_corrimientoIzq(arr, inicio, fin);
				}
			}
			inicio = devuelve_inicio(arr,fin+1);
		}
	}

}
