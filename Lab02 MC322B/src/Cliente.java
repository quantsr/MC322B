
public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	
	//Constructor
	public Cliente() {
		this.nome = this.cpf = this.dataNascimento = this.endereco = null;
		this.idade = 0;
	}
	public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	
	//Getters
	public String getNome() {
		return this.nome;
	}
	public String getCPF() {
		return this.cpf;
	}
	public String getDataNascimento() {
		return this.dataNascimento;
	}
	public int getIdade() {
		return this.idade;
	}
	public String getEndereco() {
		return this.endereco;
	}
	
	
	//Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String toString() {
		return "Nome: "+this.nome +"\ncpf: "+this.cpf+"\nData de Nascimento: "+this.dataNascimento+"\nIdade: "+this.idade+"\nEndereço: "+this.endereco;
	}
	
	
	//Validação de cpf atraves do calculo dos digitos verificadores
	public boolean validarCPF(String cpf) {
		//troca qualquer simbolo não-numérico por
		//espaço vazio, de acordo com a seguinte RegEx: "\\D+"
		cpf = cpf.replaceAll("\\D+", "");
		
		//verifica se tem a string possui 11 digitos
		if(cpf.length() != 11) {
			return false;
		}
		
		//verifica se todos os digitos são iguais
		String digitosIguais = cpf.replaceAll(String.valueOf(cpf.charAt(0)), "");
		/*supondo que todos os digitos são iguais, um replaceAll que troca o primeiro
		  caractere por uma string vazia tornaria a string digitosIguais em uma string
		  vazia*/
		if(digitosIguais.equals("")) {
			return false;
		}else {
			
			//calculo de primeiro digito verificador
			int soma, resto, numero, peso;
			char digito10, digito11;
			
			soma = 0;
			peso = 1;
			
			//soma cada digito dos numeros bases da string, multiplicado pelo peso
			for(int i = 0; i < 9; i++) {
				numero = (int)(cpf.charAt(i) - 48); //convertido da ASCII-Table
				soma = soma + (numero*peso);
				peso = peso + 1;
			}
			
			//calculando resto da divisao com 11 para o primeiro digito verificador
			resto = (soma % 11);
			
			//por convenção, se resto for 10, o digito será 0
			if(resto == 10) {
				digito10 ='0';
			}else {
				digito10 = (char)(resto + 48); //Int para char
			}
			
			//calculo de segundo digito verificador			
			soma = 0;
			peso = 0;
			for(int i = 0; i<10; i++) {
				numero = (int)(cpf.charAt(i) - 48);
				soma = soma + (numero*peso);
				peso = peso + 1;
			}
			
			//calculando resto da divisao com 11 para o segundo digito verificador
			resto = (soma % 11);
			if(resto == 10) {
				digito11 ='0';
			}else {
				digito11 = (char)(resto + 48); //Int para char
			}
			
			//valida digitos verificadores calculados com CPF informado
			if(cpf.charAt(9) == digito10 && cpf.charAt(10) == digito11) {
				return true;
			}else {
				return false;
			}			
		}
	}

}
