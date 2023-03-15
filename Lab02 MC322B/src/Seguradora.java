
public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	
	//Constructors Start
	public Seguradora() {
		this.nome = this.telefone = this.email = this.endereco = null;
	}
	public Seguradora ( String nome , String telefone , String email , String endereco ) {
		this.nome = nome ;
		this.telefone = telefone ;
		this.email = email ;
		this.endereco = endereco ;
	}
	
	
	//Getters
	public String getNome() {
		return this.nome;
	}
	public String getTelefone() {
		return this.telefone;
	}
	public String getEmail() {
		return this.email;
	}
	public String getEndereco() {
		return this.endereco;
	}
	
	
	//setters
	public void setName(String nome) {
		this.nome = nome;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
