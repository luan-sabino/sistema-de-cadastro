package scuUI;

import javax.swing.JPanel;
import controladores.DataCare;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class RelatoriosDocentesSubstitutos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7654970081670475556L;
	
	@SuppressWarnings("serial")
	static DefaultTableModel modelo = new DefaultTableModel(			
			new Object[][] {},
			new String[] {
					"Nome", "Codigo", "Nivel","Titulação","Carga Horaria", "Salario"
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
	public RelatoriosDocentesSubstitutos() {
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
		if(dc.db.getTodosSubstitutos().size() != 0) {
			
			modelo.setRowCount(0);
			for(int i = 0; i < dc.db.getTodosSubstitutos().size(); i++)
			
			modelo.addRow(new Object[] { dc.db.getTodosSubstitutos().get(i).nome  ,
					dc.db.getTodosSubstitutos().get(i).codigo	,
					dc.db.getTodosSubstitutos().get(i).nivel  ,
					dc.db.getTodosSubstitutos().get(i).titulacao,
					dc.db.getTodosSubstitutos().get(i).cargaHoraria,
					dc.db.getTodosSubstitutos().get(i).salario });
		}
		else {modelo.setRowCount(0);}
		
	}
	
	
	
}
