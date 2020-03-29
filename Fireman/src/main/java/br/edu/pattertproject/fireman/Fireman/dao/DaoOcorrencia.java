package br.edu.pattertproject.fireman.Fireman.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Endereco;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullCentralOcorrencia;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullViatura;
import br.edu.pattertproject.fireman.Fireman.observer_pattern.CentralDeOcorrencia;
import br.edu.pattertproject.fireman.Fireman.observer_pattern.Ocorrencia;
import br.edu.pattertproject.fireman.Fireman.observer_pattern.Viatura;

public class DaoOcorrencia {

	private List<Viatura> listViatura;
	private List<CentralDeOcorrencia> listCentralDeOcorrencias;

	public DaoOcorrencia() {
		this.listViatura = new ArrayList<Viatura>();
		this.listCentralDeOcorrencias = new ArrayList<CentralDeOcorrencia>();
	}

	public void gerarOcorrencia(Scanner scanner) {
		String rua, bairro, cidade, numero;

		System.out.println("------ Gerando Ocorrência --------");

		System.out.print("Digite o a rua:");
		rua = scanner.next();

		System.out.print("Digite o bairro:");
		bairro = scanner.next();

		System.out.print("Digite a cidade:");
		cidade = scanner.next();

		System.out.print("Digite o numero:");
		numero = scanner.next();

		Endereco endereco = new Endereco(rua, bairro, cidade, numero);

		Viatura viatura = empenharViatura(scanner);

		Ocorrencia ocorrencia = new Ocorrencia(endereco);

		viatura.setOcorrencia(ocorrencia);

		updateViatura(viatura);

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

	public CentralDeOcorrencia adicionarObservadorCentralOcorrencia(Scanner scanner) {
		System.out.println("Adicionar central de ocorrencia para acompanhar a viatura");

		// Viatura viatura = empenharViatura(scanner);

		CentralDeOcorrencia centralDeOcorrencia = listarCentralOcorrencia(scanner);

		if (centralDeOcorrencia instanceof NullCentralOcorrencia) {
			centralDeOcorrencia = criarCentralOcorrencia(scanner);
		}

		return centralDeOcorrencia;

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

		CentralDeOcorrencia centralDeOcorrencia = new CentralDeOcorrencia();

		listCentralDeOcorrencias.add(centralDeOcorrencia);
		
		System.out.println("Central de ocorrencia registrada");
		
		return centralDeOcorrencia;
	}

	public Viatura criarViatura(Scanner scanner) {

		System.out.println("---- Criando viatura ----");
		String nome, modelo;

		System.out.print("Digite o nome da viatura:");
		nome = scanner.next();

		System.out.print("Digite o modelo da viatura:");
		modelo = scanner.next();

		Viatura viatura = new Viatura(nome, modelo);

		listViatura.add(viatura);

		return viatura;

	}

	public Viatura selecionarViatura(Scanner scanner) {

		System.out.println("Selecione a viatura para acompanhar a ocorrência:");

		int i = 0;

		for (Viatura auxViatura : listViatura) {
			System.out.println("Indice:" + i + ") " + auxViatura);
			i++;
		}

		System.out.print("Selecione a viatura pelo indice:");

		int indice = scanner.nextInt();

		if (indice < listViatura.size()) {
			return listViatura.get(indice);
		}

		return new NullViatura();
	}

	public void acompanharOcorrencia(Scanner scanner) throws InterruptedException {
		Viatura viatura = selecionarViatura(scanner);

		if (!(viatura instanceof NullViatura)) {

			List<String> estadosOcorrencia = new ArrayList<String>();
			estadosOcorrencia.add(viatura + " se deslocando para local da ocorrencia");
			estadosOcorrencia.add(viatura + " chegou no local de destino");
			estadosOcorrencia.add(viatura + " encaminhando vitima para hospital");
			estadosOcorrencia.add(viatura + " encerrou a ocorrência");

			for (String estados : estadosOcorrencia) {
				System.out.println("\n\n");
				viatura.notify(estados);
				System.out.println("\n\n");
				Thread.sleep(1000);
			}
		}

	}

	public void updateViatura(Viatura viatura) {

		int i = 0;
		int auxPosicao = 0;

		for (Viatura auxViatura : listViatura) {
			if (auxViatura.getNome().equals(viatura.getNome())) {
				auxPosicao = i;
				break;
			}
			i++;
		}
		CentralDeOcorrencia centralDeOcorrencia = criarCentralOcorrencia(new Scanner(System.in));

		viatura.getListObserver().add(centralDeOcorrencia);

		listViatura.remove(auxPosicao);

		listViatura.add(viatura);

	}

	public List<Viatura> getListViatura() {
		return listViatura;
	}

	public List<CentralDeOcorrencia> getListCentralDeOcorrencias() {
		return listCentralDeOcorrencias;
	}
}
