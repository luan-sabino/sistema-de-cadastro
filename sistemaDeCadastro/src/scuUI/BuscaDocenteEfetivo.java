package scuUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class BuscaDocenteEfetivo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3881435816190407978L;
	private JPanel contentPane;
	private static JTextField textNome = new JTextField();
	private static JTextField textCodigo = new JTextField();
	private static JTextField textNivel = new JTextField();
	private static JTextField textTitulacao = new JTextField();
	private static JTextField textArea = new JTextField();
	private static JTextField textSalario = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaDocenteEfetivo frame = new BuscaDocenteEfetivo();
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
	public BuscaDocenteEfetivo() {
		setResizable(false);
		setTitle("Docente Efetivo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 327, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome");
		
		textNome.setHorizontalAlignment(SwingConstants.CENTER);
		textNome.setEditable(false);
		textNome.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		textCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		
		textNivel.setHorizontalAlignment(SwingConstants.CENTER);
		textNivel.setEditable(false);
		textNivel.setColumns(10);
		
		textTitulacao.setHorizontalAlignment(SwingConstants.CENTER);
		textTitulacao.setEditable(false);
		textTitulacao.setColumns(10);
		
		textArea.setHorizontalAlignment(SwingConstants.CENTER);
		textArea.setEditable(false);
		textArea.setColumns(10);
		
		textSalario.setHorizontalAlignment(SwingConstants.CENTER);
		textSalario.setEditable(false);
		textSalario.setColumns(10);
		
		JLabel lblNivel = new JLabel("Nivel");
		
		JLabel lblTitulao = new JLabel("Titula\u00E7\u00E3o");
		
		JLabel lblArea = new JLabel("Area");
		
		JLabel lblSalario = new JLabel("Salario");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNome)
						.addComponent(lblNivel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArea, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigo, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTitulao, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addComponent(lblSalario, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textSalario, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTitulacao, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNivel, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNivel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNivel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textTitulacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitulao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArea))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSalario))
					.addContainerGap(188, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public static void setData(String nome, String codigo, String nivel, String titulacao, String area, double salario) {
		textNome.setText(nome);
		textCodigo.setText(codigo);
		textNivel.setText(nivel);
		textTitulacao.setText(titulacao);
		textArea.setText(area);
		textSalario.setText(String.valueOf(salario));	
	}

}


