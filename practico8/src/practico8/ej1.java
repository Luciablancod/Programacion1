package practico8;

//Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
//precargada, invierta el orden del contenido por fila. Este intercambio no se debe realizar
//de manera explícita, hay que hacer un método que incluya una iteración de intercambio.

import java.util.Random;
class ej1 {
public static final int MAXFILA = 5;
public static final int MAXCOLUMNA = 10;
public static final int MAXVALOR = 9;
public static final int MINVALOR = 1;
public static void main(String[] args) {
  int [][] matInt = new int [MAXFILA][MAXCOLUMNA];
  
  
  System.out.println("Matriz int inicial");
  cargar_matriz_aleatorio_int(matInt);
	imprimir_matriz_int(matInt);
  
  System.out.println("Matriz int final");
  recorre_fila(matInt);
  imprimir_matriz_int(matInt);
  
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

	public static void recorre_fila(int [][] mat){
    for (int fila = 0; fila<MAXFILA; fila++) {
      recorre_columna(mat[fila]);
    }
  }

	public static void recorre_columna(int [] arrfila){
    int i =0;
    while (i<= (MAXCOLUMNA/2)){
      int aux = arrfila[i];
      arrfila[i] = arrfila[MAXCOLUMNA-i-1];
      arrfila[MAXCOLUMNA-i-1]= aux;
      i++;
    }
  }
}
