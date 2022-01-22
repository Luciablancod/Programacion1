package practico7;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
//precargado, solicite al usuario un numero entero y lo agregue al principio del arreglo (posición
//0). Para ello tendrá que realizar un corrimiento a derecha (se pierde el último valor del arreglo) y
//colocar el numero en el arreglo en la posición indicada.

public class ej4 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;

	public static void main (String [] args) {
		int [] arrInt = new int [MAX];

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			cargar_arreglo_aleatorio_int(arrInt);
			System.out.println("Array");
			imprimir_arreglo_int(arrInt);
			System.out.println("Ingrese un numero entero: ");

			int pos = Integer.valueOf(entrada.readLine());
			corrimiento_der(arrInt,pos);
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
	
	//corrimiento dererecha
	public static void corrimiento_der(int [] arr, int pos) {
		int i = MAX -1;         //recorre desde atras
		
		while(i> pos) {
			arr[i] = arr[i-1];
			i--;
		}
		arr[0]= pos;
	}

}
