package practico7;

import java.util.Random;

//Dado un arreglo DESORDENADO de números entre 1 y 9 de
//tamaño MAX que tiene los elementos sin orden, se pide lo
//siguiente:
//– a) Cargar un arreglo ORDENADO de tamaño MAX (inicializado
//con -1). ORDENADO tiene posiciones del arreglo DESORDENADO
//de forma tal que permite recorrer de forma ascendente y
//consecutiva los valores pares del arreglo DESORDENADO (no se
//pide ordenar ORDENADO). ORDENADO tiene valores -1 al final
//cuando DESORDENADO tiene valores impares.
//
//– b) Para valores (elemento y posición) ingresados por el usuario, si
//elemento esta entre 1 y 9, es impar, y posición es valida, insertar
//el elemento en DESORDENADO en la posición indicada y luego
//actualizar el arreglo ORDENADO sin acceder a DESORDENADO.

public class ej17 {
	public static final int MAX = 10;
	public static final int MAXVALOR= 9;
	public static final int MINVALOR = 1;

	public static void main(String [] args) {
		int [] desordenado = new int[MAX];
		int [] ordenado = new int [MAX];

		cargar_arreglo_aleatorio_int(desordenado);
		imprimir_arreglo_secuencias_int(desordenado);

		cargar_arreglo_ordenado(ordenado);
		imprimir_arreglo_secuencias_int(ordenado);
	}

	//imprime arreglo de secuencias
	public static void imprimir_arreglo_secuencias_int(int [] arr){
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}
	//carga de arreglo de int con valores de MINVALOR a MAXVALOR
	public static void cargar_arreglo_aleatorio_int(int [] arr){
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++){
			arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
		}
	}
	

	//carga arreglo con ceros
	public static void cargar_arreglo_ordenado(int []arr) {
		for(int pos=0;pos < MAX;pos++) {
			arr[pos]=-1;
		}
	}

	//devuelve incices del arreglo desordenado que tiene como valor un numero par
	public static int devuelve_indices_valores_par(int [] arr) {
		int i=0;

		while((i<MAX)&&(arr[i]%2 !=0)) {
			i++;
		}
		if(i<MAX) {
			return i;
		}else {
			return -1;
		}	
	}
	
	




}
