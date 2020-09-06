package scuUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import componente.Departamento;
import controladores.DataCare;

import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

public class TabelaFuncionariosDepartamento extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6332932156176733936L;
	private JTable tableTec;
	private JTable tableDocEfe;
	private JTable tableDocSub;
	@SuppressWarnings("serial")
	static DefaultTableModel tableModelTec = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Codigo", "Nivel", "Fun\u00E7\u00E3o", "Salario"
			}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	@SuppressWarnings("serial")
	static DefaultTableModel tableModelDocEfe = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome", "Codigo", "Nivel", "Titula\u00E7\u00E3o", "Area", "Salario"
			}
			) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
	};
	@SuppressWarnings("serial")
	static DefaultTableModel tableModelDocSub = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Codigo", "Nivel", "Titula\u00E7\u00E3o", "Carga Horaria", "Salario"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	DataCare dc = new DataCare();
	
	
	
	/**
	 * Create the panel.
	 */
	public TabelaFuncionariosDepartamento() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedOpcoes = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedOpcoes, BorderLayout.CENTER);
		
		JScrollPane scrollDocEfe = new JScrollPane();
		tabbedOpcoes.addTab("Docentes Efetivos", null, scrollDocEfe, null);
		
		tableDocEfe = new JTable();
		tableDocEfe.setModel(tableModelDocEfe);

		scrollDocEfe.setViewportView(tableDocEfe);
		
		JScrollPane scrollDocSub = new JScrollPane();
		tabbedOpcoes.addTab("Docentes Substitutos", null, scrollDocSub, null);
		
		tableDocSub = new JTable();
		tableDocSub.setModel(tableModelDocSub);
		scrollDocSub.setViewportView(tableDocSub);
		
		JScrollPane scrollTec = new JScrollPane();
		tabbedOpcoes.addTab("Tecnicos", null, scrollTec, null);
		
		tableTec = new JTable();
		tableTec.setModel(tableModelTec);
		scrollTec.setViewportView(tableTec);

	}

	public static void setTableDataDocEfe(Departamento d) {
		for(int i = 0; i < d.getArrayDeEfetivo().size(); i++) {
			tableModelDocEfe.addRow(new Object[] {
				d.getArrayDeEfetivo().get(i).nome,
				d.getArrayDeEfetivo().get(i).codigo,
				d.getArrayDeEfetivo().get(i).nivel,
				d.getArrayDeEfetivo().get(i).titulacao,
				d.getArrayDeEfetivo().get(i).area,
				d.getArrayDeEfetivo().get(i).salario,
			});
		}
	
	}
	
	public static void setTableDataDocSub(Departamento d) {
		for(int i = 0; i < d.getArrayDeSubstituto().size(); i++) {
			tableModelDocSub.addRow(new Object[] {
					d.getArrayDeSubstituto().get(i).nome,
					d.getArrayDeSubstituto().get(i).codigo,
					d.getArrayDeSubstituto().get(i).nivel,
					d.getArrayDeSubstituto().get(i).titulacao,
					d.getArrayDeSubstituto().get(i).cargaHoraria,
					d.getArrayDeSubstituto().get(i).salario,
			});
		}
		
	}
	
	public static void setTableDataTec(Departamento d) {
		for(int i = 0; i < d.getArrayDeTecnico().size(); i++) {
			tableModelTec.addRow(new Object[] {
					d.getArrayDeTecnico().get(i).nome,
					d.getArrayDeTecnico().get(i).codigo,
					d.getArrayDeTecnico().get(i).nivel,
					d.getArrayDeTecnico().get(i).funcao,
					d.getArrayDeTecnico().get(i).salario,
			});
		}
		
	}




}
	

