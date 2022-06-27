package controller;

import model.Funcionario;

public interface IDesconto {
	public float calculaDesconto(Funcionario f);
	public void proximoDesconto(Funcionario f);
}
