package controller;

import model.Funcionario;

public class CalculoDescontoINSS3 implements IDesconto{
	
	@Override
	public float calculaDesconto(Funcionario f) {
		float desconto = 0;
		if(f.getSalario()> (2427.36f)) {
			if(f.getSalario()> (3641.03f)) {
				desconto = (3641.03f - 2427.35f) * 0.12f;
			}else {
			desconto = (f.getSalario() - 2427.36f) * 0.12f;
			}
			f.setSalarioLiquido(f.getSalarioLiquido() - desconto);
		}
		return f.getSalarioLiquido();
	}

	@Override
	public void proximoDesconto(Funcionario f) {
		f.setSalarioLiquido(calculaDesconto(f));
		System.out.println("Desconto " + (f.getSalario() - f.getSalarioLiquido()));
		
		CalculoDescontoINSS4 calculo = new CalculoDescontoINSS4();
		calculo.proximoDesconto(f);	
	}

}
