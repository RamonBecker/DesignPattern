package br.edu.pattertproject.fireman.Fireman.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Endereco;
import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Usuario;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullCentralOcorrencia;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullViatura;
import br.edu.pattertproject.fireman.Fireman.observer_pattern.CentralDeOcorrencia;
import br.edu.pattertproject.fireman.Fireman.observer_pattern.Ocorrencia;
import br.edu.pattertproject.fireman.Fireman.observer_pattern.Viatura;

public class DaoOcorrencia {

	private List<Ocorrencia> listOcorrencias;
	private List<Viatura> listViatura;
	private List<CentralDeOcorrencia> listCentralDeOcorrencias;

	public DaoOcorrencia() {
		this.listOcorrencias = new ArrayList<Ocorrencia>();
		this.listViatura = new ArrayList<Viatura>();
		this.listCentralDeOcorrencias = new ArrayList<CentralDeOcorrencia>();
	}

	public void gerarOcorrencia(Scanner scanner) {
		String rua, bairro, cidade, numero;

		System.out.println("------ Gerando Ocorrência --------");

		System.out.print("Digite o a rua");
		rua = scanner.next();

		System.out.print("Digite o bairro:");
		bairro = scanner.next();

		System.out.print("Digite a cidade:");
		cidade = scanner.next();

		System.out.print("Digite o numero:");
		numero = scanner.next();

		Endereco endereco = new Endereco(rua, bairro, cidade, numero);

		Ocorrencia ocorrencia = new Ocorrencia(endereco, empenharViatura(scanner));

		listOcorrencias.add(ocorrencia);

	}

	public Viatura empenharViatura(Scanner scanner) {

		if (listViatura.isEmpty()) {

			return criarViatura(scanner);
		}

		System.out.println("\n\n ------------ Empenhando viatura ------------ \n\n");
		int i = 0;
		for (Viatura viatura : listViatura) {
			System.out.println("Indice: " + i + ") " + viatura);
			i++;
		}

		System.out.print("Selecione a viatura por indice:");

		int indice = scanner.nextInt();

		if (indice < listViatura.size()) {
			return listViatura.get(indice);
		}

		return new NullViatura();
	}

	public void adicionarObservadorCentralOcorrencia(Scanner scanner) {
		System.out.println("Adicionar central de ocorrencia para acompanhar a viatura");

		Viatura viatura = empenharViatura(scanner);

		CentralDeOcorrencia centralDeOcorrencia = listarCentralOcorrencia(scanner);

		if (centralDeOcorrencia instanceof NullCentralOcorrencia) {
			centralDeOcorrencia = criarCentralOcorrencia(scanner);
		}

		viatura.getListObserver().add(centralDeOcorrencia);
	}

	public CentralDeOcorrencia listarCentralOcorrencia(Scanner scanner) {
		if (listCentralDeOcorrencias.isEmpty()) {
			return new NullCentralOcorrencia();
		}
		System.out.println("\n\n ------ Listando central de ocorrencias ------\n\n");

		int i = 0;

		for (CentralDeOcorrencia centralDeOcorrencia : listCentralDeOcorrencias) {
			System.out.println("Indice: " + i + ") " + centralDeOcorrencia);
			i++;
		}
		System.out.print("Selecione a central pelo indice:");

		int indice = scanner.nextInt();

		if (indice < listCentralDeOcorrencias.size()) {
			return listCentralDeOcorrencias.get(indice);
		}

		return new NullCentralOcorrencia();
	}

	public CentralDeOcorrencia criarCentralOcorrencia(Scanner scanner) {
		System.out.println("Criando central de ocorrencia");

		System.out.println("Adicione um operador para a central");

		System.out.print("Digite o noem do usuario:");

		String nomeUsuario = scanner.next();

		System.out.print("Digite a senha:");

		String senha = scanner.next();

		Usuario usuario = new Usuario(nomeUsuario, senha);

		CentralDeOcorrencia centralDeOcorrencia = new CentralDeOcorrencia(usuario);

		listCentralDeOcorrencias.add(centralDeOcorrencia);

		return centralDeOcorrencia;
	}

	public Viatura criarViatura(Scanner scanner) {
		String nome, modelo;

		System.out.print("Digite o nome da viatura:");
		nome = scanner.next();

		System.out.println("Digite o modelo da viatura:");
		modelo = scanner.next();

		Viatura viatura = new Viatura(nome, modelo);

		listViatura.add(viatura);

		return viatura;

	}

	
	public void acompanharOcorrencia() {
		
	}
	
	
	public List<Ocorrencia> getListOcorrencias() {
		return listOcorrencias;
	}

	public List<Viatura> getListViatura() {
		return listViatura;
	}

	public List<CentralDeOcorrencia> getListCentralDeOcorrencias() {
		return listCentralDeOcorrencias;
	}
}
