package Lab02;
import java.lang.Math; //Para gerar IDs aleatorio

public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	
	
	//Constructors
	public Sinistro() {
		this.id = (int)(Math.random() *10000); //Criação de um número aleatório de 0 a 9999
		this.data = this.endereco = null;
	}
	public Sinistro(String data, String endereco) {
		this.id = (int)(Math.random() *10000); //Criação de um número aleatório de 0 a 9999
		this.data = data;
		this.endereco = endereco;
	}
	
	
	//Getters
	public int getId() {
		return this.id;	
	}
	public String getData() {
		return this.data;
	}
	public String getEndereco() {
		return this.endereco;
	}
	
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	
	
	//toString overwrite
	public String toString() {
		return "Data: "+this.data+"\nEndereco: "+this.endereco;
	}
}
