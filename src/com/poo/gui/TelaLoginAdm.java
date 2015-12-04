package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.Fachada;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLoginAdm extends JFrame {

	private JPanel contentPane;
	private JTextField loginTexto;
	private JPasswordField senhaTexto;

	/**
	 * Create the frame.
	 */
	public TelaLoginAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAcessoAdministrador = new JLabel("ACESSO ADMINISTRADOR");
		lblAcessoAdministrador.setForeground(new Color(119, 136, 153));
		lblAcessoAdministrador.setFont(new Font("Consolas", Font.BOLD, 28));
		lblAcessoAdministrador.setBounds(113, 93, 300, 30);
		contentPane.add(lblAcessoAdministrador);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(new Color(128, 128, 128));
		lblLogin.setBounds(154, 144, 61, 16);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(128, 128, 128));
		lblSenha.setBounds(154, 181, 41, 16);
		contentPane.add(lblSenha);
		
		loginTexto = new JTextField();
		loginTexto.setBounds(207, 135, 153, 35);
		contentPane.add(loginTexto);
		loginTexto.setColumns(10);
		
		senhaTexto = new JPasswordField();
		senhaTexto.setBounds(207, 172, 153, 35);
		contentPane.add(senhaTexto);
		
		JButton btnEnter = new JButton("Entrar");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String usuario = loginTexto.getText();
					String senha = loginTexto.getText();
				
					try {
						if(Fachada.getInstance().loginGestor(usuario, senha) ){
							setVisible(false);
							TelaAdm telaAdm = new TelaAdm();
							telaAdm.setVisible(true);
						}
					} catch (NegocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
			}
		});
		btnEnter.setForeground(new Color(107, 142, 35));
		btnEnter.setBounds(144, 234, 117, 29);
		contentPane.add(btnEnter);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
			}
		});
		btnCancelar.setForeground(new Color(165, 42, 42));
		btnCancelar.setBounds(263, 234, 117, 29);
		contentPane.add(btnCancelar);
		
		JLabel lblRestauranteUniversitrioUfrpe = new JLabel("RESTAURANTE UNIVERSIT�RIO UFRPE");
		lblRestauranteUniversitrioUfrpe.setForeground(new Color(211, 211, 211));
		lblRestauranteUniversitrioUfrpe.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblRestauranteUniversitrioUfrpe.setBounds(174, 72, 206, 16);
		contentPane.add(lblRestauranteUniversitrioUfrpe);
	}
}
