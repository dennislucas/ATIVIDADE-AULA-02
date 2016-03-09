import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class AlunoView extends JFrame {
	JPanel panel, panel2;
	JLabel lblId, lblNome, lblTelefone, lblEndereco, lblEmail, lblRg,
			lblCpf, lblCep, lblIdade, lblSexo;
	JTextField txtId, txtNome, txtTelefone, txtEndereco, txtEmail, txtRg,
			txtCpf, txtCep, txtIdade, txtSexo;
	JButton btnInserir, btnExcluir, btnAlterar, btnConsultar;
	
    JLabel lblUser, lblPass;
    JTextField txtUser, txtPass;
    
    AlunoControl aControl;

	public AlunoView(String title,Locale idioma) {
		super("Controle de " + title);
		setSize(400, 540);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		setResizable(false);
		
		iniciarTudo(idioma);
		
		JPanel pnl0 = new JPanel();
		GridBagConstraints c = new GridBagConstraints();
		pnl0.setBorder(new LineBorder(Color.GRAY));
		pnl0.setLayout(new GridBagLayout());
		pnl0.setBounds(10, 10, 370, 300);
		JPanel pnl1 = new JPanel();
		pnl1.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));
	//	pnl1.setBorder(new LineBorder(Color.GRAY));
		pnl1.setLayout(new GridBagLayout());
		pnl1.setBounds(10, 320, 350, 90);
		JPanel pnl2 = new JPanel();
		pnl2.setBorder(new LineBorder(Color.GRAY));
		pnl2.setLayout(new GridBagLayout());
		pnl2.setBounds(10, 430, 350, 70);
		// painel0
		c.insets = new Insets(5, 10, 0, 0); // Y, X, ?, ?
		c.anchor = GridBagConstraints.EAST;
		c.fill = GridBagConstraints.EAST;
		c.gridx = 0;// coluna1
		c.gridy = 0;pnl0.add(lblId, c);
		c.gridy = 1;pnl0.add(lblNome, c);
		c.gridy = 2;pnl0.add(lblIdade, c);
		c.gridy = 3;pnl0.add(lblSexo, c);
		c.gridy = 4;pnl0.add(lblTelefone, c);
		c.gridy = 5;pnl0.add(lblCep, c);
		c.gridy = 6;pnl0.add(lblEndereco, c);
		c.gridy = 7;pnl0.add(lblEmail, c);
		c.gridy = 8;pnl0.add(lblRg, c);
		c.gridy = 9;pnl0.add(lblCpf, c);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.RELATIVE;
		c.gridx = 1;// coluna1
		c.gridy = 0;pnl0.add(txtId, c);
		c.gridy = 1;pnl0.add(txtNome, c);
		c.gridy = 2;pnl0.add(txtIdade, c);
		c.gridy = 3;pnl0.add(txtSexo, c);
		c.gridy = 4;pnl0.add(txtTelefone, c);
		c.gridy = 5;pnl0.add(txtCep, c);
		c.gridy = 6;pnl0.add(txtEndereco, c);
		c.gridy = 7;pnl0.add(txtEmail, c);
		c.gridy = 8;pnl0.add(txtRg, c);
		c.gridy = 9;pnl0.add(txtCpf, c);

		 //Usuario
		c.anchor = GridBagConstraints.EAST;
		c.fill = GridBagConstraints.EAST;
		c.gridx = 0;// coluna1
		//c.gridy = 0;pnl2.add(new JLabel("Informatica"));
		c.gridy = 1;pnl1.add(lblUser, c);
		c.gridy = 2;pnl1.add(lblPass, c);		
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.RELATIVE;
		c.gridx = 1;// coluna1
		c.gridy = 1;pnl1.add(txtUser, c);
		c.gridy = 2;pnl1.add(txtPass, c);
		// butao
		// painel1
		c.gridy = 0; // Y linha0
		c.gridx = 0;pnl2.add(btnInserir, c);
		c.gridx = 1;pnl2.add(btnAlterar, c);
		c.gridx = 2;pnl2.add(btnExcluir, c);
		c.gridx = 3;pnl2.add(btnConsultar, c);

		panel = new JPanel();
		panel.add(pnl0);
		panel.add(pnl1);
		panel.add(pnl2);
		panel.setLayout(null);
		setContentPane(panel);

		aControl = new AlunoControl(this,new AlunoModel()); 	
		addController(aControl);
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
			// this.pack();
		} catch (Exception exc) {
		}
		setVisible(true);

	}
	public void iniciarTudo(Locale idioma){
		ResourceBundle bundle = ResourceBundle.getBundle("generic", idioma); 
		lblId = new JLabel(bundle.getString("id"));
		lblNome = new JLabel(bundle.getString("nome"));
		lblTelefone = new JLabel(bundle.getString("telefone"));
		lblEndereco = new JLabel(bundle.getString("endereco"));
		lblEmail = new JLabel(bundle.getString("email"));
		lblRg = new JLabel(bundle.getString("rg"));
		lblCpf = new JLabel(bundle.getString("cpf"));
		lblCep = new JLabel(bundle.getString("cep"));
		lblIdade = new JLabel(bundle.getString("idade"));
		lblSexo = new JLabel(bundle.getString("sexo"));

		txtId = new JTextField(10);
		txtNome = new JTextField(20);
		txtTelefone = new JTextField(20);
		txtEndereco = new JTextField(20);
		txtEmail = new JTextField(20);
		txtRg = new JTextField(20);
		txtCpf = new JTextField(20);
		txtCep = new JTextField(20);
		txtIdade = new JTextField(3);
		txtSexo  = new JTextField(1);
		
		btnInserir = new JButton(bundle.getString("inserir"));
		btnAlterar = new JButton(bundle.getString("alterar"));
		btnExcluir = new JButton(bundle.getString("excluir"));
		btnConsultar = new JButton(bundle.getString("consultar"));
		
        lblUser = new JLabel(bundle.getString("user"));
        lblPass = new JLabel(bundle.getString("pass"));
        txtUser = new JTextField(20);
        txtPass = new JPasswordField(20);		
	}
	 public void addController(ActionListener control){
			System.out.println("Add Controler");
			btnInserir.addActionListener(control);
			btnAlterar.addActionListener(control);
			btnExcluir.addActionListener(control);
			btnConsultar.addActionListener(control);			
		} //addController()
	 public static void main(String [] args){
		 new AlunoView("Aluno",new Locale("pt","BR")).setVisible(true);		 
	 }
}
