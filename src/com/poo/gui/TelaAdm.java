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

public class TelaAdm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdm frame = new TelaAdm();
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
	public TelaAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarAluno = new JButton("CADASTRAR ALUNO");
		btnCadastrarAluno.setForeground(new Color(105, 105, 105));
		btnCadastrarAluno.setBounds(63, 100, 186, 83);
		contentPane.add(btnCadastrarAluno);
		
		JButton btnCadastrarGestor = new JButton("CADASTRAR GESTOR");
		btnCadastrarGestor.setForeground(new Color(105, 105, 105));
		btnCadastrarGestor.setBounds(261, 100, 186, 83);
		contentPane.add(btnCadastrarGestor);
		
		JButton btnDesativarAluno = new JButton("DESATIVAR ALUNO");
		btnDesativarAluno.setForeground(new Color(105, 105, 105));
		btnDesativarAluno.setBounds(63, 195, 186, 83);
		contentPane.add(btnDesativarAluno);
		
		JButton btnRecarregamento = new JButton("RECARREGAMENTO");
		btnRecarregamento.setForeground(new Color(105, 105, 105));
		btnRecarregamento.setBounds(261, 195, 186, 83);
		contentPane.add(btnRecarregamento);
		
		JLabel lblPortalDoAdministrador = new JLabel("PORTAL DO ADMINISTRADOR");
		lblPortalDoAdministrador.setForeground(new Color(0, 0, 0));
		lblPortalDoAdministrador.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPortalDoAdministrador.setBounds(110, 60, 289, 16);
		contentPane.add(lblPortalDoAdministrador);
		
		JLabel lblRestauranteUniversitrioUfrpe = new JLabel("RESTAURANTE UNIVERSIT�RIO UFRPE");
		lblRestauranteUniversitrioUfrpe.setBackground(new Color(220, 220, 220));
		lblRestauranteUniversitrioUfrpe.setForeground(new Color(255, 255, 255));
		lblRestauranteUniversitrioUfrpe.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblRestauranteUniversitrioUfrpe.setBounds(155, 41, 199, 16);
		contentPane.add(lblRestauranteUniversitrioUfrpe);
	}
}