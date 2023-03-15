package br.com.poo.estruturaempresa;

import javax.swing.JOptionPane;

public class Estruturaempresa extends JOptionPane {

	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Bem vindo a Gestão dos Sem Floresta!","Sistema",JOptionPane.INFORMATION_MESSAGE);
		String gestao = JOptionPane.showInputDialog("Digite um Cargo");
		String rs = "";
		switch(gestao) {
		case "diretor":
			rs = "Salário de: 20,000";
		break;
		case "gerente":
			rs = "Salário de 15,000";
			break;
		case "secretária":
			rs = "Salário de: 8,000";
		break;
		case "analista":
			rs = "Salário de 7,000";
			break;
		case "assistente":
			rs = "Salário de: 4,000";
		break;
		case "estagiário":
			rs = "Salário de 1,500";
			break;
		case "outros":
			rs = "Cargo Inexistente";
		}
		JOptionPane.showMessageDialog(null, rs,"Salário",JOptionPane.INFORMATION_MESSAGE);
	}

}
