package Lab02;

public class Main {

	public static void main(String[] args) {
		//instanciando objeto de Aluno
		Cliente aluno = new Cliente();
		//settando valores com funçao Setters de Aluno
		aluno.setDataNascimento("10/12/1993");
		aluno.setEndereco("Campinas");
		aluno.setIdade(29);
		aluno.setNome("Max");
		aluno.setCPF("06988005404");
		//retornando funçao toString de Aluno
		System.out.println(aluno);
		//retornando funçao validarCPF de Aluno
		System.out.println(aluno.validarCPF("06988005404"));
		
		//função setters de Seguradora análogas as funções setters de Aluno.Portanto, settando valores atraves de Constructor
		//instanciando objeto de Seguradora
		Seguradora seguradora = new Seguradora("Seguradora A", "xx xxxx - xxxx", "xxx@xxxx.com", "Campinas");
		//retornando função toString de Seguradora
		System.out.println(seguradora);
		
		//instanciando objeto de Veiculo
		Veiculo veiculo = new Veiculo("YYY-9999", "Marca A", "Moddelo A");
		//retornando função toString de Veiculo
		System.out.println(veiculo);
		
		//instanciando objeto de Sinistro
		Sinistro sinistro = new Sinistro("23/03/2023", "Campinas");
		//retornando função toString de Sinistro
		System.out.println(sinistro);
	}

}
