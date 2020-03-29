package br.edu.pattertproject.fireman.Fireman.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Endereco;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullViatura;
import br.edu.pattertproject.fireman.Fireman.observer_pattern.Ocorrencia;
import br.edu.pattertproject.fireman.Fireman.observer_pattern.Viatura;

public class DaoOcorrencia {

	private List<Ocorrencia> listOcorrencias;
	private List<Viatura> listViatura;

	public DaoOcorrencia() {
		this.listOcorrencias = new ArrayList<Ocorrencia>();
		this.listViatura = new ArrayList<Viatura>();
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

	public List<Ocorrencia> getListOcorrencias() {
		return listOcorrencias;
	}

	public List<Viatura> getListViatura() {
		return listViatura;
	}

}
