package practico8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hay dos matrices MAT1 y MAT2 de secuencias de caracteres letras separados por espacios de tamaño MAXF x MAXC que están precargadas. 
//Ambas matrices están precargadas y cada fila empieza y termina con caracteres espacios. Además se tiene el siguiente método:
//
//– un método que retorna el índice inicial de la secuencia de mayor tamaño de un arreglo de secuencias (de caracteres letras minúsculas 
//separados por espacios) de tamaño MAXFIL. check!!
//
//Se pide realizar un programa que
//– contenga la definición de los encabezados de los métodos de carga de la matriz y del método mencionado en el enunciado (se supone 
//que existen y no se requiere implementarlos). check!!!
//
//– para MAT1 y MAT2 elimine de cada secuencia el primer carácter vocal. check!!!!
//
//– para MAT1 agregue al principio de cada secuencia el primer carácter de la secuencia de mayor tamaño de dicha fila.
//
//– en cada fila, si se verifica que la secuencia de mayor tamaño de la fila para MAT1 es mayor que la primer secuencia en dicha fila 
//para MAT2, las intercambie (la que está en MAT1 pasa a MAT2 y la que esta en MAT2 pasa a MAT1) sin usar estructuras auxiliares (otros 
//arreglos o matrices). checck!!
//
//– para un valor de fila ingresado por el usuario verifique e imprima si la primera secuencia de MAT1 en dicha fila es igual la primera 
//secuencia de MAT2 en dicha fila.

public class ej16 {
	public static final int MAXFILA=4;
	public static final int MAXCOLUMNA= 20;
	public static final char MAXVALOR = 'z';
	public static final char MINVALOR = 'a';
	public static final double probabilidad_letra = 0.3;

