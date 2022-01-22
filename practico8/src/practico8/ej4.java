package practico8;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
//precargada, solicite al usuario un numero entero y una posición fila, columna. Con estos
//datos tendrá que realizar un corrimiento a derecha (se pierde el último valor en dicha fila)
//y colocar el numero en la matriz en la posición fila, columna indicada.

public class ej4 {
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MAXVALOR=9;
	public static final int MINVALOR = 1;

	public static void main (String []args) {
		int [][] matInt = new int [MAXFILA][MAXCOLUMNA];
		int fila, columna, num;

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("Matriz:");
			cargar_matriz_aleatorio_int(matInt);
			imprimir_matriz_int(matInt);

			System.out.println("Ingrese un numero");
			num =Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese una fila");
			fila =Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese una columna");
			columna =Integer.valueOf(entrada.readLine());

			System.out.println("Matriz resultado:");
			coloca_num(matInt, num, columna, fila );
			imprimir_matriz_int(matInt);

		}
		catch(Exception exc) {
			System.out.println(exc);
		}
	}

	public static void cargar_matriz_aleatorio_int(int [][] mat){
		Random r = new Random();
		for (int fila = 0; fila < MAXFILA; fila++){
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				mat[fila][columna]=(r.nextInt(MAXVALOR+MINVALOR-1) + MINVALOR);
			}
		}
	}

	public static void imprimir_matriz_int(int [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			System.out.print("|");
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				System.out.print(mat[fila][columna]+"|");
			}
			System.out.println("");
		}
	}
	
	public static void coloca_num(int [][] mat, int num,int columna, int fila ) {
		int i =0;
		
		while((i<MAXFILA)&&(i != fila)) {
			i++;
		}
		if(i== fila) {
			corrimiento_der(mat[i], columna, num);
		}
	}
	
	public static void corrimiento_der(int [] arr, int columna, int num) {
		
		for(int i= MAXCOLUMNA-1; i> columna; i--) {
			arr[i]= arr[i-1];
		}
		
		arr[columna] = num;
		
	}
}
