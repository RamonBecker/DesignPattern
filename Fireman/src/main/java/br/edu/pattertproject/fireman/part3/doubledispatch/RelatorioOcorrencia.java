package br.edu.pattertproject.fireman.part3.doubledispatch;

import java.util.TreeMap;

public class RelatorioOcorrencia {

	private TreeMap<TipoOcorrencia, Double> lista_de_custo_Equipamento;
	private TreeMap<TipoOcorrencia, TreeMap<String, Equipamento>> lista_de_equipamento;

	public RelatorioOcorrencia() {
		getLista();
	}

	public void addOcorrencia(Ocorrencia ocorrencia) {
		for (Equipamento equipamento : ocorrencia.getLista_Equipamentos()) {
			equipamento.addPropriedade(this);
		}
	}

	public void addPropriedades(TipoOcorrencia tipoOcorrencia, Equipamento equipamento) {
		Equipamento auxEquipamento = null;

		if (!getLista().get(tipoOcorrencia).containsKey(equipamento.getModelo())) {
			getLista().get(tipoOcorrencia).put(equipamento.getModelo(), equipamento);
		} else {
			auxEquipamento = getLista().get(tipoOcorrencia).get(equipamento.getModelo());
			Double custo = auxEquipamento.getCusto() + equipamento.getCusto();
			Integer quantidade = auxEquipamento.getQuantidade() + equipamento.getQuantidade();
			auxEquipamento.setCusto(custo);
			auxEquipamento.setQuantidade(quantidade);
			lista_de_equipamento.get(tipoOcorrencia).put(equipamento.getModelo(), auxEquipamento);
		}

	}

	public void getTotalGastos() {

		Double valor = 0.0;
		for (TipoOcorrencia tipoOcorrencia : TipoOcorrencia.values()) {
			for (String modelo : getLista().get(tipoOcorrencia).keySet()) {
				Equipamento auxEquipamento = getLista().get(tipoOcorrencia).get(modelo);
				valor += auxEquipamento.getCusto() * auxEquipamento.getQuantidade();
				getLista_de_custo_Equipamento().put(tipoOcorrencia, valor);
			}
		}
	}

	public TreeMap<TipoOcorrencia, Double> getLista_de_custo_Equipamento() {
		if (lista_de_custo_Equipamento == null) {
			lista_de_custo_Equipamento = new TreeMap<TipoOcorrencia, Double>();
			for (TipoOcorrencia tipoOcorrencia : TipoOcorrencia.values()) {
				lista_de_custo_Equipamento.put(tipoOcorrencia, 0.0);
			}

		}
		return lista_de_custo_Equipamento;
	}

	public TreeMap<TipoOcorrencia, TreeMap<String, Equipamento>> getLista() {
		if (lista_de_equipamento == null) {
			lista_de_equipamento = new TreeMap<TipoOcorrencia, TreeMap<String, Equipamento>>();
			for (TipoOcorrencia tipoOcorrencia : TipoOcorrencia.values()) {
				lista_de_equipamento.put(tipoOcorrencia, new TreeMap<String, Equipamento>());
			}
		}
		return lista_de_equipamento;
	}

}
