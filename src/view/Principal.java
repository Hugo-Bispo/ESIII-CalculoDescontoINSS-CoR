package view;

import org.hibernate.SessionFactory;

import controller.CalculoDescontoINSS1;
import model.Funcionario;
import util.HibernateUtil;

public class Principal {

	
	public static void main(String []args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Funcionario funcionario = new Funcionario();
		funcionario.setSalario(5000f);
		
		CalculoDescontoINSS1 calc = new CalculoDescontoINSS1();
		calc.proximoDesconto(funcionario);
		System.out.println("Desconto " + (funcionario.getSalario() - funcionario.getSalarioLiquido()));
		System.out.println(funcionario.toString());
	}

}
