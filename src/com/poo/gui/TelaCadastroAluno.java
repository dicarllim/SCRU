package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class TelaCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAluno frame = new TelaCadastroAluno();
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
	public TelaCadastroAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarNovoAluno = new JLabel("CADASTRAR NOVO ALUNO");
		lblCadastrarNovoAluno.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblCadastrarNovoAluno.setBounds(120, 47, 285, 16);
		contentPane.add(lblCadastrarNovoAluno);
		
		textField = new JTextField();
		textField.setBounds(85, 86, 372, 28);
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
		textField_2.setBounds(354, 120, 103, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(85, 154, 372, 28);
		contentPane.add(textField_3);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(36, 160, 61, 16);
		contentPane.add(lblCurso);
		
		JLabel lblResidente = new JLabel("Residente: ");
		lblResidente.setBounds(36, 194, 71, 16);
		contentPane.add(lblResidente);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		rdbtnSim.setBounds(105, 190, 148, 23);
		contentPane.add(rdbtnSim);
		
		JRadioButton rdbtnNo = new JRadioButton("Não");
		rdbtnNo.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		rdbtnNo.setBounds(158, 190, 141, 23);
		contentPane.add(rdbtnNo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(23, 238, 117, 29);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(136, 238, 117, 29);
		contentPane.add(btnLimpar);
		
		JButton btnGerarCdigo = new JButton("Gerar Código");
		btnGerarCdigo.setBounds(251, 238, 117, 29);
		contentPane.add(btnGerarCdigo);
		
		JButton btnGerarCarto = new JButton("Gerar Cartão");
		btnGerarCarto.setBounds(362, 238, 117, 29);
		contentPane.add(btnGerarCarto);
	}
}

