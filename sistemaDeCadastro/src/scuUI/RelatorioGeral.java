package scuUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controladores.DataCare;
import servidor.Funcionario;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class RelatorioGeral extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5721146464421159820L;
	private JPanel contentPane;
	private JTable tableMaC;
	private JTable tableFis;
	private JTable tableGeo;
	private JTable tableQBio;
	
	
	DefaultTableModel dtm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome", "Codigo", "Nivel", "Salario"
			}
			) {
		boolean[] columnEditables = new boolean[] {
		false, false, false, false
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};
	DefaultTableModel dtm_1 = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome", "Codigo", "Nivel", "Salario"
			}
			) {
		boolean[] columnEditables = new boolean[] {
				false, false, false, false
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};
	DefaultTableModel dtm_2 = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome", "Codigo", "Nivel", "Salario"
			}
			) {
		boolean[] columnEditables = new boolean[] {
				false, false, false, false
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};
	DefaultTableModel dtm_3 = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome", "Codigo", "Nivel", "Salario"
			}
			) {
		boolean[] columnEditables = new boolean[] {
				false, false, false, false
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};

	DataCare dc = new DataCare();
	private JTextField textGastoTotal = new JTextField();
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioGeral frame = new RelatorioGeral();
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
	public RelatorioGeral() {
		setTitle("Relatorio Geral da Universidade");
		setResizable(false);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 962, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ULSP");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 90));
		
		JLabel lblNewLabel_1 = new JLabel("Relatorio Geral");
		
		JPanel panel = new JPanel();
		
		JLabel lblGastoTotal = new JLabel("Gasto Total");
		lblGastoTotal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		
		textGastoTotal.setEditable(false);
		textGastoTotal.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(375)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGap(357))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(433, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(442))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGastoTotal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textGastoTotal, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(560, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textGastoTotal)
						.addComponent(lblGastoTotal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedOpcoes = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedOpcoes, BorderLayout.CENTER);
		
		JScrollPane scrollPaneDep = new JScrollPane();
		tabbedOpcoes.addTab("Matematica e Computação", null, scrollPaneDep, null);
		
		tableMaC = new JTable();
		tableMaC.setModel(dtm);
		scrollPaneDep.setViewportView(tableMaC);
		
		JScrollPane scrollPaneDep_1 = new JScrollPane();
		tabbedOpcoes.addTab("Geografia", null, scrollPaneDep_1, null);
		
		tableFis = new JTable();
		tableFis.setModel(dtm_1);
		scrollPaneDep_1.setViewportView(tableFis);
		
		JScrollPane scrollPaneDep_2 = new JScrollPane();
		tabbedOpcoes.addTab("Fisica", null, scrollPaneDep_2, null);
		
		tableGeo = new JTable();
		tableGeo.setModel(dtm_2);
		scrollPaneDep_2.setViewportView(tableGeo);
		
		JScrollPane scrollPaneDep_3 = new JScrollPane();
		tabbedOpcoes.addTab("Quimica e Bioquimica", null, scrollPaneDep_3, null);
		
		tableQBio = new JTable();
		tableQBio.setModel(dtm_3);
		scrollPaneDep_3.setViewportView(tableQBio);
		contentPane.setLayout(gl_contentPane);
	}
	
	@SuppressWarnings("unchecked")
	public void setTableData() {

		ArrayList<Funcionario> holder = dc.getDepartamentosByIndex(0).concatTodosFuncionarios();
		setDataTableModel(dtm, holder);
		
		holder = dc.getDepartamentosByIndex(1).concatTodosFuncionarios();
		setDataTableModel(dtm_1, holder);
		
		holder = dc.getDepartamentosByIndex(2).concatTodosFuncionarios();
		setDataTableModel(dtm_2, holder);
		
		holder = dc.getDepartamentosByIndex(3).concatTodosFuncionarios();
		setDataTableModel(dtm_3, holder);
		
		textGastoTotal.setText(String.valueOf(setGasto()));
		
	}

	private void setDataTableModel(DefaultTableModel dtm, ArrayList<Funcionario> holder) {
		for(int i = 0; i < holder.size(); i++) {
			dtm.addRow(new Object[] {
					holder.get(i).nome,
					holder.get(i).codigo,
					holder.get(i).nivel,
					holder.get(i).salario
			});
		}
	}
	
	private double setGasto() {
		return dc.getGastoTotal();
	}
	
	
}

