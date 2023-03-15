
public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	
	
	//Constructor
	public Veiculo() {
		this.placa = this.marca = this.modelo = null;
	}
	public Veiculo(String placa, String marca, String modelo) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
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
}
