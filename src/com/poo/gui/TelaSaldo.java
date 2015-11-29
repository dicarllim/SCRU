package com.poo.gui;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;

public class TelaSaldo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSaldo frame = new TelaSaldo();
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
	public TelaSaldo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBoaRefeio = new JLabel("BOA REFEIÇÃO!");
		lblBoaRefeio.setForeground(new Color(105, 105, 105));
		lblBoaRefeio.setFont(new Font("Consolas", Font.BOLD, 35));
		lblBoaRefeio.setBounds(132, 68, 247, 66);
		contentPane.add(lblBoaRefeio);
		
		JLabel lblSaldo = new JLabel("SALDO DISPONÍVEL:");
		lblSaldo.setFont(new Font("Consolas", Font.BOLD, 25));
		lblSaldo.setForeground(new Color(144, 238, 144));
		lblSaldo.setBounds(39, 174, 291, 25);
		contentPane.add(lblSaldo);
		
		JTextPane infoSaldo = new JTextPane();
		infoSaldo.setForeground(new Color(144, 238, 144));
		infoSaldo.setFont(new Font("Consolas", Font.PLAIN, 25));
		infoSaldo.setEditable(false);
		infoSaldo.setBackground(new Color(255, 255, 255));
		infoSaldo.setBounds(282, 168, 143, 31);
		contentPane.add(infoSaldo);
		
		}
	}
