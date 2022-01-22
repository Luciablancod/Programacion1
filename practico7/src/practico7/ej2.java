package practico7;

import java.util.Random;

//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
//precargado, obtenga la cantidad de números pares que tiene y la imprima.

public class ej2 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	
	public static void main (String [] args) {
		int [] arrInt = new int [MAX];
		
		cargar_arreglo_aleatorio_int(arrInt);
		System.out.println("Array");
		imprimir_arreglo_int(arrInt);
		obtener_cant_num_pares(arrInt);
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
    
    public static void obtener_cant_num_pares(int [] arr) {
    	int contador=0;
    	for (int i = 0; i<MAX ; i++) {
    		if(arr[i] % 2 == 0) {
    			contador ++;
    		}
    	}
    	System.out.println("El array tiene " +contador + " numeros pares");
    }
	

}
