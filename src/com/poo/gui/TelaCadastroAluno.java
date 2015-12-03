package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.negocios.beans.Aluno;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public TelaCadastroAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarNovoAluno = new JLabel("CADASTRAR NOVO ALUNO");
		lblCadastrarNovoAluno.setFont(new Font("Georgia", Font.BOLD, 20));
		lblCadastrarNovoAluno.setBounds(107, 48, 296, 16);
		contentPane.add(lblCadastrarNovoAluno);
		
		textField = new JTextField();
		textField.setBounds(85, 86, 359, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(0, 0, 0));
		lblNome.setBounds(36, 92, 61, 16);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 120, 168, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(46, 126, 61, 16);
		contentPane.add(lblCpf);
		
		JLabel lblAnoIngresso = new JLabel("Ano Ingresso:");
		lblAnoIngresso.setBounds(264, 126, 92, 16);
		contentPane.add(lblAnoIngresso);
		
		textField_2 = new JTextField();
		textField_2.setBounds(341, 120, 103, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(85, 154, 359, 28);
		contentPane.add(textField_3);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(36, 160, 61, 16);
		contentPane.add(lblCurso);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancelar.setBounds(10, 238, 85, 29);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(109, 238, 75, 29);
		contentPane.add(btnLimpar);
		
		JButton btnGerarCdigo = new JButton("Gerar Código");
		btnGerarCdigo.setBounds(194, 238, 109, 29);
		contentPane.add(btnGerarCdigo);
		
		JButton btnGerarCarto = new JButton("Gerar Cartão");
		btnGerarCarto.setBounds(313, 238, 104, 29);
		contentPane.add(btnGerarCarto);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float valor = Float.parseFloat(textField_2.getText());
				Aluno aluno = new Aluno(0L, textField.getText(), textField_1.getText(), textField_3.getText() , valor);

			}
		});
		btnSalvar.setBounds(427, 238, 75, 29);
		contentPane.add(btnSalvar);
	}
}

