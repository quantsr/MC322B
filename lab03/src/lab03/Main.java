package lab03;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;



public class Main {
	//método para limpar a tela
	public static void cs() {
		for(int i = 0; i< 40; i++) {
			System.out.println();
		}
	}
	
	//método para cadastro de cliente
	/*
	 * retorna um objeto da classe Cliente caso CPF/cnpj nao seja validado ou formato da data (dataFor) esteja errado
	 */
	public static Cliente cadastroCliente(Scanner scan) {
		Cliente clienteVazio = new Cliente();
		try {
			
					
				System.out.println("Escolha o tipo de cliente a ser cadastrado:\n\"cpf\" para Cliente fisico\n\"cnpj\" para cliente juridico\n\"q\" para voltar ao menu anterior.");
				String input = scan.nextLine().toLowerCase();
				String  data, cpf, cnpj;
				Boolean cadastroVeiculo = true;
				LinkedList<Veiculo> listaCarros = new LinkedList<Veiculo>();

				SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
				
				switch(input) {
				case "cpf":
					Main.cs();
					System.out.println("Digite o cpf do cliente:");
					cpf = scan.nextLine();
					System.out.println("Digite a data de nascimento do cliente: \"dd/MM/yyyy\"");
					data = scan.nextLine();
					Date dataNascimento = dateFor.parse(data);
					
					ClientePF clienteCPF = new ClientePF(cpf, dataNascimento);
					System.out.println("Digite o nome do cliente:");
					clienteCPF.setNome(scan.nextLine());
					System.out.println("Digite o endereco do cliente:");
					clienteCPF.setEndereco(scan.nextLine());
					System.out.println("Digite a data de licenca do cliente: \"dd/MM/yyyy\"");
					data = scan.nextLine();
					Date dataLicenca = dateFor.parse(data);
					clienteCPF.setDataLicenca(dataLicenca);
					System.out.println("Digite o grau de educacao do cliente:");
					clienteCPF.setEducacao(scan.nextLine());
					System.out.println("Digite o genero do cliente:");
					clienteCPF.setGenero(scan.nextLine());
					System.out.println("Digite a classe economica do cliente:");
					clienteCPF.setClasseEconomica(scan.nextLine());
					//cadastro de veiculo
					cadastroVeiculo = true;
					while(cadastroVeiculo) {
						System.out.println("Deseja adicionar um veiculo para o cliente "+clienteCPF.getNome()+"? Y/N");
						input = scan.nextLine().toLowerCase();
						if(input.equals("y")) {
							Veiculo veiculo = new Veiculo();
							System.out.println("Digite numero da placa do veiculo: ");
							veiculo.setPlaca(scan.nextLine());
							System.out.println("Digite a marca do veiculo: ");
							veiculo.setMarca(scan.nextLine());
							System.out.println("Digite o modelo do veiculo: ");
							veiculo.setModelo(scan.nextLine());
							System.out.println("Digite o ano de fabricacao do veiculo: ");
							veiculo.setAnoFabricacao(Integer.parseInt(scan.nextLine()));
							
							listaCarros.add(veiculo);
							
							clienteCPF.setListaVeiculo(listaCarros);
							System.out.println("Veiculo cadastrado.");
							
						}else if(input.equals("n")) {
							cadastroVeiculo = false;
						}
					}
					return clienteCPF;
					
					
				case "cnpj":
					Main.cs();
					System.out.println("Digite o cnpj do cliente:");
					cnpj = scan.nextLine();
					System.out.println("Digite a data de fundacao do cliente: \"dd/MM/yyyy\"");
					data = scan.nextLine();
					Date dataFundacao = dateFor.parse(data);
					
					ClientePJ clienteCNPJ = new ClientePJ(cnpj, dataFundacao);
					System.out.println("Digite o nome do cliente:");
					clienteCNPJ.setNome(scan.nextLine());
					System.out.println("Digite o endereco do cliente:");
					clienteCNPJ.setEndereco(scan.nextLine());
				
					//cadastro de veiculo
					cadastroVeiculo = true;
					while(cadastroVeiculo) {
						System.out.println("Deseja adicionar um veiculo para o cliente "+clienteCNPJ.getNome()+"? Y/N");
						input = scan.nextLine().toLowerCase();
						if(input.equals("y")) {
							Veiculo veiculo = new Veiculo();
							System.out.println("Digite numero da placa do veiculo: ");
							veiculo.setPlaca(scan.nextLine());
							System.out.println("Digite a marca do veiculo: ");
							veiculo.setMarca(scan.nextLine());
							System.out.println("Digite o modelo do veiculo: ");
							veiculo.setModelo(scan.nextLine());
							System.out.println("Digite o ano de fabricacao do veiculo: ");
							veiculo.setAnoFabricacao(Integer.parseInt(scan.nextLine()));
							listaCarros.add(veiculo);
							
							System.out.println("Veiculo cadastrado.");
							
						}else if(input.equals("n")) {
							cadastroVeiculo = false;
						}
					}
					clienteCNPJ.setListaVeiculo(listaCarros);
					return clienteCNPJ;
					
				case "q":
					Main.cs();
					
					break;
			
				default:
					Main.cs();
					System.out.println("Tipo de cliente invalido. Tente novamente.");
					
					break;
				}
			
			
		}catch (ParseException e) {e.printStackTrace();}
		
		return clienteVazio;
	}
	
