package entities;

import java.util.Objects;

public class ContaBancaria {
	
	private Usuario usuario;
	private Double saldo;
	
	public ContaBancaria(Usuario usuario) {
		this.usuario = usuario;
		saldo = 0.0;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String consultaSaldo() {  
		return usuario.getNome() + " seu saldo é: " + saldo;
	}
		
	public String realizaDeposito(Double valor) {
		if (valor < 0) return "O Depósito não pode ser realizado com valor negativo.";
		
		this.saldo += valor;
		return "Depósito realizado com sucesso!";
	}
	
	public String realizaSaque(Double valor) {
		if (valor < 0) return "O Saque não pode ser realizado com valor negativo.";
		if (valor > saldo) return "O Saque não pode exceder ao valor do saldo atual.";
		
		this.saldo -= valor;
		return "Saque de " + valor + " realizado com sucesso!";
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBancaria other = (ContaBancaria) obj;
		return Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return usuario + " -- " + "Saldo: " + saldo;
	}
	
}
