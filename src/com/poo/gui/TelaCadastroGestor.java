package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.Fachada;
import com.poo.negocios.beans.Gestor;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroGestor extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
	private JPasswordField senha;

	/**
	 * Create the frame.
	 */
	public TelaCadastroGestor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarNovoGestor = new JLabel("CADASTRAR NOVO GESTOR");
		lblCadastrarNovoGestor.setFont(new Font("Georgia", Font.BOLD, 20));
		lblCadastrarNovoGestor.setBounds(111, 64, 298, 25);
		contentPane.add(lblCadastrarNovoGestor);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(110, 115, 61, 16);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(120, 142, 61, 32);
		contentPane.add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(110, 185, 61, 16);
		contentPane.add(lblSenha);
		
		nome = new JTextField();
		nome.setBounds(156, 109, 292, 28);
		contentPane.add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(156, 145, 134, 28);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaAdm telaAdm = new TelaAdm();
				telaAdm.setVisible(true);
			}
		});
		btnCancelar.setBounds(64, 234, 117, 29);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setBounds(191, 234, 117, 29);
		contentPane.add(btnLimpar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Gestor gestor = new Gestor(nome.getText(), cpf.getText(), String.copyValueOf(senha.getPassword()));
					Fachada.getInstance().cadastrar(gestor);
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!", "Cadastro Gestor", JOptionPane.INFORMATION_MESSAGE);
					limpar();
				} catch(NegocioException e2){
					JOptionPane.showMessageDialog(null, e2.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConfirmar.setBounds(318, 234, 117, 29);
		contentPane.add(btnConfirmar);
		
		senha = new JPasswordField();
		senha.setBounds(156, 183, 134, 25);
		contentPane.add(senha);
	}
	private void limpar(){
		nome.setText("");
		cpf.setText("");
		senha.setText("");
	}
}
