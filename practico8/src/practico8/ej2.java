package practico8;

//Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
//precargada, obtenga la cantidad de números pares que tiene y la imprima.
import java.util.Random;

class ej2 {
 public static final int MAXFILA = 5;
 public static final int MAXCOLUMNA = 10;
 public static final int MAXVALOR =9;
 public static final int MINVALOR = 1;
   
   
public static void main(String[] args) {
 
  int [][] matInt = new int [MAXFILA][MAXCOLUMNA];
  int cant;
  
  cargar_matriz_aleatorio_int(matInt);
	imprimir_matriz_int(matInt);
  
  cant = cuenta_num_pares(matInt);
  
  System.out.println("La matriz tiene "+ cant + " numeros pares");
  
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

	public static int cuenta_num_pares(int [][] mat){
    int cant =0;
    for(int fila = 0; fila<MAXFILA; fila++){
      cant += num_pares_por_fila(mat[fila]);
    }
    return cant;
  }

	public static int num_pares_por_fila(int [] arrfila){
    int cant =0;
    for(int i= 0;i<MAXCOLUMNA; i++){
      if((arrfila[i] %2) ==0){
        cant++;
      }
    }
    return cant;
  }
}
