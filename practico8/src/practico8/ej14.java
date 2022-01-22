package practico8;

//Hacer un programa que dada la matriz de secuencias de caracteres definida y
//precargada, elimine de cada fila todas las ocurrencias de una secuencia
//patrón dada por un arreglo de caracteres de tamaño igual al tamaño de
//columnas de la matriz (solo tiene esa secuencia con separadores al inicio y al
//final). Al eliminar en cada fila se pierden los valores haciendo los corrimientos.

public class ej14 {
	public static final int MAXFILA=4;
	public static final int MAXCOLUMNA= 20;
	public static final char MAXVALOR = 'z';
	public static final char MINVALOR = 'a';
	public static final double probabilidad_letra = 0.3;
	
	public static void main(String[]args) {
		char [][] matchar = {{' ','a','b','c',' ','e','q','d',' ','y','z',' ','a','b','c',' ',' ','o','p',' '},
				{' ','o','s','v',' ','w','z',' ',' ','a','b','c',' ','e','r',' ','u','h','j',' '},
				{' ','a','b','c',' ','e','q','d',' ','y','z',' ','a','b','c',' ',' ','o','p',' '},
				{' ',' ','s','g','i',' ','e','p','p',' ','o',' ','a','b','c',' ',' ','l','u',' '}};
		
		
		char [] arrchar = {' ','a','b','c',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
		
		System.out.println("Matriz inicial ");
		imprimir_matriz_char(matchar);
		
		System.out.println("Arreglo patron ");
		imprimir_arreglo_secuencias_char(arrchar);
		
		elimina_por_fila(matchar,arrchar);
		System.out.println("Matriz final ");
		imprimir_matriz_char(matchar);
	}

	
	public static void imprimir_matriz_char(char [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			imprimir_arreglo_secuencias_char(mat[fila]);
			System.out.println("");
		}
	}

	public static void imprimir_arreglo_secuencias_char(char [] arr){
			System.out.print("|");
			for (int pos = 0; pos < MAXCOLUMNA; pos++){
				System.out.print(arr[pos]+"|");
			}
		}
	
	public static void elimina_por_fila(char [][] mat, char []arr) {
		for (int fila =0; fila<MAXFILA; fila++) {
			elimina_secuencia_igual(mat[fila],arr);
		}
	}
	
	public static void elimina_secuencia_igual(char []arr,char [] arrPatron ) {
		int inicio = busca_inicio(arr,0);
		int fin = -1;
		
		int inicioP = busca_inicio(arrPatron,0);
		int finP = busca_fin(arrPatron,inicio);
		
		while(inicio != -1) {
			fin =  busca_fin(arr,inicio);
			if(fin != -1) {
				if(sonIguales(arr, arrPatron, inicio,fin,inicioP,finP)) {

//					elimino_secuencia( arr, inicio,fin);
					 elimino_con_corrimiento(arr, inicio,fin);
				}
				inicio = busca_inicio(arr,fin+1);
			}
		}
	}
	
	public static int busca_inicio(char [] arr, int indiceprevio) {
		int i= indiceprevio;
		
		while((i<MAXCOLUMNA)&&(arr[i] == ' ')) {
			i++;
		}
		if(i<MAXCOLUMNA) {
			return i;
		}else {
			return -1;
		}
	}
	
	public static int busca_fin (char [] arr, int inicio) {
		int i= inicio;
		
		while((i<MAXCOLUMNA)&&(arr[i] != ' ')) {
			i++;
		}
		if(i<MAXCOLUMNA) {
			return i-1;
		}else {
			return -1;
		}
	}
	
	public static boolean sonIguales(char [] arr ,char[]arrP ,int inicio, int fin, int inicioP, int finP ) {
		boolean iguales= false;
		int i= inicio;
		int pos = inicioP;
		
		int cant= fin-inicio+1;
		int cantP = finP-inicioP+1;
		int iteracion =0;
		
		if(cant == cantP) {
			while((arr[i] == arrP[pos])&&(iteracion< cant)) {
				i++;
				pos++;
				iteracion++;
			}
		}
		if(iteracion == cant) {
			iguales = true;
		}
		return iguales;
	
	}
	//funciona pero nos es el mas adecuado
	public static void elimino_secuencia(char [] arr, int inicio,int fin) {
		for(int i = fin; i>=inicio;i--) {
			arr[i]= arr[i+1];
		}
	}
	
	//la mejor forma de eliminar una secuencia completa
	public static void elimino_con_corrimiento(char [] arr, int inicio, int fin) {
		int tamanio = fin-inicio+1;
		
		for(int i = fin+1; i<MAXCOLUMNA; i++) {
			arr[i-tamanio] = arr[i];
		}
	}
}
