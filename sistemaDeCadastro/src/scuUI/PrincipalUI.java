package scuUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import controladores.DataCare;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class PrincipalUI {

	private JFrame frmSistemaDeCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI window = new PrincipalUI();
					window.frmSistemaDeCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DataCare dc = new DataCare();
		frmSistemaDeCadastro = new JFrame();
		frmSistemaDeCadastro.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					dc.salvaDados();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		frmSistemaDeCadastro.setTitle("Sistema de Cadastro");
		frmSistemaDeCadastro.setBounds(100, 100, 819, 443);
		frmSistemaDeCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new JPanel();
		frmSistemaDeCadastro.setContentPane(jp);
		jp.setLayout(new BorderLayout(0, 0));
		
		RelatoriosUI relatorios = new RelatoriosUI();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tabbedPane.getSelectedComponent() == relatorios) {
					RelatoriosFuncionarios.setTableData(dc);
					RelatoriosDocentes.setTableData(dc);
					RelatoriosDocentesEfetivos.setTableData(dc);
					RelatoriosDocentesSubstitutos.setTableData(dc);
					RelatoriosTecnicos.setTableData(dc);
					RelatoriosResumoDepartamentos.setTableData(dc);
				}
			}
		});
		jp.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Inicio", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{784, 784, 784, 784, 0};
		gbl_panel.rowHeights = new int[]{94, 109, 14, 23, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNomeUni = new JLabel("ULSP");
		lblNomeUni.setFont(new Font("Tahoma", Font.PLAIN, 90));
		lblNomeUni.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNomeUni = new GridBagConstraints();
		gbc_lblNomeUni.gridwidth = 4;
		gbc_lblNomeUni.fill = GridBagConstraints.BOTH;
		gbc_lblNomeUni.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeUni.gridx = 0;
		gbc_lblNomeUni.gridy = 1;
		panel.add(lblNomeUni, gbc_lblNomeUni);
		
		JLabel lblNewLabel = new JLabel("Seja bem vindo ao Sistema de Cadastro da ULSP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("Exibir relatorio geral");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioGeral rGUni = new RelatorioGeral();
				rGUni.setTableData();
				rGUni.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		panel.add(btnNewButton, gbc_btnNewButton);
		tabbedPane.addTab("Cadastro", new CadastrosUI());
		tabbedPane.addTab("Relatórios", relatorios);
		tabbedPane.addTab("Buscas", new Buscas());
	}
}