	public static void main(String[]args) {
//		char [][] MAT1 = new char [MAXFILA][ MAXCOLUMNA];
//		char [][] MAT2 = new char[MAXFILA][MAXCOLUMNA];
//		char [] arrchar = new char[MAXCOLUMNA];
		
		char [][] MAT1 = {{' ','a','b','c',' ','e','q','d',' ','y','z',' ','a','b','c',' ',' ','o','p',' '},
				{' ','o','s','v',' ','w','z',' ',' ','a','b','c',' ','e','r',' ','u','h','j',' '},
				{' ','a','b','c',' ','e','q','d',' ','y','z',' ','a','b','c',' ',' ','o','p',' '},
				{' ',' ','s','g','i',' ','e','p','p',' ','o',' ','a','b','c',' ',' ','l','u',' '}};
		
		char [][] MAT2 = {{' ','a','b','c',' ','e','q','d',' ','y','z',' ','a','b','c',' ',' ','o','p',' '},
				{' ','o','s','v',' ','w','z',' ',' ','a','b','c',' ','e','r',' ','u','h','j',' '},
				{' ','a','b','c',' ','e','q','d',' ','y','z',' ','a','b','c',' ',' ','o','p',' '},
				{' ',' ','s','g','i',' ','e','p','p',' ','o',' ','a','b','c',' ',' ','l','u',' '}};
		
		
		
//		
//		int  ind;
		int fila;

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Matriz MAT1");
//			cargar_matriz_aleatorio_secuencias_char(MAT1);
			imprimir_matriz_char(MAT1);

			System.out.println("Matriz MAT2");
//			cargar_matriz_aleatorio_secuencias_char(MAT2);
			imprimir_matriz_char(MAT2);
			
			
			
//			System.out.println("Matriz MAT1");
//			elimina_primer_cararacter(MAT1);
//			imprimir_matriz_char(MAT1);
//			
//			System.out.println("Matriz MAT2");
//			elimina_primer_cararacter(MAT2);
//			imprimir_matriz_char(MAT2);
			
			
//			System.out.println("Arreglo");
//			cargar_arreglo_aleatorio_secuencias_char(arrchar);
//			imprimir_arreglo_secuencias_char(arrchar);
//			ind= devuelve_indice_de_secuencia_mayor(arrchar);
//			System.out.println("    El indice inicial de la mayor secuencia es en "+ ind+ " con una "+ arrchar[ind]);
//			
//			System.out.println("Matriz MAT1- Agrega inicial");
//			agrega_caracter_en_mat(MAT1,arrchar);
//			imprimir_matriz_char(MAT1);
//			
			
//			intercambio_en_matrices(MAT1, MAT2 );
//			
//			System.out.println("Matriz MAT1");
//			imprimir_matriz_char(MAT1);
//
//			System.out.println("Matriz MAT2");
//			imprimir_matriz_char(MAT2);

			System.out.println("Ingrese un numero de fila");
			fila =  Integer.valueOf(entrada.readLine());
			comparo_matrices(MAT1, MAT2, fila);
			
		}
		catch (Exception exc){
			System.out.println(exc);
		}
	}



	public static void cargar_matriz_aleatorio_secuencias_char(char [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			cargar_arreglo_aleatorio_secuencias_char(mat[fila]);
		}
		System.out.println("");
	}

	public static void cargar_arreglo_aleatorio_secuencias_char(char [] arr){
		Random r = new Random();
		arr[0] = ' ';
		arr[MAXCOLUMNA-1] = ' ';
		for (int pos = 1; pos < MAXCOLUMNA-1; pos++){
			if (r.nextDouble()>probabilidad_letra){
				arr[pos]=(char)(r.nextInt(26) + 'a');
			}
			else{
				arr[pos]=' ';				
			}
		}
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
	
	public static void elimina_primer_cararacter(char [][] mat) {
		for(int fila=0; fila< MAXFILA; fila++) {
			elimina_primer_vocal(mat[fila]);
		}
	}
	
	public static void elimina_primer_vocal(char [] arr) {
		int inicio = busca_inicio(arr,0);
		int fin = -1;
		int pos= -1;
		
		while(inicio != -1) {
			fin = busca_fin(arr,inicio);
			if(fin != -1) {
					pos= busca_pos_primer_vocal(arr,inicio, fin);
					if(pos != -1) {
						corrimiento_izq(arr,pos);
						fin--;
				}
			}
			inicio = busca_inicio(arr,fin+1);
		}
	}
	
	public static int busca_inicio(char [] arr, int indiceprevio) {
		int i=indiceprevio;
		
		while((i<MAXCOLUMNA)&&(arr[i] == ' ')) {
			i++;
		}
		if(i<MAXCOLUMNA) {
			return i;
		}else {
			return -1;
		}
	}
	
	public static int busca_fin(char []arr, int inicio) {
		int i = inicio;
		
		while((i<MAXCOLUMNA)&&(arr[i] != ' ')) {
			i++;
		}
		if(i<MAXCOLUMNA) {
			return i-1;
		}else {
			return -1;
		}
	}
	
	public static int busca_pos_primer_vocal(char []arr, int inicio, int fin) {
		int i= inicio;

		while((i<= fin)&&(!esVocal(arr[i]))){
			i++;
		}
		if(i<= fin) {
			return i; 
		}else {
			return -1;
		}
	}

	
	public static boolean esVocal(char c) {
		return c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u';
	}
	
	public static void corrimiento_izq(char [] arr, int pos) {
		for(int i= pos; i< MAXCOLUMNA-1; i++) {
			arr[i]= arr[i+1];
		}
	}
	
	//metodo que se supone que ya existe
	public static int devuelve_indice_de_secuencia_mayor(char [] arr) {
		int inicio= busca_inicio(arr,0);
		int fin =-1;
		int cantMayor=0;
		int inicioM =0;
		
		while(inicio != -1) {
			fin= busca_fin(arr,inicio);
			if(cantMayor < (fin-inicio+1)) {
				cantMayor =  fin-inicio+1;
				inicioM = inicio;
			}
			inicio= busca_inicio(arr,fin+1);
		}
		return inicioM;
	}
	
	public static void agrega_caracter_en_mat(char [][] mat, char [] arrchar) {
		int inicioArreglo = devuelve_indice_de_secuencia_mayor(arrchar);
		char letraInicial = arrchar[inicioArreglo];
//		System.out.println("iniial "+letraInicial);
		for(int fila = 0; fila<MAXFILA; fila++) {
			agrega_por_secuencia(mat[fila], letraInicial );
		}
	}
	
	public static void agrega_por_secuencia(char [] arr, char inicial) {
		int inicio = busca_inicio(arr,0);
		int fin = -1;
		
		while(inicio != -1) {
			fin = busca_fin(arr,inicio);
	
			if(fin != -1) {
//				System.out.println("inicio "+inicio);
//				System.out.println("fin "+ fin);
				corrimiento_der(arr,inicio,fin);
				arr[inicio]= inicial;
//				imprimir_arreglo_secuencias_char(arr);
				
			}
			inicio = busca_inicio(arr,fin+2);
		}
	}
	
	public static void corrimiento_der(char [] arr, int inicio, int fin){
		for(int i =MAXCOLUMNA-1; i> inicio ;i--){
			arr[i]=arr[i-1];
		}
	}
	
	public static void intercambio_en_matrices( char [][] MAT1, char [][] MAT2 ) {
		int inicioM1 = 0;
		int finM1 =1;
		int inicioM2=0;
		int finM2 =0;
		for(int fila = 0; fila< MAXFILA; fila++) {
			inicioM1= devuelve_indice_de_secuencia_mayor(MAT1[fila]);
			inicioM2=busca_inicio(MAT2[fila],0);
			finM1= busca_fin(MAT1[fila],inicioM1);
			finM2= busca_fin(MAT2[fila], inicioM2);
			
			if((finM1-inicioM1+1) > (finM2-inicioM2+1)) {
				intercambia_secuencias(MAT1[fila], MAT2[fila], inicioM1, finM1, inicioM2,finM2 );
			}
		}
	}
	
	public static void intercambia_secuencias(char []ARR1,char []ARR2, int inicioM1, int finM1, int inicioM2, int finM2) {
		int cant1 = finM1-inicioM1+1;
		int cant2 = finM2-inicioM2+1;

		int dif=cant1 -cant2;

		for(int iter=0; iter<dif;iter++) {
			corrimiento_der(ARR2,inicioM2,finM2);
		}


		for(int i=inicioM1; i<=finM1;i++) {
			for(int pos= finM2+dif; pos>=inicioM2;pos--) {
				char aux1 = ARR1[i];
				ARR1[i]  = ARR2[pos];
				ARR2[pos]= aux1;

			}
		}
	}
	
	public static void comparo_matrices(char[][] MAT1, char [][]MAT2, int fila) {
		int i= 0;
		
		while((i< MAXFILA)&&(i != fila)){
			i++;
		}
		if(i<MAXFILA) {
			compara_secuencias_matrices(MAT1[i], MAT2[i]);
		}
	}
	
	public static void compara_secuencias_matrices(char [] arr1, char []arr2) {
		int inicioArr1= busca_inicio(arr1,0);
		int finArr1= busca_fin(arr1,inicioArr1);
		
		int inicioArr2= busca_inicio(arr2,0);
		int finArr2= busca_fin(arr2,inicioArr2);
		
		boolean  sonIguales = sonIguales(arr1, arr2,inicioArr1, finArr1,inicioArr2, finArr2 );
		
		if(sonIguales == true) {
			System.out.println("Las secuencias son iguales " );
		}else {
			System.out.println("Las secuencias NO son iguales " );
		}
	}
	
	public static boolean sonIguales (char [] arr1, char [] arr2, int inicioArr1,int finArr1, int inicioArr2, int finArr2 ) {
		boolean iguales = true;
		
		int cant1 = finArr1-inicioArr1+1;
		int cant2 = finArr2 -inicioArr2+1;
		
		int i1 = inicioArr1;
		int i2 = inicioArr2;
		
		if(cant1 == cant2) {
			while(i1<= finArr1) {
				
				if((arr1[i1] != arr2[i2])) {
					iguales= false;
				}
				i1++;
				i2++;
			}
		}
	
		return iguales;
	}
	
}
