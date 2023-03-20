package br.com.poo.images;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Padaria extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTextField txtCodigoBarras;
	private JTextField txtDescricao;
	private JTextField txtValorUnitario;
	private JTextField txtQuantidade;
	private JTextField txtTotalItem;
	private JTextField txtSubTotal;
	private JTextArea txtNota;
	private String cabecalho;
	private int item;
	private double valorPagar;
	private JLabel lblValorPagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Padaria frame = new Padaria();
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
	public Padaria() {
		
		valorPagar = 0.0;
		
		item = 1;
		
		cabecalho = "\t\t\t                         GRAN PÃO\n"+
					"\n\t\t\t Av. Matuí de Franja, 777 - Vista Alegre"+
					"\n\t\t\t  CEP: 10280-160 - Belo Vertical - MG"+
					"\n CNPJ: 10.672.072/0001-14"+
					"\n IE: 152.922671.0009"+
					"\n IM: 1.025.783/001-1"+
					"\n----------------------------------------------------------------------------------"
					+ "--------------------------------------------------------------------------------------------------------------\n"+
					"\n\t\t\t                     CUPOM FISCAL"+
					"\n Item\tCódigo\t\tDescrição\t\tQTD\tVL.UNIT.\tVL.TOTAL"+
					
					"\n----------------------------------------------------------------------------------"
					+ "--------------------------------------------------------------------------------------------------------------\n";
					
		String[][] produtos = {
				
				{"2023","Pão Francês","13.00","17032023"},
				{"2024","Pão de Leite","15.00","17032024"},
				{"2025","Torta de Frango","50.00","17032025"},
				{"2026","Leite Integral A","5.00","17032026"},
				{"2027","Manteiga","6.00","17032027"},
				{"2028","Bolo","20.00","17032028"},
				{"2029","Bauru","12.00","17032029"},
				{"2030","Suco Laranja","7.00","17032030"},
				
		};
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlEsquerdo = new JPanel();
		pnlEsquerdo.setBackground(SystemColor.controlShadow);
		pnlEsquerdo.setBounds(0, 0, 800, 700);
		contentPane.add(pnlEsquerdo);
		pnlEsquerdo.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 0, 800, 300);
		
		/*
		 * Para ajustar a imagem ao tamanho da Label, foi necessário aplicar o comando
		 * new ImageIcon para definir a escala do elemento getImage.
		 * O tamanho da imagem foi ajustado para largura da label(lbl.getWidth) e altura da
		 * label (lbl.getHeigth) e para finalizar, foi alterado a forma de fechamento da
		 * imagem quando a tela fecha, foi setado o valor para suavização(image.SCALE_SMOOTH).
		 */
		
		lblLogo.setIcon(new ImageIcon(new ImageIcon(Padaria.class.getResource("/br/com/poo/images/Padaria2.png")).getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH)));
		
		pnlEsquerdo.add(lblLogo);
		
		JLabel lblCodigoProduto = new JLabel("Código do Produto:");
		lblCodigoProduto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCodigoProduto.setForeground(Color.WHITE);
		lblCodigoProduto.setBounds(20, 288, 226, 54);
		pnlEsquerdo.add(lblCodigoProduto);
		
		JLabel lblCodigoBarras = new JLabel("Código de Barras:");
		lblCodigoBarras.setForeground(Color.WHITE);
		lblCodigoBarras.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCodigoBarras.setBounds(498, 288, 226, 54);
		pnlEsquerdo.add(lblCodigoBarras);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				for(int linha = 0 ; linha < produtos.length ; linha++) {
					
					for(int coluna = 0 ; coluna < produtos[0].length ; coluna++) {
						if(txtCodigoProduto.getText().equals(produtos[linha][0])) {
							txtCodigoBarras.setText(produtos[linha][3]);
							txtDescricao.setText(produtos[linha][1]);
							txtValorUnitario.setText(produtos[linha][2]);
							break;
						}
					}
				}
				
			}
		});
		txtCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCodigoProduto.setForeground(Color.WHITE);
		txtCodigoProduto.setBackground(SystemColor.controlShadow);
		txtCodigoProduto.setBounds(20, 339, 195, 37);
		pnlEsquerdo.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);
		txtCodigoProduto.setBorder(null);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setForeground(Color.WHITE);
		txtCodigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCodigoBarras.setBackground(SystemColor.controlShadow);
		txtCodigoBarras.setBounds(498, 339, 195, 37);
		pnlEsquerdo.add(txtCodigoBarras);
		txtCodigoBarras.setColumns(10);
		txtCodigoBarras.setBorder(null);
		
		JSeparator separador = new JSeparator();
		separador.setForeground(Color.WHITE);
		separador.setBounds(10, 387, 780, 7);
		pnlEsquerdo.add(separador);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDescricao.setBounds(20, 399, 226, 25);
		pnlEsquerdo.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescricao.setForeground(Color.WHITE);
		txtDescricao.setColumns(10);
		txtDescricao.setBackground(SystemColor.controlShadow);
		txtDescricao.setBounds(20, 435, 759, 37);
		pnlEsquerdo.add(txtDescricao);
		txtDescricao.setBorder(null);
		
		JSeparator separador_1 = new JSeparator();
		separador_1.setForeground(Color.WHITE);
		separador_1.setBounds(10, 483, 780, 7);
		pnlEsquerdo.add(separador_1);
		
		JLabel lblValorUnitario = new JLabel("Valor Unitário:");
		lblValorUnitario.setForeground(Color.WHITE);
		lblValorUnitario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblValorUnitario.setBounds(10, 495, 226, 54);
		pnlEsquerdo.add(lblValorUnitario);
		
		txtValorUnitario = new JTextField();
		txtValorUnitario.setHorizontalAlignment(SwingConstants.RIGHT);
		txtValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtValorUnitario.setText("0,00 x");
		txtValorUnitario.setForeground(Color.WHITE);
		txtValorUnitario.setColumns(10);
		txtValorUnitario.setBackground(SystemColor.controlShadow);
		txtValorUnitario.setBounds(10, 546, 195, 37);
		pnlEsquerdo.add(txtValorUnitario);
		txtValorUnitario.setBorder(null);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuantidade.setBounds(266, 495, 226, 54);
		pnlEsquerdo.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				txtTotalItem.setText(""+
						Double.parseDouble(txtQuantidade.getText())*
						Double.parseDouble(txtValorUnitario.getText())
						);
				
				txtSubTotal.setText("R$"+
						Double.parseDouble(txtQuantidade.getText())*
						Double.parseDouble(txtValorUnitario.getText())
						);
				
			}
		});
		txtQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		txtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuantidade.setForeground(Color.WHITE);
		txtQuantidade.setColumns(10);
		txtQuantidade.setBackground(SystemColor.controlShadow);
		txtQuantidade.setBounds(266, 546, 195, 37);
		pnlEsquerdo.add(txtQuantidade);
		txtQuantidade.setBorder(null);
		
		JLabel lblTotalItem = new JLabel("Total Item:");
		lblTotalItem.setForeground(Color.WHITE);
		lblTotalItem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotalItem.setBounds(546, 495, 226, 54);
		pnlEsquerdo.add(lblTotalItem);
		
		txtTotalItem = new JTextField();
		txtTotalItem.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalItem.setText("0,00");
		txtTotalItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTotalItem.setForeground(Color.WHITE);
		txtTotalItem.setColumns(10);
		txtTotalItem.setBackground(SystemColor.controlShadow);
		txtTotalItem.setBounds(546, 546, 195, 37);
		pnlEsquerdo.add(txtTotalItem);
		txtTotalItem.setBorder(null);
		
		JSeparator separador_1_1 = new JSeparator();
		separador_1_1.setForeground(Color.WHITE);
		separador_1_1.setBounds(10, 594, 780, 7);
		pnlEsquerdo.add(separador_1_1);
		
		JLabel lblSubTotal = new JLabel("Subtotal:");
		lblSubTotal.setForeground(Color.WHITE);
		lblSubTotal.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSubTotal.setBounds(10, 601, 226, 40);
		pnlEsquerdo.add(lblSubTotal);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setText("0,00");
		txtSubTotal.setForeground(Color.WHITE);
		txtSubTotal.setFont(new Font("Tahoma", Font.BOLD, 35));
		txtSubTotal.setColumns(10);
		txtSubTotal.setBackground(SystemColor.controlShadow);
		txtSubTotal.setBounds(246, 612, 195, 77);
		pnlEsquerdo.add(txtSubTotal);
		txtSubTotal.setBorder(null);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cabecalho+="\n"+item+"\t"+txtCodigoProduto.getText()+
						"\t\t"+txtDescricao.getText()+
						"\t\t"+txtQuantidade.getText()+
						"\t"+txtValorUnitario.getText()+
						"\t"+txtTotalItem.getText();
				
				txtNota.setText(cabecalho);
				item++;
				
				valorPagar += Double.parseDouble(txtTotalItem.getText());
				lblValorPagar.setText("R$ "+valorPagar);
				
			}
		});
		btnIncluir.setIcon(new ImageIcon(Padaria.class.getResource("/br/com/poo/images/Botao1.png")));
		btnIncluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIncluir.setBounds(509, 612, 248, 77);
		pnlEsquerdo.add(btnIncluir);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.WHITE);
		separator.setBounds(354, 311, 2, 65);
		pnlEsquerdo.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(246, 518, 2, 65);
		pnlEsquerdo.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(511, 518, 2, 65);
		pnlEsquerdo.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.WHITE);
		separator_3.setBounds(430, 612, 2, 77);
		pnlEsquerdo.add(separator_3);
		
		JPanel pnlDireito = new JPanel();
		pnlDireito.setBackground(new Color(192, 192, 192));
		pnlDireito.setBounds(810, 0, 774, 700);
		contentPane.add(pnlDireito);
		pnlDireito.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 774, 700);
		pnlDireito.add(scrollPane);
		
		txtNota = new JTextArea();
		scrollPane.setViewportView(txtNota);
		txtNota.setText(cabecalho);
		
		JPanel pnlBase = new JPanel();
		pnlBase.setBackground(SystemColor.activeCaption);
		pnlBase.setBounds(0, 710, 1584, 150);
		contentPane.add(pnlBase);
		pnlBase.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor a Pagar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(959, 25, 254, 93);
		pnlBase.add(lblNewLabel);
		
		lblValorPagar = new JLabel("New label");
		lblValorPagar.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblValorPagar.setBounds(1223, 25, 351, 93);
		pnlBase.add(lblValorPagar);
		lblValorPagar.setText("R$ "+valorPagar);
	}
}
