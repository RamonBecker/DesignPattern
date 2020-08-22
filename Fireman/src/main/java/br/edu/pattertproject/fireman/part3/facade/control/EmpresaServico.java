package br.edu.pattertproject.fireman.part3.facade.control;

import java.util.HashMap;
import java.util.Map;
import br.edu.pattertproject.fireman.part3.facade.CamposEmpresa;
import br.edu.pattertproject.fireman.part3.facade.model.EmpresaDao;
import br.edu.pattertproject.fireman.part3.facade.model.IDao;
import br.edu.pattertproject.fireman.part3.facade.model.empresa.Documento;
import br.edu.pattertproject.fireman.part3.facade.model.empresa.Empresa;

public class EmpresaServico {
	private IDao iDao;
	private Map<Object, Object> argumentos;

	public EmpresaServico() {
		argumentos = new HashMap<Object, Object>();
		setiDao(new EmpresaDao());
	}

	public void add(Documento doc, String nomeFantasia, String razaoSocial, String ocupacao) {
		argumentos.put(CamposEmpresa.DOCUMENTO.getDescricao(), doc);
		argumentos.put(CamposEmpresa.NOME_FANTASIA.getDescricao(), nomeFantasia);
		argumentos.put(CamposEmpresa.RAZAO_SOCIAL.getDescricao(), razaoSocial);
		argumentos.put(CamposEmpresa.OCUPACAO.getDescricao(), ocupacao);

		try {
			iDao.add(argumentos, new Empresa());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscar(String documento) {
		try {
			Empresa empresa = (Empresa) iDao.buscar(documento);
			System.out.println("Empresa buscada:" + empresa);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listar() {
		iDao.listar();
	}
	
	private void setiDao(IDao iDao) {
		this.iDao = iDao;
	}

}
