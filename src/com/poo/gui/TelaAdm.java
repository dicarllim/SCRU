package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;

public class TelaAdm extends JFrame {

	private static TelaAdm instance = null;
	private JPanel contentPane;

	public static TelaAdm getInstance(){
		if (instance == null){
			instance = new TelaAdm();
		}
		return instance;
	}
	/**
	 * Create the frame.
	 */
	public TelaAdm() {
		setTitle("Adm - Portal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		setSize(564,362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarAluno = new JButton("CADASTRAR ALUNO");
		btnCadastrarAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				TelaCadastroAluno.getInstance().setVisible(true);
			}
		});
		btnCadastrarAluno.setForeground(new Color(105, 105, 105));
		btnCadastrarAluno.setBounds(35, 104, 157, 63);
		contentPane.add(btnCadastrarAluno);
		

		JButton btnDadosAluno = new JButton("DADOS ALUNO");
		btnDadosAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				TelaConsultarAluno.getInstance().setVisible(true);
			}
		});
		btnDadosAluno.setForeground(new Color(105, 105, 105));
		btnDadosAluno.setBounds(380, 104, 146, 63);
		contentPane.add(btnDadosAluno);
		
		
		JButton btnCadastrarGestor = new JButton("CADASTRAR GESTOR");
		btnCadastrarGestor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				TelaCadastroGestor.getInstance().setVisible(true);
			}
		});
		btnCadastrarGestor.setForeground(new Color(105, 105, 105));
		btnCadastrarGestor.setBounds(202, 104, 168, 63);
		contentPane.add(btnCadastrarGestor);
	
		
		JButton btnDesativarAluno = new JButton("DESATIVAR ALUNO");
		btnDesativarAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				TelaDesativarAluno.getInstance().setVisible(true);
			}
		});
		btnDesativarAluno.setForeground(new Color(105, 105, 105));
		btnDesativarAluno.setBounds(35, 193, 157, 63);
		contentPane.add(btnDesativarAluno);
		
	
		JButton btnRecarregamento = new JButton("RECARREGAMENTO");
		btnRecarregamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				TelaRecarga.getInstance().setVisible(true); 
			}
		});
		btnRecarregamento.setForeground(new Color(105, 105, 105));
		btnRecarregamento.setBounds(202, 193, 168, 63);
		contentPane.add(btnRecarregamento);
		
		JLabel lblPortalDoAdministrador = new JLabel("PORTAL DO ADMINISTRADOR");
		lblPortalDoAdministrador.setForeground(new Color(0, 0, 0));
		lblPortalDoAdministrador.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPortalDoAdministrador.setBounds(141, 50, 289, 16);
		contentPane.add(lblPortalDoAdministrador);
		
		JLabel lblRestauranteUniversitrioUfrpe = new JLabel("RESTAURANTE UNIVERSITARIO UFRPE");
		lblRestauranteUniversitrioUfrpe.setBackground(new Color(220, 220, 220));
		lblRestauranteUniversitrioUfrpe.setForeground(new Color(255, 255, 255));
		lblRestauranteUniversitrioUfrpe.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblRestauranteUniversitrioUfrpe.setBounds(183, 32, 199, 16);
		contentPane.add(lblRestauranteUniversitrioUfrpe);
		
		JButton btnSair = new JButton("LOGOUT");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnSair.setForeground(new Color(128, 128, 128));
		btnSair.setBackground(UIManager.getColor("Button.background"));
		btnSair.setBounds(380, 193, 146, 63);
		contentPane.add(btnSair);
	}
}
