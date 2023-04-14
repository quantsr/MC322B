package lab03;
import java.lang.Math; //Para gerar IDs aleatorio

public class Sinistro {
	private final int ID;
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	
	//Constructors
	public Sinistro() {
		this.ID = (int)(Math.random() *10000); //Criação de um número aleatório de 0 a 9999
		this.data = this.endereco = null;
		this.seguradora = new Seguradora();
		this.veiculo = new Veiculo();
		this.cliente = new Cliente();
	}
	public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		this.ID = (int)(Math.random() *10000); //Criação de um número aleatório de 0 a 9999
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}
	
	
	//Getters
	public int getId() {
		return this.ID;	
	}
	public String getData() {
		return this.data;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public Seguradora getSeguradora() {
		return this.seguradora;
	}
	public Veiculo getVeiculo() {
		return this.veiculo;
	}
	public Cliente getCliente() {
		return this.cliente;
	}
	
	//Setters
	public void setData(String data) {
		this.data = data;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	//toString overwrite
	public String toString() {
		return "ID de Sinistro : "+this.ID+"\nData do Sinistro: "+this.data+"\nEndereco do Sinistro : "+this.endereco+"\nSeguradora do Sinistro: "+this.seguradora.getNome()+"\nVeiculo do Sinistro: "+this.veiculo.toString()+"\nCliente do Sinistro: "+this.cliente.toString();
	}
}
