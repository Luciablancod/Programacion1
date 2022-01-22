package practico7;

//Hacer un programa que dado el arreglo definido y precargado elimine del
//arreglo todas las ocurrencias de una secuencia patrón dada por otro arreglo
//de iguales características (solo tiene esa secuencia). Al eliminar se pierden los
//valores haciendo los corrimientos.

public class ej15 {
	public static final int MAX= 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numeros= 0.4;

	public static void main (String [] args) {
		int [] arrInt={0,1,2,3,0,0,0,7,8,9,0,5,3,0,0,0,1,2,3,0};
		int [] patron={0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

		imprimir_arreglo_secuencias_int(arrInt);
		imprimir_arreglo_secuencias_int(patron);
		
		elimina_secuencias_ocurrencias(arrInt,patron);
		
		imprimir_arreglo_secuencias_int(arrInt);
	}

	//imprime arreglo de secuencias
	public static void imprimir_arreglo_secuencias_int(int [] arr){
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}

	public static int devuelve_inicio(int [] arr, int indiceprevio) {
		int i = indiceprevio;

		while((i<MAX)&&(arr[i] ==0)){
			i++;
		}
		if(i<MAX) {
			return i;
		}else {
			return -1;
		}

	}

	public static int devuelve_fin(int [] arr, int inicio) {
		int i = inicio;

		while((i<MAX)&&(arr[i] != 0)) {
			i++;
		}
		if(i<MAX) {
			return i-1;
		}else {
			return -1;
		}
	}
	
	public static boolean sonIguales(int [] patron,int [] arr, int inicio,int fin) {
		boolean sonIguales= false;

		int inicioP =devuelve_inicio(patron,0);
		int finP = devuelve_fin(patron,inicioP);

		int cantP = finP - inicioP +1;
		int cant = fin - inicio +1;
		
		

		if(cantP == cant) {
			
			while((inicioP <= finP)&&(inicio <=fin) &&(patron[inicioP] == arr[inicio])) {
					inicioP++;
					inicio++;
//					System.out.print("holi"+inicioP);
				}
			if((inicioP-1 == finP)&&(inicio-1 == fin)){
				sonIguales = true;
			}
		}
		return sonIguales;
	}
	
	public static void elimina_secuencia(int [] arr, int inicio, int fin) {
		
		for(int i= fin; i>=inicio; i--) {
			arr[i]= arr[i+1];
		}
	}
	
	public static void elimina_secuencias_ocurrencias(int [] arr, int [] patron){
		int inicio = devuelve_inicio(arr, 0);
		int fin = 0;
		
		while(inicio != -1) {
			fin=devuelve_fin(arr,inicio);
			
			if(fin != -1){
			
				if(sonIguales(patron, arr,  inicio, fin) == true) {
					elimina_secuencia(arr, inicio,fin);
				}
			}
			inicio = devuelve_inicio(arr, fin+1);
		}
	}

}
