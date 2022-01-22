package practico7;

//Hacer un programa que dado el arreglo definido y precargado elimine todas
//las secuencias que tienen orden descendente entre sus elementos.

public class ej16 {
	public static final int MAX= 20;

	public static void main (String [] args) {
		int [] arrInt={0,3,2,1,0,0,0,9,8,7,0,5,3,0,0,0,1,2,3,0};

		imprimir_arreglo_secuencias_int(arrInt);
		elimina_secuencias_decrecientes(arrInt);
		imprimir_arreglo_secuencias_int(arrInt);

	}

	//imprime arreglo de secuencias
	public static void imprimir_arreglo_secuencias_int(int [] arr){
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}

	//busca inicio
	public static int devuelve_inicio(int [] arr, int indiceprevio) {
		int i= indiceprevio;

		while((i<MAX)&&(arr[i] == 0)) {
			i++;
		}
		if(i<MAX) {
			return i;
		}else {
			return -1;
		}
	}

	//busca fin
	public static int devuelve_fin(int [] arr, int inicio) {
		int i=inicio;

		while((i<MAX)&&(arr[i] != 0)) {
			i++;
		}
		if(i<MAX) {
			return i-1;
		}else {
			return -1;
		}
	}

	public static boolean esDecreciente(int [] arr, int inicio, int fin) {
		boolean esDecreciente = false;
		int i=inicio;
		while((i<fin)&(arr[i]> arr[i+1])) {
			i++;
		}
		if(arr[i-1]> arr[i]) {
			esDecreciente = true;
		}

		return esDecreciente;
	}

	public static void elimina_secuencia(int [] arr, int inicio, int fin) {

		for(int i= fin; i>= inicio; i--) {
			arr[i]= arr[i+1];
		}
	}

	public static void elimina_secuencias_decrecientes(int []arr) {
		int inicio= devuelve_inicio(arr,0);
		int fin =0;

		while(inicio != -1) {
			fin= devuelve_fin(arr,inicio);
			if(fin != -1) {

				if(esDecreciente(arr,inicio, fin)== true) {
					elimina_secuencia(arr,inicio,fin);
				}
			}
			inicio= devuelve_inicio(arr,fin+1);
		}
	}
}
