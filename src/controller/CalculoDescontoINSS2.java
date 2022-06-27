package controller;

import model.Funcionario;

public class CalculoDescontoINSS2 implements IDesconto{

	@Override
	public float calculaDesconto(Funcionario f) {
		float desconto = 0;
		if(f.getSalario()> (1212.00f)) {
			if(f.getSalario()> (2427.35f)) {
				desconto = (2427.35f - 1212.00f) * 0.09f;
			}else {
				desconto = (f.getSalario() - 1212.00f) * 0.09f;
			}
			f.setSalarioLiquido(f.getSalarioLiquido() - desconto);
		}
		return f.getSalarioLiquido();
	}

	@Override
	public void proximoDesconto(Funcionario f) {
		f.setSalarioLiquido(calculaDesconto(f));
		System.out.println("Desconto " + (f.getSalario() - f.getSalarioLiquido()));
		
		CalculoDescontoINSS3 calculo = new CalculoDescontoINSS3();
		calculo.proximoDesconto(f);
		
	}

}
