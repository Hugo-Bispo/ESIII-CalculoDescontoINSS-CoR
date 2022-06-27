package controller;

import model.Funcionario;

public class CalculoDescontoINSS1 implements IDesconto{
	@Override
	public float calculaDesconto(Funcionario f) {
		float desconto = 1212.00f * 0.075f;
		f.setSalarioLiquido(f.getSalario() - desconto);
		return f.getSalarioLiquido();
	}

	@Override
	public void proximoDesconto(Funcionario f) {
		f.setSalarioLiquido(calculaDesconto(f));
		System.out.println("Desconto " + (f.getSalario() - f.getSalarioLiquido()));
		
		CalculoDescontoINSS2 calculo = new CalculoDescontoINSS2();
		calculo.proximoDesconto(f);
	}

}
