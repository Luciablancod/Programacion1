package practico7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se
//encuentra precargado, solicite al usuario el ingreso de dos números
//enteros (posiciones del arreglo) y ordene de forma creciente el arreglo
//entre dos posiciones correspondientes a los números ingresados.

public class ej9 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;

	public static void main (String [] args) {
		int [] arrInt = new int [MAX];
		int pos1, pos2;

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			cargar_arreglo_aleatorio_int(arrInt);
			System.out.println("Array");
			imprimir_arreglo_int(arrInt);

			System.out.println("Ingrese una posicion: ");
			pos1= Integer.valueOf(entrada.readLine());

			System.out.println("Ingrese una posicion: ");
			pos2= Integer.valueOf(entrada.readLine());
			
			ordenar_arreglo_seleccion(arrInt, pos1 , pos2);

			System.out.println("Ordenado");
			imprimir_arreglo_int(arrInt);

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
	
	
	//ordena por seleccion
	public static void ordenar_arreglo_seleccion(int[]arr, int pos1, int pos2) {
		int pos_menor, tmp;
		for (int i = pos1; i < MAX; i++) {				//recorro el array
			pos_menor = i;								//guardo en una variable la pos i
			for (int j = i + 1; j < pos2+1; j++){		//desde i +1 recorro 
				if (arr[j] < arr[pos_menor]) {			//si lo que hay en j es menor a ls que hay en i
					pos_menor = j;						//entoncces i va a ser igual a j (i+1)

				}
			}
			if (pos_menor != i){			//si lo que hay en j resulto ser mas chico que que lo que habia en i
				tmp = arr[i];				//entonces guardo en un temporal lo que se encontraba en arr[i]		
				arr[i] = arr[pos_menor];	//indico que lo que hay en arr[i] va a ser igual a arr[pos_menor] q es j
				arr[pos_menor] = tmp;		//por ultimo en arr[i+1]/arr[j]/arr[pos_menor] va a valer lo que era arr[i]
			}
		}
	}

}
