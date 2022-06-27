package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Funcionario;

public class FuncionarioDAO {

	private SessionFactory sf;

	public FuncionarioDAO(SessionFactory sf) {
		this.sf = sf;
	}

	public void insert(Funcionario funcionario) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(funcionario);
		transaction.commit();
	}

	public void update(Funcionario funcionario) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(funcionario);
		transaction.commit();
	}

	public void delete(Funcionario funcionario) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(funcionario);
		transaction.commit();
	}

	public Funcionario selectOne(Funcionario funcionario) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		funcionario = entityManager.find(Funcionario.class, funcionario.getId());
		return funcionario;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> selectAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT id, nome, salario from funcionario;");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> funcionarioResultSet = query.getResultList();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		for (Object[] o : funcionarioResultSet) {
			Funcionario funcionario = new Funcionario();
			funcionario.setId(Integer.parseInt(o[0].toString()));
			funcionario.setNome(o[1].toString());
			funcionario.setSalario(Float.parseFloat(o[2].toString()));
			funcionarios.add(funcionario);
		}
		return funcionarios;
	}

}
