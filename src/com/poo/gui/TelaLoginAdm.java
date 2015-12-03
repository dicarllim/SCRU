package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class TelaLoginAdm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
		
		textField = new JTextField();
		textField.setBounds(207, 135, 153, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(207, 172, 153, 35);
		contentPane.add(passwordField);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setForeground(new Color(107, 142, 35));
		btnEnter.setBounds(144, 234, 117, 29);
		contentPane.add(btnEnter);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(165, 42, 42));
		btnCancelar.setBounds(263, 234, 117, 29);
		contentPane.add(btnCancelar);
		
		JLabel lblRestauranteUniversitrioUfrpe = new JLabel("RESTAURANTE UNIVERSITÁRIO UFRPE");
		lblRestauranteUniversitrioUfrpe.setForeground(new Color(211, 211, 211));
		lblRestauranteUniversitrioUfrpe.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblRestauranteUniversitrioUfrpe.setBounds(174, 72, 206, 16);
		contentPane.add(lblRestauranteUniversitrioUfrpe);
	}
}
