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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;

public class TelaAdm extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
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
				TelaCadastroAluno telaCadastroAluno = new TelaCadastroAluno();
				telaCadastroAluno.setVisible(true);
			}
		});
		btnCadastrarAluno.setForeground(new Color(105, 105, 105));
		btnCadastrarAluno.setBounds(65, 84, 186, 83);
		contentPane.add(btnCadastrarAluno);
		
		
		
		JButton btnDadosAluno = new JButton("Dados ALUNO");
		btnDadosAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				TelaDadosAluno telaDadosAluno = new TelaDadosAluno();
				telaDadosAluno.setVisible(true);
			}
		});
		btnDadosAluno.setForeground(new Color(105, 105, 105));
		btnDadosAluno.setBounds(65, 270, 382, 50);
		contentPane.add(btnDadosAluno);
		
		
		
		
		
		
		
		
		JButton btnCadastrarGestor = new JButton("CADASTRAR GESTOR");
		btnCadastrarGestor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				TelaCadastroGestor telaCadastroGestor = new TelaCadastroGestor();
				telaCadastroGestor.setVisible(true);
			}
		});
		btnCadastrarGestor.setForeground(new Color(105, 105, 105));
		btnCadastrarGestor.setBounds(261, 84, 186, 83);
		contentPane.add(btnCadastrarGestor);
		
		JButton btnDesativarAluno = new JButton("DESATIVAR ALUNO");
		btnDesativarAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				TelaDesativarAluno telaDesativarAluno = new TelaDesativarAluno();
				telaDesativarAluno.setVisible(true);
			}
		});
		btnDesativarAluno.setForeground(new Color(105, 105, 105));
		btnDesativarAluno.setBounds(65, 178, 186, 83);
		contentPane.add(btnDesativarAluno);
		
		JButton btnRecarregamento = new JButton("RECARREGAMENTO");
		btnRecarregamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				TelaRecarga telaRecarga = new TelaRecarga();
				telaRecarga.setVisible(true);
			}
		});
		btnRecarregamento.setForeground(new Color(105, 105, 105));
		btnRecarregamento.setBounds(261, 178, 186, 83);
		contentPane.add(btnRecarregamento);
		
		JLabel lblPortalDoAdministrador = new JLabel("PORTAL DO ADMINISTRADOR");
		lblPortalDoAdministrador.setForeground(new Color(0, 0, 0));
		lblPortalDoAdministrador.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPortalDoAdministrador.setBounds(109, 47, 289, 16);
		contentPane.add(lblPortalDoAdministrador);
		
		JLabel lblRestauranteUniversitrioUfrpe = new JLabel("RESTAURANTE UNIVERSITARIO UFRPE");
		lblRestauranteUniversitrioUfrpe.setBackground(new Color(220, 220, 220));
		lblRestauranteUniversitrioUfrpe.setForeground(new Color(255, 255, 255));
		lblRestauranteUniversitrioUfrpe.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblRestauranteUniversitrioUfrpe.setBounds(156, 31, 199, 16);
		contentPane.add(lblRestauranteUniversitrioUfrpe);
		
		JButton btnSair = new JButton("Logout");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
			}
		});
		btnSair.setForeground(new Color(169, 169, 169));
		btnSair.setBackground(UIManager.getColor("Button.background"));
		btnSair.setBounds(23, 272, 69, 27);
		contentPane.add(btnSair);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 87, 16);
		contentPane.add(toolBar);
	}
}
