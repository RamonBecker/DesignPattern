package br.edu.pattertproject.fireman.part1.hook_method;

public class RevisaoEquipamentoHospitalar extends Revisao {

	@Override
	public double revisaoDoDia(double valor) {
		setValorRevisao(valor);
		return getValorRevisao();
	}

	@Override
	public double revisaoDoMes(double valor) {

		setValorRevisao((getValorRevisao() * 0.50) + revisaoDoDia(valor));

		return getValorRevisao();
	}

	@Override
	public double revisaoAnual(double valor) {

		setValorRevisao((revisaoDoMes(valor) * revisaoDoDia(valor)) + 1000);

		return getValorRevisao();
	}

	@Override
	public String toString() {
		return "Revisao Equipamentos:"+getValorRevisao();
	}
	
}
