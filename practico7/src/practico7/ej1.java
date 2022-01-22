package practico7;

import java.util.Random;

//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
//precargado, invierta el orden del contenido (por ejemplo: el que está en 0 se intercambia con
//el que está en 9, el que está en 1 con el que está en 8...). Este intercambio no se debe realizar
//de manera explícita, hay que hacer un método que incluya una iteración de intercambio.

public class ej1 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;

	public static void main (String[]args) {
		int [] arrInt = new int [MAX];
		cargar_arreglo_aleatorio_int(arrInt);
		System.out.println("Array");
		imprimir_arreglo_int(arrInt);
		System.out.println("Array Invertido");
		invierte_array (arrInt);
		imprimir_arreglo_int(arrInt);
		
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

	//metodo que invierte el arreglo
	public static void invierte_array (int [] arr) {
		int valor;
		for(int i = 0; i< MAX / 2; i++) { // recorro el arreglo y lo divido en dos porque sino volveria a como esta antes
			valor = arr[i];  			//guardo el valor de i en una variable
			arr[i] = arr[MAX -1 -i ]; //en la posicion i pongo el valor de la posicion contraria a i
			arr[MAX -1 -i] = valor;   //en la pos contrario a i pongo el valor de i
			
		
		}
	}


}
