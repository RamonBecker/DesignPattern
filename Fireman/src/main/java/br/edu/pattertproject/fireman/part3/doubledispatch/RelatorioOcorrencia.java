package br.edu.pattertproject.fireman.part3.doubledispatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RelatorioOcorrencia {

	private List<Ocorrencia> listOcorrencia;
	private TreeMap<TipoIncendio, Double> lista_de_custos_total;
	private TreeMap<TipoIncendio, TreeMap<Integer, Equipamento>> lista_de_custo_Equipamento;

	public void addOcorrencia(Ocorrencia ocorrencia) {
		ocorrencia.addPropriedades(this);
		getListOcorrencia().add(ocorrencia);
	}

	public void addPropriedadeTipoIncendio(TipoIncendio tipoIncendio, Map<Integer, Equipamento> lista_equipamentos) {
		Equipamento recuperar_Equipamento = null;
		Double valor = 0.0;
		for (Integer id : lista_equipamentos.keySet()) {
			recuperar_Equipamento = lista_equipamentos.get(id);
			valor += recuperar_Equipamento.getCusto() * recuperar_Equipamento.getQuantidade();
		}

		getLista_de_custos_de_equipamentos().put(tipoIncendio,
				getLista_de_custos_de_equipamentos().get(tipoIncendio) + valor);
		
		

	}

	public TreeMap<TipoIncendio, TreeMap<Integer, Equipamento>> getLista_de_custo_Equipamento() {
		if (lista_de_custo_Equipamento == null) {
			lista_de_custo_Equipamento = new TreeMap<TipoIncendio, TreeMap<Integer, Equipamento>>();
		}
		return lista_de_custo_Equipamento;
	}

	public void setLista_de_custo_Equipamento(
			TreeMap<TipoIncendio, TreeMap<Integer, Equipamento>> lista_de_custo_Equipamento) {
		this.lista_de_custo_Equipamento = lista_de_custo_Equipamento;
	}

	public TreeMap<TipoIncendio, Double> getLista_de_custos_de_equipamentos() {
		if (lista_de_custos_total == null) {
			lista_de_custos_total = new TreeMap<TipoIncendio, Double>();
			for (TipoIncendio tipoIncendio : TipoIncendio.values()) {
				lista_de_custos_total.put(tipoIncendio, 0.0);
			}
		}
		return lista_de_custos_total;
	}

	public List<Ocorrencia> getListOcorrencia() {
		if (listOcorrencia == null) {
			listOcorrencia = new ArrayList<Ocorrencia>();
		}
		return listOcorrencia;
	}

}
