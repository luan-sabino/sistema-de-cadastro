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

public class CadastroEfetivo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7350429301179264682L;
	private JTextField textNome;
	private JTextField textCodigo;
	DataCare dc = new DataCare();

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CadastroEfetivo() {
		
		setLayout(new MigLayout("", "[39.00px][73.82%,grow][20.00px,grow,left]", "[14px][14px][14px][14px,bottom][][][][]"));
		
		textNome = new JTextField();
		add(textNome, "flowx,cell 1 0,growx");
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		add(lblNome, "cell 0 0 3 1,growx,aligny top");
		
		JLabel lblCodigo = new JLabel("Codigo");
		add(lblCodigo, "flowx,cell 0 1 3 1,alignx left,aligny top");
		
		JLabel lblNivel = new JLabel("Nivel");
		add(lblNivel, "flowx,cell 0 2 3 1,alignx left,aligny top");
		
		JLabel lblFuno = new JLabel("Titula\u00E7\u00E3o");
		add(lblFuno, "flowx,cell 0 3 3 1,alignx left,aligny top");
		
		textCodigo = new JTextField();
		add(textCodigo, "cell 1 1,growx");
		textCodigo.setColumns(10);
		
		JComboBox boxNivel = new JComboBox();
		boxNivel.setModel(new DefaultComboBoxModel(new String[] {"D1", "D2", "D3"}));
		add(boxNivel, "cell 1 2,growx");
		
		JComboBox boxTitulacao = new JComboBox();
		boxTitulacao.setModel(new DefaultComboBoxModel(new String[] {"Gradua\u00E7\u00E3o", "Mestrado", "Doutorado", "Livre-Docente", "Titular"}));
		add(boxTitulacao, "cell 1 3,growx");
		
		JLabel lblArea = new JLabel("Area");
		add(lblArea, "cell 0 4,alignx left");
		
		JComboBox boxArea = new JComboBox();
		boxArea.setModel(new DefaultComboBoxModel(new String[] {"Biol\u00F3gicas", "Exatas", "Humanas", "Sa\u00FAde"}));
		add(boxArea, "cell 1 4,growx");
		
		JLabel lblNewLabel = new JLabel("Departamento");
		add(lblNewLabel, "cell 0 5,alignx trailing");
		
		
		JComboBox boxDepartamento = new JComboBox();
		add(boxDepartamento, "cell 1 5,growx");
		DefaultComboBoxModel dml = new DefaultComboBoxModel();
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
				String titulacaoStr = boxTitulacao.getSelectedItem().toString();
				String areaStr = boxArea.getSelectedItem().toString();
				if(tratamento(nomeStr, codigoStr)) {
					Departamento d = (Departamento) boxDepartamento.getSelectedItem();
					dc.criaFuncionario(nomeStr, codigoStr, nivelStr, titulacaoStr, areaStr, d);
				}else JOptionPane.showMessageDialog(null, "Preencha os campos corretamente, e lembre-se de não inserir um funcionario com nome ou codigo ja existente");
				textNome.setText("");
				textCodigo.setText("");
				boxNivel.setSelectedIndex(0);
				boxTitulacao.setSelectedIndex(0);
				boxArea.setSelectedIndex(0);
				boxDepartamento.setSelectedIndex(0);
			}
		});
		add(btnCadastra, "cell 1 7,alignx center");

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