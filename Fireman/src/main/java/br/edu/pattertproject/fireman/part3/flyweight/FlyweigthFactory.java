package br.edu.pattertproject.fireman.part3.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweigthFactory {
	private Map<TipoTaxa, Taxa> taxas;
	private Edificacao edificacao;

	public Map<TipoTaxa, Taxa> getTaxas() {
		if (this.taxas == null) {
			taxas = new HashMap<TipoTaxa, Taxa>();
			taxas.put(TipoTaxa.TAXAFUNCIONAMENTO, new TaxaFuncionamento());
			taxas.put(TipoTaxa.TAXAHABITESE, new TaxaHabitese());
		}
		return taxas;
	}

	public Edificacao getEdificacao() {
		return edificacao;
	}

	public void setEdificacao(Edificacao edificacao) {
		if (edificacao == null) {
			throw new IllegalArgumentException("A edificação não pode ser nula");
		}
		this.edificacao = edificacao;
	}

	public void getTaxa(Empresa empresa, TipoTaxa tipoTaxa) throws Exception {

		if (empresa == null) {
			throw new Exception("A empresa não pode ser nula");
		}

		Taxa taxa = null;

		if (!getTaxas().containsKey(tipoTaxa)) {
			throw new Exception("Esse tipo de taxa não existe !");
		} else {
			taxa = getTaxas().get(tipoTaxa);

			if (taxa instanceof TaxaFuncionamento) {
				((TaxaFuncionamento) taxa).setBloco(getEdificacao().getBloco());
			} else if (taxa instanceof TaxaHabitese) {
				((TaxaHabitese) taxa).setEdificacao(getEdificacao());
			}

			taxa.gerarTaxa();
			empresa.setTaxa(taxa);
		}
	}

}
