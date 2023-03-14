package br.com.poo.estruturaiF;

import java.util.Scanner;

public class Estruturaif{
	public static void main(String args[]) {
		System.out.println("========== Valor Par ou Impar ==========");
		System.out.println("\nEntre com um valor numérico:");
		//declaração de variável númerica
		int numero;
		//Permite a entrada de dados via teclado pelo terminal
		Scanner entrada = new Scanner(System.in);
		numero = entrada.nextInt();
		
		//Vamos testar se o número digitado é par ou impar
		if(numero % 2 == 0) {
			System.out.println("O número: "+numero+" é Par");
		}
		else {
			System.out.println("O número: "+numero+" é Ímpar");
		}
	}
}