package br.edu.pattertproject.fireman.part3.facade.model;

import java.util.Map;

import br.edu.pattertproject.fireman.part3.facade.CamposEmpresa;
import br.edu.pattertproject.fireman.part3.facade.model.empresa.Documento;
import br.edu.pattertproject.fireman.part3.facade.model.empresa.Empresa;

public class EmpresaDao implements IDao {

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
			return;
		}
		throw new Exception("Não foi possível cadastrar a empresa");

	}

	@Override
	public void buscar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub

	}

}
