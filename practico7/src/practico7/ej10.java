package practico7;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Se tiene un arreglo de enteros de tamaño 20 de secuencias de números entre
//1 y 9, separadas por 0. El arreglo esta precargado, y además empieza y
//termina con uno o más separadores 0. Considere para los siguientes ejercicios
//este tipo de arreglo.
//
//Hacer un programa que dado el arreglo definido y precargado permita
//obtener a través de métodos la posición de inicio y la posición de fin de la
//secuencia ubicada a partir de una posición entera ingresada por el
//usuario. Finalmente, si existen imprima por pantalla ambas posiciones
//obtenidas.

public class ej10 {
	public static final int MAX = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_letra = 0.4;
	public static final double probabilidad_numero = 0.4;
	
	public static void main(String [] args) {
		int [] arrInt = new int [MAX];
		int pos,inicio,fin;

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		try {
			cargar_arreglo_aleatorio_secuencias_int(arrInt);
			imprimir_arreglo_secuencias_int(arrInt);

			System.out.println("Ingrese una posicion del arrglo: ");
			pos= Integer.valueOf(entrada.readLine());
			inicio = busca_inicio(arrInt, pos);
			fin = busca_fin(arrInt, pos);
			System.out.println("El inicio de la secuencia se encuentra en: "+inicio+ " y el fin en: "+fin);

		}
		catch (Exception exc){
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
	
	//imprimime arreglo de secuencias
	public static void imprimir_arreglo_secuencias_int(int [] arr){
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}

	//busca inicio
	public static int busca_inicio(int [] arr, int pos){
		int i= pos ;
		while(arr[i] != 0) {
			i--;
		}
		return i+1;
	}
	
	//busca el fin de secuencias
	public static int busca_fin(int[] arr, int pos) {
		int i=pos;
		while(arr[i] != 0) {
			i++;
		}
		return i-1;
	}
	


}
