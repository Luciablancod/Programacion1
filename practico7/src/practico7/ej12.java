package practico7;

import java.util.Random;

//Hacer un programa que dado el arreglo definido y precargado permita
//encontrar la posición de inicio y fin de la anteúltima secuencia (considerar
//comenzar a buscarla a partir de la ultima posición del arreglo).

public class ej12 {
	public static final int MAX =20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;

	public static void main (String [] args) {
		int [] arrInt = new int [MAX];

		cargar_arreglo_aleatorio_secuencias_int(arrInt);
		imprimir_arreglo_secuencias_int(arrInt);
		imprime_inicio_fin(arrInt);
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
	
	//busca fin desde atras
	public static int busca_fin(int [] arr, int indiceprevio) {
		int i = indiceprevio;
		while((i > 0)&&(arr[i] == 0)){
			i--;
		}
		if(i>0) {
		return i;
		}else {
			return -1;
		}
	}
	
	//busca el inicio de una seuencia desde atras
	public static int busca_inicio(int [] arr, int fin) {
		int i = fin;
		while((i>0)&&(arr[i] != 0)){
			i--;
		}
		if(i> 0) {
			return i+1;
		}else {
			return -1;
		}
	}
	
	//busca principio y fin de la anteultima secuencia
	public static void imprime_inicio_fin(int [] arr) {
		int fin =  busca_fin(arr, MAX-1);
		int inicio = 0;
		int iteracion = 0;

		int finA=0;
		int inicioA=0 ;
		
		while((fin != -1)&&(iteracion < 2)) {
			
				inicio =busca_inicio(arr, fin);
				
				if(inicio != -1) {

					iteracion++;
					finA =fin;
					inicioA = inicio;
				}
				fin = busca_fin(arr, inicio-1);
			
		}
	System.out.println("El inicio de la anteultima secuencia es en la pos: "+ inicioA + " y el fin en "+ finA);
	}

}
