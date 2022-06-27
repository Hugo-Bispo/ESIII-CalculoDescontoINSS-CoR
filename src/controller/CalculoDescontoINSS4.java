package controller;

import model.Funcionario;

public class CalculoDescontoINSS4 implements IDesconto {
	@Override
	public float calculaDesconto(Funcionario f) {
		float desconto = 0;
		if (f.getSalario() > (3641.03f) && f.getSalario() < (7087.22f)) {
			desconto = (f.getSalario() - 3641.03f) * 0.14f;
			f.setSalarioLiquido(f.getSalarioLiquido() - desconto);
		}
		return f.getSalarioLiquido();
	}

	@Override
	public void proximoDesconto(Funcionario f) {
		f.setSalarioLiquido(calculaDesconto(f));
		System.out.println("Desconto " + (f.getSalario() - f.getSalarioLiquido()));
	}
}