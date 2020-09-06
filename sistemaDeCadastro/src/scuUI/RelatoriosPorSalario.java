package scuUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controladores.DataCare;
import servidor.Funcionario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class RelatoriosPorSalario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5228745655352743455L;
	private JTextField textGastoMin;
	private JTextField textGastoMax;
	private JTable tabelaDep;
	@SuppressWarnings("serial")
	static DefaultTableModel modelo = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Codigo", "Nivel", "Salario",
			}
		){
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	DataCare dc = new DataCare();

	/**
	 * Create the panel.
	 */
	public RelatoriosPorSalario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{45, 116, 23, 134, 189, 0};
		gridBagLayout.rowHeights = new int[]{14, 23, 237, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDescrição = new JLabel("Insira uma faixa de salario, se desejar");
		GridBagConstraints gbc_lblDescrição = new GridBagConstraints();
		gbc_lblDescrição.anchor = GridBagConstraints.NORTH;
		gbc_lblDescrição.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrição.gridwidth = 5;
		gbc_lblDescrição.gridx = 0;
		gbc_lblDescrição.gridy = 0;
		add(lblDescrição, gbc_lblDescrição);
		
		JLabel lblNewLabel_2 = new JLabel("De");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textGastoMin = new JTextField();
		textGastoMin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					textGastoMin.setEditable(true);
					
				}else {JOptionPane.showMessageDialog(null, "Insira somente numeros");textGastoMin.setText("");}
			}
		});
		GridBagConstraints gbc_textGastoMin = new GridBagConstraints();
		gbc_textGastoMin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textGastoMin.anchor = GridBagConstraints.SOUTH;
		gbc_textGastoMin.insets = new Insets(0, 0, 5, 5);
		gbc_textGastoMin.gridx = 1;
		gbc_textGastoMin.gridy = 1;
		add(textGastoMin, gbc_textGastoMin);
		textGastoMin.setColumns(10);
		
		JButton btnFiltra = new JButton("Filtrar");
		btnFiltra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double gastoMin = Double.parseDouble(textGastoMin.getText());
					double gastoMax = Double.parseDouble(textGastoMax.getText());
					if(!(tratamento(gastoMin, gastoMax)))JOptionPane.showMessageDialog(null, 
							"Verifique se inseriu os valores corretamente."
							+ "\n" +"Lembre-se de que o primeiro campo deve ser MENOR que o segundo."
							+ "\n" + "E que para que seja uma FAIXA os dois valores não podem ser iguais.");
					else filtraData(dc, gastoMin, gastoMax);
				}catch(NumberFormatException ev){
					JOptionPane.showMessageDialog(null, "Insira numeros nos dois campos");
				};
				
				
			
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("at\u00E9");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textGastoMax = new JTextField();
		textGastoMax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					textGastoMin.setEditable(true);
					
				}else {JOptionPane.showMessageDialog(null, "Insira somente numeros");textGastoMin.setText("");}
			}
		});
		textGastoMax.setColumns(10);
		GridBagConstraints gbc_textGastoMax = new GridBagConstraints();
		gbc_textGastoMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_textGastoMax.anchor = GridBagConstraints.SOUTH;
		gbc_textGastoMax.insets = new Insets(0, 0, 5, 5);
		gbc_textGastoMax.gridx = 3;
		gbc_textGastoMax.gridy = 1;
		add(textGastoMax, gbc_textGastoMax);
		GridBagConstraints gbc_btnFiltra = new GridBagConstraints();
		gbc_btnFiltra.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnFiltra.insets = new Insets(0, 0, 5, 0);
		gbc_btnFiltra.gridx = 4;
		gbc_btnFiltra.gridy = 1;
		add(btnFiltra, gbc_btnFiltra);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridwidth = 5;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tabelaDep = new JTable();
		scrollPane.setViewportView(tabelaDep);
		tabelaDep.setModel(modelo);
		
		tabelaDep.setModel(modelo);
		
		

	}
	
	public void filtraData(DataCare dc, double salarioMin, double salarioMax) {
		modelo.setRowCount(0);
		ArrayList<Funcionario> holder = dc.getFuncionarioByFaixaSalarial(salarioMin, salarioMax);
		for(int i = 0; i < holder.size(); i++) {
				modelo.addRow(new Object[] {
						holder.get(i).nome,
						holder.get(i).codigo,
						holder.get(i).nivel,
						holder.get(i).salario
				});
		}
	}

	
	public boolean tratamento(double min, double max) {
		if(min > max) 
			return false;
		if(min == max)
			return false;
		return true;
	}
	
}
