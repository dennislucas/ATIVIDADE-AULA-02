import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDAO {  
   // Configura essas variáveis de acordo com o seu banco  
	
	public void incluir(AlunoTO to) {
		String sqlInsert = "INSERT INTO aluno(id, cpf, rg, nome, idade, sexo, email, fone, endereco, cep ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getId());
			stm.setString(2, to.getCpf());
			stm.setString(3, to.getRg());
			stm.setString(4, to.getNome());
			stm.setInt(5, to.getIdade());
			stm.setString(6, to.getSexo());
			stm.setString(7, to.getEmail());
			stm.setString(8, to.getFone());
			stm.setString(9, to.getEndereco());
			stm.setString(10, to.getCep());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void atualizar(AlunoTO to) {
		String sqlUpdate = "UPDATE aluno SET cpf=?, rg=?, nome=?, idade=?, sexo=?, email=?, fone=?, endereco=?, cep=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getCpf());
			stm.setString(2, to.getRg());
			stm.setString(3, to.getNome());
			stm.setInt(4, to.getIdade());
			stm.setString(5, to.getSexo());
			stm.setString(6, to.getEmail());
			stm.setString(7, to.getFone());
			stm.setString(8, to.getEndereco());
			stm.setString(9, to.getCep());
			stm.setInt(10, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}  
	public void excluir(AlunoTO to) {
		String sqlDelete = "DELETE FROM aluno WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public AlunoTO carregar(int id) {
		AlunoTO to = new AlunoTO();
		String sqlSelect = "SELECT cpf, rg, nome, idade, sexo, email, fone, endereco, cep FROM aluno WHERE aluno.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setCpf(rs.getString("cpf"));
					to.setRg(rs.getString("rg"));
					to.setNome(rs.getString("nome"));
					to.setIdade(rs.getInt("idade"));
					to.setSexo(rs.getString("sexo"));
					to.setEmail(rs.getString("email"));
					to.setFone(rs.getString("fone"));
					to.setEndereco(rs.getString("endereco"));
					to.setCep(rs.getString("cep"));									
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
}