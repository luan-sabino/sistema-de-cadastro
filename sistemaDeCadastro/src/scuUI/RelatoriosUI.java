package scuUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.event.ChangeListener;

import controladores.DataCare;

import javax.swing.event.ChangeEvent;

public class RelatoriosUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1247008812233692347L;
	
	RelatoriosFuncionarios relatoriosFuncU = new RelatoriosFuncionarios();
	RelatoriosDocentes relatoriosDocU = new RelatoriosDocentes();
	RelatoriosDocentesEfetivos relatoriosEfeU = new RelatoriosDocentesEfetivos();
	RelatoriosDocentesSubstitutos relatoriosSubU = new RelatoriosDocentesSubstitutos();
	RelatoriosTecnicos relatoriosTecU = new RelatoriosTecnicos();
	RelatoriosResumoDepartamentos relatorioDepU = new RelatoriosResumoDepartamentos();
	/**
	 * Create the panel.
	 */
	public RelatoriosUI() {
		DataCare dc = new DataCare();
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedOp = new JTabbedPane(JTabbedPane.TOP);
		
		add(tabbedOp, BorderLayout.CENTER);
		
		JTabbedPane tabbedFunc = new JTabbedPane(JTabbedPane.TOP);
		//add(tabbedFunc, BorderLayout.CENTER);
		tabbedFunc.add("Funcionarios",relatoriosFuncU);
		tabbedFunc.add("Docentes",relatoriosDocU);
		tabbedFunc.add("Docentes Efetivos",relatoriosEfeU);
		tabbedFunc.add("Docentes Substitutos",relatoriosSubU);
		tabbedFunc.add("Tecnicos",relatoriosTecU);
		
		tabbedOp.addTab("Relatorios de Funcionarios", tabbedFunc);
		tabbedOp.addTab("Relatorios de Departamentos", relatorioDepU);
		
		tabbedOp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tabbedOp.getSelectedComponent() == relatorioDepU) {
					RelatoriosResumoDepartamentos.setTableData(dc);
				}
				
			}
		});
		
	}

}
