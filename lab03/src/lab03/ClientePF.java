package lab03;
import java.util.Date;
import java.util.LinkedList;

public class ClientePF extends Cliente {
	private final String cpf;
	private Date dataNascimento;
	
	//Constructors
	public ClientePF() {
		super();
		this.cpf = null;
		this.dataNascimento = null;
	}
	public ClientePF(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, LinkedList <Veiculo> listaVeiculos, String cpf, Date dataNascimento) {
		super(nome, endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	public ClientePF(String cpf, Date dataNascimento) {
		super();
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	//Getters
	public String getCPF() {
		return this.cpf;
	}
	public Date getDataNascimento() {
		return this.dataNascimento;
	}
	
	//Setters
	public void SetDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	
	//toString overwrite
	public String toString() {
		return "\n"+super.toString() + "\nCPF do Cliente: "+this.cpf+"\nData de Nascimento do Cliente :"+this.dataNascimento.toString();
	}

}
