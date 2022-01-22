package practico7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Hacer un programa que dado un arreglo ordenado creciente de enteros
//de tamaño 10 que se encuentra precargado, solicite al usuario un numero
//entero y elimine la primer ocurrencia de numero (un número igual) en el
//arreglo si existe.

public class ej8 {
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
			
			if(existeNum(arrInt,num)) {
				pos = busca_pos(arrInt, num);
				elimina_con_corrimiento(arrInt, pos);
				imprimir_arreglo_int(arrInt);
			}else {
				System.out.println("El numero ingrasado no existe ");
			}
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
		
		//existe
		public static boolean existeNum(int [] arr, int num) {
			boolean tiene = false;
			int i = 0;
			while((i<MAX) && (tiene != true)) {
				if(arr[i] == num) {
					tiene = true;
				}
				i++;
			}
			
			return tiene;
		}

		
		//busco pos de primer ocurrencia
		public static int busca_pos(int [] arr, int num) {
			int i= 0;
			while((i<MAX)&&(arr[i] != num)) {
				i++;
			}
			return i;
		}
		
		//elimino con corrimient izq
		public static void elimina_con_corrimiento(int [] arr, int pos) {
			int i = 0;
			while(i <pos+1) {
				arr[i] = arr[i+1];
				i++;
			}
			
		}

}
