package br.com.poo.switchif;

import javax.swing.JOptionPane;

public class Estruturaswitch extends JOptionPane {
	
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Olá Bom Dia!","Sistema",JOptionPane.INFORMATION_MESSAGE);
		String estacao = JOptionPane.showInputDialog("Digite uma estação do ano");
		String rs;
		switch(estacao) {
		case "Verão":
			rs = "Dezembro - Janeiro - Fevereiro";
		break;
		case "Outono":
			rs = "Março - Abril - Maio";
			break;
		case "Inverno":
			rs = "Junho - Julho - Agosto";
			break;
		case "Primavera":
			rs = "Setembro - Outubro - Novembro";
			break;
		default:
			rs = "Esta estação não existe";
		break;
			
		}
		JOptionPane.showMessageDialog(null, rs,"Resposta",JOptionPane.INFORMATION_MESSAGE);
	}
}