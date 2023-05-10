package lab04;
public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	
	
	//Constructor
	public Veiculo() {
		this.placa = this.marca = this.modelo = null;
		this.anoFabricacao = 0;
	}
	public Veiculo(String placa, String marca, String modelo, int anoFabricacao) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
	}
	
	
	//Getters
	public String getPlaca() {
		return this.placa;
	}
	public String getMarca() {
		return this.marca;
	}
	public String getModelo() {
		return this.modelo;
	}
	public int getAnoFabricacao() {
		return this.anoFabricacao;
	}
	
	
	//Setters
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	//toString overwrite
	public String toString() {
		return "Placa: "+this.placa +"\nMarca: "+this.marca+"\nModelo: "+this.modelo+"\nAno de Fabricacao: "+this.anoFabricacao;
	}
}
