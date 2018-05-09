/*---------------------------------------------
 * Autor: Jonathan Moura
 * Data:01/05/2018
 *---------------------------------------------
 * Descri��o: Classe de tela do cadastro de 
 * 			  produtos.
 *---------------------------------------------
 * Hist�rico de modifica��o
 * Data    Autor    Descri��o
 *       |        |
 *-------------------------------------------*/

package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import negocio.Fachada;
import negocio.Mensagem;
import negocio.Produto;
import negocio.ValidarDados;

public class TelaCadProd extends JFrame {

	private JPanel contentPane;
	private Fachada fachada = new Fachada();
	public static TelaCadProd instance;
	private JTextField textFieldNome;
	private JTextField textFieldDescricao;
	private JTextField textFieldQuantidade;
	private JTextField textFieldValor;

	public static TelaCadProd getInstance() {
		if (instance == null)
			instance = new TelaCadProd();
		return instance;
	}
	
	public void limparCampos(){
		textFieldNome.setText("");
		textFieldDescricao.setText("");
		textFieldQuantidade.setText("");
		textFieldValor.setText("");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadProd frame = new TelaCadProd();
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
	public TelaCadProd() {
		setTitle("An\u00E1lise de Vendas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 135, 594, 437);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(108, 73, 86, 21);
		panel.add(lblNome);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(108, 117, 86, 21);
		panel.add(lblDescricao);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(108, 165, 86, 21);
		panel.add(lblQuantidade);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(108, 211, 86, 21);
		panel.add(lblValor);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ValidarDados.validarCampoVazio(textFieldNome.getText(), textFieldDescricao.getText(),
						textFieldQuantidade.getText(), textFieldValor.getText())) {
					
					Produto produto = new Produto(textFieldNome.getText(), textFieldDescricao.getText(),
							Integer.parseInt(textFieldQuantidade.getText()),
							Double.parseDouble(textFieldValor.getText()), "", "");
					
					fachada.cadastrar(produto);
					JOptionPane.showMessageDialog(null, Mensagem.CADPRODSUC);
					limparCampos();
				}
			}
		});
		
		btnEnviar.setBounds(326, 254, 89, 23);
		panel.add(btnEnviar);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(204, 73, 140, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		textFieldDescricao.setBounds(204, 117, 211, 20);
		panel.add(textFieldDescricao);

		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(204, 165, 86, 20);
		panel.add(textFieldQuantidade);

		textFieldValor = new JTextField();
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(204, 211, 86, 20);
		panel.add(textFieldValor);
	}
}