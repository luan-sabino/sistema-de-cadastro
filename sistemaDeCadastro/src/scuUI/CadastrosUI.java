package scuUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class CadastrosUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -303637212074267107L;

	/**
	 * Create the panel.
	 */
	public CadastrosUI() {
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.NORTH);
		tabbedPane.addTab("Cadastro de Tecnicos", new CadastroTecnico());
		tabbedPane.addTab("Cadastro de Docentes Efetivos", new CadastroEfetivo());
		tabbedPane.addTab("Cadastro de Docentes Substitutos", new CadastroSubstituto());

	}
}
