package br.edu.pattertproject.fireman.part3.doubledispatch;

import java.util.TreeMap;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

public class RelatorioOcorrencia {

	private TreeMap<TipoOcorrencia, Equipamento> lista_de_custo_Equipamento;
	private TreeMap<TipoOcorrencia, TreeMap<String, Equipamento>> lista;

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
			lista.get(tipoOcorrencia).put(equipamento.getModelo(), auxEquipamento);
		}

	}

	public TreeMap<TipoOcorrencia, Equipamento> getLista_de_custo_Equipamento() {
		if (lista_de_custo_Equipamento == null) {
			lista_de_custo_Equipamento = new TreeMap<TipoOcorrencia, Equipamento>();

		}
		return lista_de_custo_Equipamento;
	}

	public void setLista_de_custo_Equipamento(TreeMap<TipoOcorrencia, Equipamento> lista_de_custo_Equipamento) {
		this.lista_de_custo_Equipamento = lista_de_custo_Equipamento;
	}

	public TreeMap<TipoOcorrencia, TreeMap<String, Equipamento>> getLista() {
		if (lista == null) {
			lista = new TreeMap<TipoOcorrencia, TreeMap<String, Equipamento>>();
			for (TipoOcorrencia tipoOcorrencia : TipoOcorrencia.values()) {
				lista.put(tipoOcorrencia, new TreeMap<String, Equipamento>());
			}
		}
		return lista;
	}

}
