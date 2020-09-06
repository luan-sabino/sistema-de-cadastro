package scuUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import componente.Departamento;
import controladores.DataCare;
import net.miginfocom.swing.MigLayout;

public class CadastroTecnico extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9060769069514433915L;
	private JTextField textNome;
	private JTextField textCodigo;
	DataCare dc = new DataCare();

	/**
	 * Create the panel.
	 */
	public CadastroTecnico() {
		setLayout(new MigLayout("", "[39.00px][73.82%,grow][20.00px,grow,left]", "[14px][14px][14px][14px,bottom][][][]"));
		
		textNome = new JTextField();
		add(textNome, "flowx,cell 1 0,growx");
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		add(lblNome, "cell 0 0 3 1,growx,aligny top");
		
		JLabel lblCodigo = new JLabel("Codigo");
		add(lblCodigo, "flowx,cell 0 1 3 1,alignx left,aligny top");
		
		JLabel lblNivel = new JLabel("Nivel");
		add(lblNivel, "flowx,cell 0 2 3 1,alignx left,aligny top");
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o");
		add(lblFuno, "flowx,cell 0 3 3 1,alignx left,aligny top");
		
		textCodigo = new JTextField();
		add(textCodigo, "cell 1 1,growx");
		textCodigo.setColumns(10);
		
		JComboBox<String> boxNivel = new JComboBox<String>();
		boxNivel.setModel(new DefaultComboBoxModel<String>(new String[] {"T1", "T2"}));
		add(boxNivel, "cell 1 2,growx");
		
		JComboBox<String> boxFuncao = new JComboBox<String>();
		boxFuncao.setModel(new DefaultComboBoxModel<String>(new String[] {"Secret\u00E1rio", "Laborat\u00F3rio", "Assesor"}));
		add(boxFuncao, "cell 1 3,growx");
		
		JLabel lblNewLabel = new JLabel("Departamento");
		add(lblNewLabel, "cell 0 4,alignx trailing");
		
		
		JComboBox<Departamento> boxDepartamento = new JComboBox<Departamento>();
		add(boxDepartamento, "cell 1 4,growx");
		DefaultComboBoxModel<Departamento> dml = new DefaultComboBoxModel<Departamento>();
		for(int  i = 0; i < dc.getDepartamentosArray().size(); i++) {
			dml.addElement(dc.getDepartamentosByIndex(i));
		}
		boxDepartamento.setModel(dml);
		boxDepartamento.setRenderer(new CategoryListCellRenderer());
		boxDepartamento.validate();
		
		JButton btnCadastra = new JButton("Cadastrar");
		btnCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeStr = textNome.getText();
				String codigoStr = textCodigo.getText();
				String nivelStr = boxNivel.getSelectedItem().toString();
				String funcaoStr = boxFuncao.getSelectedItem().toString();
				if(tratamento(nomeStr, codigoStr)) {
					Departamento d = (Departamento) boxDepartamento.getSelectedItem();
					dc.criaFuncionario(nomeStr, codigoStr, nivelStr, funcaoStr, d);
				}else JOptionPane.showMessageDialog(null, "Preencha os campos corretamente, e lembre-se de não inserir um funcionario com nome ou codigo ja existente");
				textNome.setText("");
				textCodigo.setText("");
				boxNivel.setSelectedIndex(0);
				boxFuncao.setSelectedIndex(0);
				boxDepartamento.setSelectedIndex(0);
			}
		});
		add(btnCadastra, "cell 1 6,alignx center");

	}

	@SuppressWarnings("serial")
	public class CategoryListCellRenderer extends DefaultListCellRenderer {

	    @Override
	    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

	        if (value instanceof Departamento) {
	            value = ((Departamento)value).getNome();
	        }

	        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

	    }

	}
	
	public boolean tratamento(String nome, String codigo) {
		if(nome.isBlank() || codigo.isBlank()) {
			return false;
		}
		if(dc.getFuncionarioByNameOrCode(nome) != null || dc.getFuncionarioByNameOrCode(codigo) != null) return false;
		return true;
	}
}
