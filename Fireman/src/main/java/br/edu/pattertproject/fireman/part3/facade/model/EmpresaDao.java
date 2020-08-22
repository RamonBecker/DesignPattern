package br.edu.pattertproject.fireman.part3.facade.model;

import java.util.HashMap;
import java.util.Map;

import br.edu.pattertproject.fireman.part3.facade.CamposEmpresa;
import br.edu.pattertproject.fireman.part3.facade.model.empresa.Documento;
import br.edu.pattertproject.fireman.part3.facade.model.empresa.Empresa;

public class EmpresaDao implements IDao {
	private Map<String, Empresa> listaEmpresa;

	@Override
	public void add(Map<Object, Object> lista, Object object) throws Exception {
		Empresa empresa = null;

		if (object instanceof Empresa) {
			empresa = (Empresa) object;
			Documento documento = (Documento) lista.get(CamposEmpresa.DOCUMENTO.getDescricao());
			String nomeFantasia = (String) lista.get(CamposEmpresa.NOME_FANTASIA.getDescricao());
			String razaoSocial = (String) lista.get(CamposEmpresa.RAZAO_SOCIAL.getDescricao());
			String ocupacao = (String) lista.get(CamposEmpresa.OCUPACAO.getDescricao());
			empresa.setDocumento(documento);
			empresa.setNomeFantasia(nomeFantasia);
			empresa.setRazaoSocial(razaoSocial);
			empresa.setOcupacao(ocupacao);
			System.out.println("Empresa cadastrada com sucesso !");
			System.out.println(empresa);
			getListaEmpresa().put(empresa.getDocumento().getNumeroDocumento(), empresa);
			return;
		}
		throw new Exception("Não foi possível cadastrar a empresa");

	}

	@Override
	public void listar() {
		if (getListaEmpresa().isEmpty()) {
			System.out.println("Não há empresas cadastradas");
			return;
		}

		for (String key : getListaEmpresa().keySet()) {
			System.out.println(getListaEmpresa().get(key));
		}
	}

	@Override
	public Object buscar(Object key) throws Exception {
		String n_documento = (String) key;

		if (listaEmpresa.containsKey(n_documento)) {
			return listaEmpresa.get(n_documento);
		}
		throw new Exception("Essa empresa não existe!");
	}

	public Map<String, Empresa> getListaEmpresa() {
		if (this.listaEmpresa == null) {
			listaEmpresa = new HashMap<String, Empresa>();
		}
		return listaEmpresa;
	}

}
