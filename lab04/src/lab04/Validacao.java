package lab04;

public class Validacao {
	//Validação de cpf
	public static boolean validarCPF(String cpf) {
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
		
	
	//validar CNPJ
	public static boolean validarCNPJ(String cnpj) {
		//troca qualquer simbolo não-numérico por
		//espaço vazio, de acordo com a seguinte RegEx: "\\D+"
		cnpj = cnpj.replaceAll("\\D+", "");
		
		//verifica se a string possui 14 digitos
		if(cnpj.length() != 14) {
			return false;
		}
		
		//verifica se todos os digitos são iguais
		String digitosIguais = cnpj.replaceAll(String.valueOf(cnpj.charAt(0)), "");
		/*supondo que todos os digitos são iguais, um replaceAll que troca o primeiro
			  caractere por uma string vazia tornaria a string digitosIguais em uma string
			  vazia*/
		if(digitosIguais.equals("")) {
			return false;
		}else {
			
			//calculo de primeiro digito verificador
			int soma, resto, numero, peso;
			char digito13, digito14;
			
			soma = 0;
			peso = 2;
			
			//soma cada digito dos numeros bases da string, multiplicado pelo peso
			for(int i = 11; i >= 0; i--) {
				numero = (int)(cnpj.charAt(i) - 48); //convertido da ASCII-Table
				soma = soma + (numero*peso);
				peso = peso + 1;
				if(peso == 10) {
					peso = 2;
				}
			}
			
			//calculando resto da divisao com 11 para o primeiro digito verificador
			resto = (soma % 11);
			
			
			//por convenção, se resto for 10, o digito será 0
			if(resto < 2) {
				digito13 ='0';
			}else {
				digito13 = (char)((11-resto) + 48); //Int para char
			
			}
			
			//calculo de segundo digito verificador			
			soma = 0;
			peso = 2;
			for(int i = 12; i>=0; i--) {
				numero = (int)(cnpj.charAt(i) - 48);
				soma = soma + (numero*peso);
				peso = peso + 1;
				if(peso==10) {
					peso = 2;
				}
			}
			
			
			//calculando resto da divisao com 11 para o segundo digito verificador
			resto = (soma % 11);
			
			if(resto < 2) {
				digito14 ='0';
			}else {
				digito14 = (char)((11-resto) + 48); //Int para char
			}		
			
			//valida digitos verificadores calculados com CPF informado
			if(cnpj.charAt(12) == digito13 && cnpj.charAt(13) == digito14) {
				return true;
			}else {
				return false;
			}			
		}
	}
	
	
	//validar nome
	public static boolean validarNome(String name) {
		name = name.replaceAll("\\s+", ""); //remove espaços em brancos atraves da RegEx: "\s+"
	    return name.matches("[a-zA-Z]+");   // assegura que strings vazias retornarão como False
	}
}
