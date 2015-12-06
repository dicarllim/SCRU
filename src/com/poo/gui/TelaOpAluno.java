package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.Fachada;
import com.poo.negocios.beans.Aluno;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaOpAluno extends JFrame {

	private JPanel contentPane;
	private JTextField numeroCartao;
	private JTextField valor;
	
	public TelaOpAluno() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecarregarCarto = new JLabel("Informe cpf ou nome ou número do cartão: ");
		lblRecarregarCarto.setFont(new Font("Georgia", Font.BOLD, 20));
		lblRecarregarCarto.setBounds(10, 80, 500, 25);
		contentPane.add(lblRecarregarCarto);
		
		numeroCartao = new JTextField();
		numeroCartao.setBounds(20, 114, 200, 25);
		contentPane.add(numeroCartao);
		numeroCartao.setColumns(10);
		
		
		
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
		btnSair.setBounds(23, 200, 69, 27);
		contentPane.add(btnSair);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 40, 16);
		contentPane.add(toolBar);
	
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				TelaAdm telaAdm = new TelaAdm();
				telaAdm.setVisible(true);
			}
		});
		btnVoltar.setForeground(new Color(169, 169, 169));
		btnVoltar.setBackground(UIManager.getColor("Button.background"));
		btnVoltar.setBounds(230, 200, 69, 27);
		contentPane.add(btnVoltar);
		
		JToolBar tool = new JToolBar();
		toolBar.setBounds(0, 0, 40, 16);
		contentPane.add(toolBar);
		
		
		
		
		
		
		
		
		
		
		JButton btnCancelar = new JButton("Pesquisar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					TelaDadosAluno<Aluno> telaDadosAluno = new TelaDadosAluno<Aluno>
					(Fachada.getInstance().procurarPorParametro((numeroCartao.getText())));
					telaDadosAluno.setVisible(true);
					setVisible(false);
				}catch(NegocioException e1){
					TelaDadosAluno<String> telaDadosAluno = new TelaDadosAluno<String>(e1.getMessage());
					telaDadosAluno.setVisible(true);
					setVisible(false);
				}catch(NumberFormatException e2){
					TelaDadosAluno<String> telaDadosAluno = new TelaDadosAluno<String>("nenhum resultado encontrado");
					telaDadosAluno.setVisible(true);
					setVisible(false);

				}
				}
			
		})
		
		;
		btnCancelar.setBounds(250, 112, 95, 29);
		contentPane.add(btnCancelar);
	
	
	
	
	}
	
	
	
	
}