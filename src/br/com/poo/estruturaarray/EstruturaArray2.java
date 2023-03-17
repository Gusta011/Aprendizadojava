package br.com.poo.estruturaarray;

public class EstruturaArray2 {

	public static void main(String[] args) {
		
		int[] numeros = {10,52,18,3,2,7,84,153,1,92,62,40,66,20};
		
		for(int i = 0 ; i < numeros.length ; i++) {
			if( i % 2 == 0) {
				System.out.println(numeros[i]);
			}
		}

	}

}
