package practico7;

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
//precargado, solicite al usuario un numero entero y elimine la primer ocurrencia de numero (un
//número igual) en el arreglo si existe. Para ello tendrá que buscar la posición y si está, realizar un
//corrimiento a izquierda (queda una copia de la última posición del arreglo en la anteúltima
//posición).

public class ej5 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;

	public static void main (String [] args) {
		int [] arrInt = new int [MAX];
		int pos;

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			cargar_arreglo_aleatorio_int(arrInt);
			System.out.println("Array");
			imprimir_arreglo_int(arrInt);
			System.out.println("Ingrese un numero entero: ");

			int num = Integer.valueOf(entrada.readLine());
			

			if (tieneNum(arrInt, num)) {
				pos = devuelvePos(arrInt, num );
				System.out.println("El numero ingresado esta en la posicion: " +pos);
				eliminar_corrimiento_izq(arrInt,pos);
				imprimir_arreglo_int(arrInt);
			}else {
				System.out.println("El numero ingresado no se encuentra en el array ");
			}
			
			
		}
		catch(Exception exc){
			System.out.println(exc);
		}
	}

	//carga de arreglo de int con valores de MINVALOR a MAXVALOR
	public static void cargar_arreglo_aleatorio_int(int [] arr){
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++){
			arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
		}
	}

	//impresion de arreglo de int
	public static void imprimir_arreglo_int(int [] arr) {
		for (int i = 0; i < MAX; i++) {
			System.out.print("[" + arr[i] + "]");
		}
		System.out.println(" ");
	}
	
	//busca si existe el num en el array 
	public static boolean tieneNum(int [] arr, int num) {
		boolean tiene = false;
		int i =0;
		
		while(i<MAX) {
			if(arr[i] == num) {
				return tiene = true;
			}
			
			i++;
		}	
		return tiene;
	}
	
	//busca un primera ocurrencia
	public static int devuelvePos(int [] arr, int num ) {
		int i=0;
		
		while(i<MAX && arr[i] != num) {
			
			i++;
		}
		return i;
	}
		
	
	//elimina con corrimiento a izquierda
	public static void eliminar_corrimiento_izq(int []arr, int pos) {
	int i =pos;
		while(i<MAX-1) {
			arr[i] = arr[i+1];
			i++;
		}
	}
}
