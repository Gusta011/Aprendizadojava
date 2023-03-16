package br.com.poo.estruturarepeticao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstruturaWhile1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtInicial;
	private JTextField txtFinal;
	
	String dados = "";
	int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstruturaWhile1 frame = new EstruturaWhile1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EstruturaWhile1() {
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("Janela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 217, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(174, 167, 218));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número Inicial");
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 132, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número Final");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 46, 93, 24);
		contentPane.add(lblNewLabel_1);
		
		txtInicial = new JTextField();
		txtInicial.setBounds(135, 11, 54, 20);
		contentPane.add(txtInicial);
		txtInicial.setColumns(10);
		
		txtFinal = new JTextField();
		txtFinal.setBounds(135, 46, 54, 20);
		contentPane.add(txtFinal);
		txtFinal.setColumns(10);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 179, 286);
		contentPane.add(scrollPane);
		
		JTextArea txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				i = Integer.parseInt(txtInicial.getText());
				
				while(i <= Integer.parseInt(txtFinal.getText())) {
					dados += i +"\n";
					i++;
				}
				txtResultado.setText(dados);
				txtInicial.setText("");
				txtFinal.setText("");
				dados = "";
			}
		});
		btnExecutar.setBackground(Color.WHITE);
		btnExecutar.setForeground(Color.BLACK);
		btnExecutar.setBounds(10, 81, 179, 23);
		contentPane.add(btnExecutar);
	}
}