	//método para remoção de cliente
	public static void removercliente(Scanner scan, Seguradora seguradora) {
		Boolean end = false;
		while(!end) {
			System.out.println(seguradora);
			System.out.println("Digite o cpf/cnpj do cliente a ser removido. Digite 0 para voltar ao menu anterior.");
			String input = scan.nextLine();
			
			if(!input.equals("0")) {
				if(seguradora.removerCliente(input)) {
					System.out.println("Cliente removido com sucesso");
				}else{
					System.out.println("Falha ao remover Cliente. Porfavor certifique-se de que digitou o cpf/cnpj corretamente.");	
				}
			}else {
				end = true;
			}
			
		}
	}

	public static void main(String[] args) {
		
		/*
		A MAIN PRECISA SUPRIR OS SEGUINTES ITEMS DE ACORDO COM O PDF:
		 * 
	    OK	• Cadastrar e remover pelo menos 1 Cliente (ClientePF ou ClientePJ);
	    	(MPETODO "CADASTROCLIENTE" DA MAIN)
		OK	• Chamar os métodos validarCPF(cpf: String) (ClientePF) e validarCNPJ(cnpj: String) (ClientePJ);
			(CHAMADOS DURANTE O METODO "CADASTRARCLIENTE" DA SEGURADORA)
		OK	• Adicionar pelo menos 1 Veiculo em cada Cliente instanciado;
			(METODO PARA CADASTRAR CLIENTES PERMITE ANEXAR QUANTOS VEÍCULOS O USUARIO DESEJAR)
		OK	• Instanciar pelo menos 1 objeto de Seguradora;
			(LINHA 189)
		OK	• Cadastrar pelo menos 2 clientes em Seguradora (sem remover), sendo 1 do tipo ClientePF e 1 do tipo
			ClientePJ;
			(CASE 1, EM TESE, PODE SER REPETIDO QUANTAS VEZES O USUARIO DESEJAR)
		OK	• Gerar pelo menos 1 Sinistro;
			(CASE 3)
		OK	• Chamar o método toString() de cada classe;
			(INDIRETAMENTE ATENDIDO AO CHAMAR MÉTODO TOSTRING DA CLASSE SEGURADORA. TAL MÉTODO POR SUA VEZ CHAMA O 
			MÉTODO TOSTRING DE CLIENTE, CLIENTEPF OU CLIENTEPJ, VEICULO E SINISTRO)
		OK	• Chamar os métodos listarClientes (tipoCliente: String), visualizarSinistro(cliente: String) e listarSi-
nistros() da classe Seguradora;
			(CASE 4, 5 E 6 RESPECTIVAMENTES)
		 */
		Seguradora seg = new Seguradora("Umbrella Corporation", "555-9999-9999","umbrella@racooncitypd.com", "Racoon City");
		String input = "";
		Boolean end = false;
		Scanner scan = new Scanner(System.in);
		
		while(!end) {
			System.out.println("CADASTRO DE CLIENTES. Aperte Q para sair do programa.");
			System.out.println("1 - Cadastro de Cliente\n");
			System.out.println("2 - Remocao de Cliente\n");
			System.out.println("3 - Cadastrar Sinistro\n");
			System.out.println("4 - Listar Clientes\n");
			System.out.println("5 - Visualizar Sinistro\n");
			System.out.println("6 - Listar todos os Sinistros\n");
			System.out.print("Input: ");
			input = scan.nextLine().toLowerCase();
			switch(input) {
			case "1":
				Main.cs();
				System.out.println("Cadastro de Cliente");
				Cliente cliente = new Cliente();
				cliente = Main.cadastroCliente(scan);
				if(!cliente.getClass().getSimpleName().equals("Cliente")) {
					if(seg.cadastrarCliente(cliente)) { //validarCPF/validarCNPJ
						System.out.println("Cliente cadastrado com sucesso.");
					}else {
						System.out.println("Falha ao cadastrar cliente.");
					}
				}
				
				break;
			case "2":
				Main.cs();
				System.out.println("Remocao de Cliente");
				Main.removercliente(scan, seg);
				
				break;
			case "3":
				Main.cs();
				seg.gerarSinistro();
				break;
			case "4":
				Main.cs();
				System.out.println("Digite que tipo de clientes deseja listar: cpf/cnpj");
				input = scan.nextLine();
				System.out.println(seg.listarClientes(input));
				break;
			case "5":
				System.out.println("Digite o nome do cliente relacionado aos sinistros: ");
				input = scan.nextLine();
				if(!seg.visualizarSinistro(input)) {
					System.out.println("O cliente nao possui sinistros.");
				}
				break;
			case "6":
				System.out.println(seg.listarSinistros());
				break;
			case "q":
				Main.cs();
				System.out.println("Exiting.");
				end = true;
				break;
			default:
				Main.cs();
				System.out.println("No match.");
				break;
			}
		}
		
		System.out.println("Fim do programa.");
		
		
		
	}

}
