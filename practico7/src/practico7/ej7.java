package practico7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Hacer un programa que dado un arreglo ordenado creciente de enteros
//de tamaño 10 que se encuentra precargado, solicite al usuario un numero
//entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá
//que realizar un corrimiento a derecha (se pierde el último valor del arreglo)
//y colocar el numero en el arreglo en la posición indicada.

public class ej7 {
	public static final int MAX = 10;

	public static void main (String [] args) {
		int[] arrInt =  new int [MAX];

		int num,pos;

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		try {
			cargar_arreglo_consola(arrInt);
			imprimir_arreglo_int(arrInt);

			System.out.println("Ingrese un numero entero: ");
			num= Integer.valueOf(entrada.readLine());
			
			pos = pos_corrimiento(arrInt, num);
			inserta_con_corrimiento_der(arrInt, pos, num);
			imprimir_arreglo_int(arrInt);


		}
		catch (Exception exc){
			System.out.println(exc);
		}
	}

	//cargo el array por consola
	public static void cargar_arreglo_consola(int[] arr) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {

			for (int i = 0; i < MAX; i++) {

				System.out.println("Ingrese un valor número entero en la posición " + i);

				arr[i] = Integer.valueOf(entrada.readLine());
			}
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	//impresion de arreglo de int
	public static void imprimir_arreglo_int(int [] arr) {
		for (int i = 0; i < MAX; i++) {
			System.out.print("[" + arr[i] + "]");
		}
		System.out.println(" ");
	}
	
	//busca pos 
	public static int pos_corrimiento(int [] arr, int num) {
		int i=0;
		
		while((i < MAX) && (arr[i] < num)) {
			i++;
		}
		
		return i;
	}
	
	//hace corrimiento a derecha e inserta el num en pos
	public static void inserta_con_corrimiento_der(int [] arr, int pos, int num) {
		
		int i = MAX-1;            //cuando es corrimiento a derecha siempre empiezo desde MAX 
		
		while(i>pos) {
			arr[i] = arr[i-1];
			
			i--;
		}
		
		arr[pos]= num;
	}
	

}


