package scuUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import componente.Departamento;
import java.awt.Font;

public class BuscaDepartamento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9012551034257415932L;
	private JPanel contentPane;
	private JTextField textNomeDep = new JTextField();;
	private JTextField textCodeDep = new JTextField();;
	private JLabel lblNewLabel_1;
	private final JPanel panel = new JPanel();
	private TabelaFuncionariosDepartamento tFD = new TabelaFuncionariosDepartamento();
	private final JLabel lblGasto = new JLabel("Gasto Total");
	private final JTextField txtGasto = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaDepartamento frame = new BuscaDepartamento();
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
	public BuscaDepartamento() {
		txtGasto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGasto.setEditable(false);
		txtGasto.setColumns(10);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtGasto, 11, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtGasto, 11, SpringLayout.EAST, lblGasto);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtGasto, 31, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtGasto, 202, SpringLayout.EAST, lblGasto);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGasto, 6, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGasto, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textNomeDep, 0, SpringLayout.WEST, textCodeDep);
		sl_contentPane.putConstraint(SpringLayout.EAST, textNomeDep, 0, SpringLayout.EAST, textCodeDep);
		sl_contentPane.putConstraint(SpringLayout.EAST, textCodeDep, -48, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -57, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -15, SpringLayout.EAST, contentPane);
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNomeDep = new JLabel("Nome do Departamento");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textNomeDep, -3, SpringLayout.NORTH, lblNomeDep);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNomeDep, 10, SpringLayout.NORTH, contentPane);
		contentPane.add(lblNomeDep);
		textNomeDep.setEditable(false);
		contentPane.add(textNomeDep);
		textNomeDep.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo do Departamento");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 24, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNomeDep, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textCodeDep, 1, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textCodeDep, 24, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel);
		textCodeDep.setEditable(false);
		textCodeDep.setColumns(10);
		contentPane.add(textCodeDep);
		
		lblNewLabel_1 = new JLabel("Funcionarios");
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -13, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -403, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, -5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, -5, SpringLayout.EAST, contentPane);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(tFD, BorderLayout.CENTER);
		lblGasto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		contentPane.add(lblGasto);
		
		contentPane.add(txtGasto);
		
		
		
	}
	
	public void setDataTxt(Departamento dp) {
		textNomeDep.setText(dp.getNome());
		textCodeDep.setText(dp.getCodigo());
		txtGasto.setText(String.valueOf(dp.getGasto()));	
	}
}
