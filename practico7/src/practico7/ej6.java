package practico7;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
//precargado, solicite al usuario un numero entero y elimine todas las ocurrencia de numero en el
//arreglo si existe. Mientras exista (en cada iteración tiene que buscar la posición dentro del
//arreglo) tendrá que usar la posición para realizar un corrimiento a izquierda (quedarán tantas
//copias de la última posición del arreglo como cantidad de ocurrencias del número).

public class ej6 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;

	public static void main (String [] args) {
		int [] arrInt = new int [MAX];
		int pos,iteraciones;

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			cargar_arreglo_aleatorio_int(arrInt);
			System.out.println("Array");
			imprimir_arreglo_int(arrInt);
			System.out.println("Ingrese un numero entero: ");
			int num = Integer.valueOf(entrada.readLine());

			if(existeNum(arrInt,num)){
				iteraciones = cant_num(arrInt,  num);
				System.out.println("Existen : "+iteraciones + " numeros " + num);

				while(iteraciones !=0) {
					pos = busca_pos(arrInt,num);
					eliminar_corrimiento_izq(arrInt, pos);
					iteraciones --;

				}

				imprimir_arreglo_int(arrInt);
			}else {
				System.out.println("El numero ingesado no se encuentra en el array");
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

	//busca si existe el numero en el array
	public static boolean existeNum(int [] arr, int num) {
		boolean tiene= false;
		int i = 0;
		while(i<MAX) {
			if(arr[i] == num) {
				return tiene = true;
			}
			i++;
		}

		return tiene;
	}

	//cuenta cant de repetidos 
	public static int cant_num(int [] arr, int num) {
		int contador=0;;
		for (int i= 0; i<MAX; i++) {
			if(arr[i] == num) {
				contador++;
			}
		}
		return contador;
	}


	//busca la pos del numero
	public static int busca_pos(int [] arr,int num) {
		int i =0;

		while((i<MAX) && (arr[i] != num) ) {
			i++;
		}
		return i;
	}


	//elimina con corrimiento izq
	public static void eliminar_corrimiento_izq(int [] arr,int pos) {
		int i= pos;
		while(i<MAX-1) {
			arr[i] = arr[i+1];
			i++;
		}
	}
}
