package lab03;
import java.util.Date;
import java.util.LinkedList;

public class Cliente {
	private String nome;
	private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private LinkedList <Veiculo> listaVeiculos;
	
	
	//Constructor
	public Cliente() {
		this.nome = this.endereco = this.educacao = this.genero = this.classeEconomica= null;
		this.dataLicenca = new Date();
		this.listaVeiculos = new LinkedList<Veiculo>();
	}
	public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, LinkedList <Veiculo> listaVeiculos) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.listaVeiculos = listaVeiculos;
	}
	
	
	//Getters
	public String getNome() {
		return this.nome;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public Date getdataLicenca() {
		return this.dataLicenca;
	}
	public String getEducacao() {
		return this.educacao;
	}
	public String getGenero() {
		return this.genero;
	}
	public String getClasseEconomica() {
		return this.classeEconomica;
	}
	public LinkedList<Veiculo> getListaVeiculo() {
		return this.listaVeiculos;
	}
	
	
	
	//Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	public void setListaVeiculo(LinkedList<Veiculo> listaVeiculo) {
		this.listaVeiculos = listaVeiculo;
	}
	
	
	//toString overwrite
	public String toString() {
		return "\nNome do Cliente: "+this.nome +"\nEndereco do Cliente: "+this.endereco+"\nData de Licenca do Cliente: "+this.dataLicenca.toString()+"\nEducacao do Cliente: "+this.educacao+ "\nGenero do Cliente: "+this.genero+"\nClasse Economica do Cliente: "+this.classeEconomica+"\nLista Veiculo do Cliente: \n"+this.listaVeiculos.toString();
	}
	
	
		
}
