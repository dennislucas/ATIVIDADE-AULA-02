import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AlunoControl implements ActionListener {
	AlunoView view;
    AlunoModel model;
	public AlunoControl(AlunoView view, AlunoModel model){
		this.view = view;
		this.model = model;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == view.btnInserir) {		
			carregaModel();
			model.cadastrar();			
		}else if(e.getSource() == view.btnAlterar){
			carregaModel();
			model.atualizar();
		}else if(e.getSource() == view.btnExcluir){
			carregaModel();
			model.excluir();
		}else if(e.getSource() == view.btnConsultar){
			if (view.txtId.getText().equals(null)){
				
			}else{	
							
			model.carregar();	
			atualizaTela();
			}
		}	
	}
	public void carregaModel(){
		int tmpId = Integer.parseInt(view.txtId.getText());
		int tmpIdade = Integer.parseInt(view.txtIdade.getText());
		model.setId(tmpId);
		model.setCpf(view.txtCpf.getText());
		model.setRg(view.txtRg.getText());
		model.setNome(view.txtNome.getText());
		model.setIdade(tmpIdade);
		model.setSexo(view.txtSexo.getText());
		model.setFone(view.txtTelefone.getText());
		model.setEmail(view.txtEmail.getText());
		model.setEndereco(view.txtEndereco.getText());
		model.setCep(view.txtCep.getText());
	}
	public void atualizaTela(){
		view.txtId.setText(""+model.getId());
		view.txtCpf.setText(model.getCpf());
		view.txtRg.setText(model.getRg());
		view.txtNome.setText(model.getNome());
		view.txtIdade.setText(""+model.getIdade());
		view.txtSexo.setText(model.getSexo());
		view.txtEndereco.setText(model.getEndereco());
		view.txtCep.setText(model.getCep());
		view.txtTelefone.setText(model.getFone());
		view.txtEmail.setText(model.getEmail());		
	}	
	
}
