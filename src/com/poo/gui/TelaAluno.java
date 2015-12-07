package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.Fachada;
import com.poo.negocios.beans.Aluno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAluno extends JFrame {
	private static TelaAluno instance = null;
	private JPanel contentPane;
	private Aluno aluno;
	
	public static TelaAluno getInstance(Aluno aluno){
		if (instance == null){
			instance = new TelaAluno(aluno);
		}
		return instance;
	}
	/**
	 * Create the frame.
	 */
	public TelaAluno(final Aluno aluno) {
		setTitle("Aluno - Sele\u00E7\u00E3o da Refei\u00E7\u00E3o");
		this.aluno = aluno;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel verificarsaldo = new JLabel("SEU SALDO É DE:");
		verificarsaldo.setFont(new Font("Consolas", Font.PLAIN, 12));
		verificarsaldo.setLayout(null);
		verificarsaldo.setVisible(true);
		verificarsaldo.setBounds(97,64, 130,70);
		getContentPane().add(verificarsaldo);
		verificarsaldo.setText("Saldo Atual:  0.0");
		
		JLabel lblSelecioneAOpo = new JLabel("SELECIONE A OPCAO DESEJADA:");
		lblSelecioneAOpo.setBackground(new Color(165, 42, 42));
		lblSelecioneAOpo.setForeground(new Color(165, 42, 42));
		lblSelecioneAOpo.setFont(new Font("Consolas", Font.BOLD, 18));
		lblSelecioneAOpo.setBounds(125, 40, 270, 36);
		contentPane.add(lblSelecioneAOpo);
		
		JButton btnJantarr = new JButton("JANTAR (R$1,50)");
		btnJantarr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Fachada.getInstance().debitar(aluno.getNumeroDoCartao(), 1.5);
					Fachada.getInstance().atualizarAluno(aluno);
					TelaSaldo.getInstance(aluno.getSaldo()).setVisible(true);
					setVisible(false);
				}catch(NegocioException e2){
					JOptionPane.showMessageDialog(null, e2.getMessage(), "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnJantarr.setForeground(new Color(112, 128, 144));
		btnJantarr.setBounds(96, 185, 335, 58);
		contentPane.add(btnJantarr);
		
		JButton btnAlmoor = new JButton("ALMOCO (R$2,00)");
		btnAlmoor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Fachada.getInstance().debitar(aluno.getNumeroDoCartao(), 2.0);
					Fachada.getInstance().atualizarAluno(aluno);
					TelaSaldo.getInstance(aluno.getSaldo()).setVisible(true);
					setVisible(false);
				}catch(NegocioException e2){
					JOptionPane.showMessageDialog(null, e2.getMessage(), "", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAlmoor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				TelaSaldo.getInstance(aluno.getSaldo()).setVisible(true);
			}
		});
		btnAlmoor.setForeground(new Color(112, 128, 144));
		btnAlmoor.setBounds(96, 121, 335, 58);
		contentPane.add(btnAlmoor);
	}
	
}
