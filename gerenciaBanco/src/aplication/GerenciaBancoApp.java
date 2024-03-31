package aplication;

import java.util.Locale;
import java.util.Scanner;

import entities.ContaBancaria;
import entities.Usuario;

public class GerenciaBancoApp {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		Scanner scan = new Scanner(System.in);
		int opcoes;
		
		System.out.println("--- SISTEMA BANCÁRIO ---");
		
		System.out.print("Digite seu nome: ");
		String nome = scan.nextLine();
		
		System.out.print("Digite seu sobrenome: ");
		String sobrenome = scan.nextLine();
		
		System.out.print("Digite seu cpf: ");
		String cpf = scan.next();
		
		String cpfValido = cpf.replaceAll("[^0-9]", "");
		
		Usuario usuario = new Usuario(nome, sobrenome, cpfValido);
		ContaBancaria conta = new ContaBancaria(usuario);
		
		System.out.println("-------------------");
		while(true) {
			System.out.println("Qual das Opções abaixo você quer realizar: ");
			System.out.println("Consultar Saldo:   Digite [1]");
			System.out.println("Realizar Depósito: Digite [2]");
			System.out.println("Realizar Saque:    Digite [3]");
			System.out.println("Sair do Sistema:   Digite [4]");
			System.out.print("Digite: ");
			opcoes = scan.nextInt();
			
			if(opcoes == 1) System.out.println(conta.consultaSaldo());
			
			if(opcoes == 2) {
				System.out.print("Valor do Depósito: ");
				double valor = scan.nextDouble();
				System.out.println(conta.realizaDeposito(valor));
			}
			if(opcoes == 3) {
				System.out.print("Valor do Saque: ");
				double valor = scan.nextDouble();
				System.out.println(conta.realizaSaque(valor));
			}
			
			if(opcoes == 4) break; 
			
			System.out.println(); 
		}
		
		System.out.println("--- FIM DO SISTEMA BANCÁRIO ---");
		scan.close();
	}

}
