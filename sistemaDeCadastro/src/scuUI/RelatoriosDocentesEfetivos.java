package scuUI;

import javax.swing.JPanel;
import controladores.DataCare;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class RelatoriosDocentesEfetivos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1523994338474943755L;
	
	@SuppressWarnings("serial")
	static DefaultTableModel modelo = new DefaultTableModel(			
			new Object[][] {},
			new String[] {
					"Nome", "Codigo", "Nivel","Titulação","Area", "Salario"
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
	public RelatoriosDocentesEfetivos() {
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
		if(dc.db.getTodosEfetivos().size() != 0) {
			
			modelo.setRowCount(0);
			for(int i = 0; i < dc.db.getTodosEfetivos().size(); i++)
			
			modelo.addRow(new Object[] { dc.db.getTodosEfetivos().get(i).nome  ,
					dc.db.getTodosEfetivos().get(i).codigo	,
					dc.db.getTodosEfetivos().get(i).nivel  ,
					dc.db.getTodosEfetivos().get(i).titulacao,
					dc.db.getTodosEfetivos().get(i).area,
					dc.db.getTodosEfetivos().get(i).salario });
		}
		else {modelo.setRowCount(0);}
		
	}
	
	
	
}