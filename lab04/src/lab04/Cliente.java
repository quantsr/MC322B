package lab04;
import java.util.LinkedList;

public class Cliente {
	private String nome;
	private String endereco;
	private LinkedList <Veiculo> listaVeiculos;
	private double valorSeguro;
	
	
	//Constructor
	public Cliente() {
		this.nome = this.endereco = null;
		this.listaVeiculos = new LinkedList<Veiculo>();
	}
	public Cliente(String nome, String endereco, LinkedList <Veiculo> listaVeiculos) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = listaVeiculos;
	}
	
	
	//Getters
	public String getNome() {
		return this.nome;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public LinkedList<Veiculo> getListaVeiculo() {
		return this.listaVeiculos;
	}
	public double getValorSeguro() {
		return this.valorSeguro;
	}
	
	
	
	//Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.listaVeiculos.add(veiculo);
	}
	public void setValorSeguro(double value) {
		this.valorSeguro = value;
	}
	
	
	//toString overwrite
	public String toString() {
		return "\nNome do Cliente: "+this.nome +"\nEndereco do Cliente: "+this.endereco+"\nLista Veiculo do Cliente: \n"+this.listaVeiculos.toString()+"\nValor do Seguro: "+this.valorSeguro;
	}
	
	
	//calculaScore
	public double calculaScore() {
		return this.valorSeguro;
	}
	
		
}
