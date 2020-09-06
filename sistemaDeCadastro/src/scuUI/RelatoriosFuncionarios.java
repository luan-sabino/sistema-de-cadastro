package scuUI;

import javax.swing.JPanel;
import controladores.DataCare;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class RelatoriosFuncionarios extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5373506077148073871L;
	
	@SuppressWarnings("serial")
	static DefaultTableModel modelo = new DefaultTableModel(			
			new Object[][] {},
			new String[] {
					"Nome", "Codigo", "Nivel", "Salario"
		}){
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	private JTable table = new JTable();
	DataCare dc = new DataCare();

	/**
	 * Create the panel.
	 */
	public RelatoriosFuncionarios() {
		setLayout(new BorderLayout(0, 0));
		table.setFillsViewportHeight(true);
		table.setBorder(null);
		table.setModel(modelo);
		table.getColumnModel().getColumn(2).setPreferredWidth(76);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);

	}
	
	public static void setTableData(DataCare dc) {
		if(dc.db.getTodosFuncionarios().size() != 0) {
			
			modelo.setRowCount(0);
			for(int i = 0; i < dc.db.getTodosFuncionarios().size(); i++)
			
			modelo.addRow(new Object[] { dc.db.getTodosFuncionarios().get(i).nome  ,
					dc.db.getTodosFuncionarios().get(i).codigo	,
					dc.db.getTodosFuncionarios().get(i).nivel  ,
					dc.db.getTodosFuncionarios().get(i).salario });
		}
		else {}
		
	}
	
	
	
}
