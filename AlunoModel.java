
public class AlunoModel {
	private String nome;
	private String rg;
	private String cpf;
	private int idade;
	private String sexo;
	private String email;
	private String fone;
	private String endereco;
	private String cep;
	private int id;
	

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void cadastrar(){
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		
		to.setId(id);
		to.setNome(nome);
		to.setIdade(idade);
		to.setSexo(sexo);
		to.setEmail(email);
		to.setFone(fone);
		to.setEndereco(endereco);
		to.setCep(cep);
		to.setRg(rg);
		to.setCpf(cpf);
		dao.incluir(to);
	}
	public void atualizar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		
		to.setId(id);
		to.setNome(nome);
		to.setIdade(idade);
		to.setSexo(sexo);
		to.setEmail(email);
		to.setFone(fone);
		to.setEndereco(endereco);
		to.setCep(cep);
		to.setRg(rg);
		to.setCpf(cpf);
		dao.atualizar(to);
	}
	public void excluir() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		
		to.setId(id);
		dao.excluir(to);
	}
	public void carregar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = dao.carregar(id);
		
		cpf  	= to.getCpf();
		rg   	= to.getRg();		
		nome 	= to.getNome();
		idade	= to.getIdade();
		sexo 	= to.getSexo();
		email 	= to.getEmail();		
		fone 	= to.getFone();
		endereco = to.getEndereco();
		cep = to.getCep();
	}
	@Override
	public String toString() {
		return "Aluno [id=" + id +
					", cpf=" + cpf +
					", rg=" + rg +
					", nome=" + nome +
					", idade=" + idade +
					", sexo=" + sexo +
					", email=" + email +
					", fone=" + fone +
					", endereco=" + endereco +
					", cep=" + cep +
					"]";
	}

}
