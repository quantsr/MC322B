package lab04;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;



public class Main {
	//método para limpar a tela clearScreen
	public static void cs() {
		for(int i = 0; i< 40; i++) {
			System.out.println();
		}
	}
	
	//método para cadastro de cliente
	/*
	 * retorna um objeto da classe Cliente caso CPF/cnpj nao seja validado ou formato da data (dataFor) esteja errado
	 * lembrar de consertar input de qtd de funcionarios pelo metodo nextint do scan(flush error)
	 */
	
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
				}		
			}else {
				end = true;
			}
			
		}
	}

	public static void main(String[] args) {
		
		
		
		
		//Seguradora seg = new Seguradora("Umbrella Corporation", "555-9999-9999","umbrella@racooncitypd.com", "Racoon City");
		String input;
		Boolean end = false;
		Scanner scan = new Scanner(System.in);
		
		LinkedList<Cliente> clienteMain = new LinkedList<Cliente>();
		LinkedList<Seguradora> seguradoraMain = new LinkedList<Seguradora>();
		
		
		
		while(!end) {
			System.out.println("Bem Vindo ao Menu. Aperte 0 para sair do programa.");
			System.out.println("1 - Cadastros\n");
			System.out.println("2 - Listar\n");
			System.out.println("3 - Excluir\n");
			System.out.println("4 - Gerar Sinistro\n");
			System.out.println("5 - Transferir Seguro\n");
			System.out.println("6 - Calcular Receita\n");
			System.out.print("Input: ");
			
			int indiceOperacao = (Integer.parseInt(scan.nextLine().trim()) - 1);
			if (indiceOperacao == -1){
				indiceOperacao = 6; //SAIR
			}
			
			MenuOperacoes operacao = MenuOperacoes.values()[indiceOperacao];
			
			switch(operacao) {
			case CADASTRAR:
				//cadastro
				Main.cs();
				System.out.println("Menu de Cadastro.");
				System.out.println("1- Cadastrar ClientePF/PJ.");
				System.out.println("2- Cadastrar Veiculo.");
				System.out.println("3- Cadastrar Seguradora.");
				System.out.println("4- Voltar.");
				System.out.print("Input: ");
				switch( Integer.parseInt(scan.nextLine().trim()) ) {
					case 1:
						System.out.println("Cadastro de ClientePF/PJ");
						try {
							if(seguradoraMain.isEmpty()) {
								System.out.println("Nenhuma seguradora cadastrada ainda. Erro.");
								break;
							}
							System.out.println("Escolha o tipo de cliente a ser cadastrado:\n\"cpf\" para Cliente fisico\n\"cnpj\" para cliente juridico\n\"q\" para voltar ao menu anterior.");
							input = scan.nextLine().toLowerCase();
							String  data, cpf, cnpj, qtdeFuncionarios;
							SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
							
							switch(input) {
							case "cpf":
								Main.cs();
								System.out.println("Digite o cpf do cliente:");
								cpf = scan.nextLine();
								cpf = cpf.replaceAll("\\D+", "");
								
								if(!Validacao.validarCPF(cpf)) {
									System.out.println("CPF INVALIDO");
									break;
								}
								
								System.out.println("Digite a data de nascimento do cliente: \"dd/MM/yyyy\"");
								data = scan.nextLine();
								Date dataNascimento = dateFor.parse(data);
								
								ClientePF clienteCPF = new ClientePF(cpf, dataNascimento);
								System.out.println("Digite o nome do cliente:");
								clienteCPF.setNome(scan.nextLine());
								
								if(!Validacao.validarNome(clienteCPF.getNome())) {
									System.out.println("NOME INVALIDO");
									break;
								}
								
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
								//Cadastro de cliente na seguradora
								
								
									System.out.println("Em qual seguradora quer cadastrar cliente?:");
									for(Seguradora s : seguradoraMain) {
										System.out.println("-Seguradora numero '" +seguradoraMain.indexOf(s)+"' => "+s.getNome());
									}
									System.out.print("Input: ");
									seguradoraMain.get(Integer.parseInt(scan.nextLine().trim())).cadastrarCliente(clienteCPF);
								
								//cadastrado com sucesso
								
								break;
								
								
							case "cnpj":
								Main.cs();
								System.out.println("Digite o cnpj do cliente:");
								cnpj = scan.nextLine();
								cnpj = cnpj.replaceAll("\\D+", "");
								
								if(!Validacao.validarCNPJ(cnpj)) {
									System.out.println("CNPJ INVALIDO");
									break;
								}
								
								System.out.println("Digite a data de fundacao do cliente: \"dd/MM/yyyy\"");
								data = scan.nextLine();
								Date dataFundacao = dateFor.parse(data);
								System.out.println("Digite a quantidade de funcionarios:");
								qtdeFuncionarios = scan.nextLine();
								
								ClientePJ clienteCNPJ = new ClientePJ(cnpj, dataFundacao, Integer.parseInt(qtdeFuncionarios));
								System.out.println("Digite o nome do cliente:");
								clienteCNPJ.setNome(scan.nextLine());
								
								if(!Validacao.validarNome(clienteCNPJ.getNome())) {
									System.out.println("NOME INVALIDO");
									break;
								}
								
								System.out.println("Digite o endereco do cliente:");
								clienteCNPJ.setEndereco(scan.nextLine());
							
								//Cadastro de cliente na seguradora
								
								
									System.out.println("Em qual seguradora quer cadastrar cliente?:");
									for(Seguradora s : seguradoraMain) {
										System.out.println("-Seguradora n" +seguradoraMain.indexOf(s)+": "+s.getNome());
									}
									System.out.print("Input: ");
									seguradoraMain.get(Integer.parseInt(scan.nextLine().trim())).cadastrarCliente(clienteCNPJ);
								
								//cadastrado com sucesso
								break;
								
							case "q":
								Main.cs();
								
								break;
						
							default:
								Main.cs();
								System.out.println("Tipo de cliente invalido. Tente novamente.");
								
								break;
							}
						
						
					}catch (ParseException e) {e.printStackTrace();}

						
						break;
					case 2:
						if(seguradoraMain.isEmpty()) {
							System.out.println("Nenhuma seguradora cadastrada! Voltando ao menu principal.");
							break;
						}
						System.out.println("Cadastro de Veiculo");
						String placaCarro, marcaCarro, modeloCarro;
						int anoFabricacao;
						
						System.out.println("Digite a placa do carro a ser cadastrado:");
						System.out.print("Input: ");
						placaCarro = scan.nextLine();
						System.out.println("Digite a marca do carro a ser cadastrado:");
						System.out.print("Input: ");
						marcaCarro = scan.nextLine();
						System.out.println("Digite o modelo do carro a ser cadastrado:");
						System.out.print("Input: ");
						modeloCarro = scan.nextLine();
						System.out.println("Digite o ano de fabricacao do carro a ser cadastrado:");
						System.out.print("Input: ");
						anoFabricacao = Integer.parseInt(scan.nextLine());
						
						Veiculo veiculo = new Veiculo(placaCarro, marcaCarro, modeloCarro, anoFabricacao);
						
						System.out.println("Em qual seguradora deseja cadastrar o veiculo?");
						for(Seguradora s : seguradoraMain) {
							System.out.println("-Seguradora numero '"+seguradoraMain.indexOf(s)+"'=> "+s.getNome());
						}
						System.out.print("Input: ");
						int segIndex = Integer.parseInt(scan.nextLine().trim());
						
						if(seguradoraMain.get(segIndex).getListaClientes().isEmpty()) {
							System.out.println("Seguradora selecionada nao possui clientes cadastrados");
							break;
						}else {
							System.out.println("Em qual cliente deseja cadastrar o veiculo?");
							for(Cliente c : seguradoraMain.get(segIndex).getListaClientes()) {
								System.out.println("Cliente numero '"+ seguradoraMain.get(segIndex).getListaClientes().indexOf(c)+ "' => "+c.getNome());
							}
							System.out.print("Input: ");
							 seguradoraMain.get(segIndex).getListaClientes().get(Integer.parseInt(scan.nextLine().trim())).setVeiculo(veiculo);
						}
						
						
						
						break;
					case 3:				
						System.out.println("Cadastro de Seguradora.");
						System.out.println("Digite o nome da Seguradora a ser cadastrada: ");
						System.out.print("input: ");
						String nomeSeg = scan.nextLine();
						System.out.println("Digite o telefone da Seguradora a ser cadastrada: ");
						System.out.print("input: ");
						String foneSeg = scan.nextLine();
						System.out.println("Digite o email da Seguradora a ser cadastrada: ");
						System.out.print("input: ");
						String emailSeg = scan.nextLine();
						System.out.println("Digite o endereco da Seguradora a ser cadastrada: ");
						System.out.print("input: ");
						String enderecoSeg = scan.nextLine();
						Seguradora seg = new Seguradora(nomeSeg, foneSeg, emailSeg, enderecoSeg);
						seguradoraMain.add(seg);
						
						break;
					case 4:
						System.out.println("Voltando");
						break;
					default:
						System.out.println("Opcao Invalida. voltando ao menu principal");
						break;
					}
		
				
				break;
			case LISTAR:
				Main.cs();
				System.out.println("Menu de Listagem.");
				System.out.println("1- Listar ClientePF/PJ por seguradora.");
				System.out.println("2- Listar Sinistros por Seguradora.");
				System.out.println("3- Listar Sinistro por Cliente.");
				System.out.println("4- Listar veiculo por cliente.");
				System.out.println("5- Listar veiculo por Seguradora.");
				System.out.println("6- Voltar");
				System.out.print("Input: ");
				
				switch( Integer.parseInt(scan.nextLine().trim()) ) {
				case 1:
					System.out.println("Listando ClientePF/PJ por Seguradora");
					for(Seguradora s : seguradoraMain) {
						System.out.println("Seguradora numero '"+seguradoraMain.indexOf(s)+"': " + s.getNome());
					}
					System.out.println("Selecione o numero da seguradora a listar:");
					int segindex = Integer.parseInt(scan.nextLine().trim());
					System.out.println(seguradoraMain.get(segindex).getListaClientes());
					break;
					
				case 2:
					System.out.println("Listando Sinistros por Seguradora");
					for(Seguradora s : seguradoraMain) {
						System.out.println("Seguradora numero '"+seguradoraMain.indexOf(s)+"': " + s.getNome());
					}
					System.out.println("Selecione o numero da seguradora a listar:");
					int segindex2 = Integer.parseInt(scan.nextLine().trim());
					System.out.println(seguradoraMain.get(segindex2).getListaSinistros());
					break;
				case 3:
					System.out.println("Listando Sinistros por Cliente");
					System.out.println("Digite CPF ou CNPJ do Cliente:");
					System.out.print("Input: ");
					String cpf_cnpj = scan.nextLine();
					cpf_cnpj = cpf_cnpj.replaceAll("\\D+", "");
					LinkedList<Sinistro> sinistroQuery = new LinkedList<Sinistro>();
					if(cpf_cnpj.length() == 11) {
						for(Seguradora seg: seguradoraMain) {
							for(Sinistro sin : seg.getListaSinistros()) {
								if(((ClientePF) sin.getCliente()).getCPF().equals(cpf_cnpj)) {
									sinistroQuery.add(sin);
								}
							}
						}
						
					}else if(cpf_cnpj.length() == 14) {
						for(Seguradora seg: seguradoraMain) {
							for(Sinistro sin : seg.getListaSinistros()) {
								if(((ClientePJ) sin.getCliente()).getCNPJ().equals(cpf_cnpj)) {
									sinistroQuery.add(sin);
								}
							}
						}
					}
					
					System.out.println(sinistroQuery);			
						
					break;
				case 4:
					System.out.println("Listando veiculo por cliente");
					System.out.println("Digite CPF ou CNPJ do Cliente:");
					System.out.print("Input: ");
					String cpf_cnpj4 = scan.nextLine();
					cpf_cnpj4 = cpf_cnpj4.replaceAll("\\D+", "");
					
					if(cpf_cnpj4.length() == 11) {
						for(Seguradora seg: seguradoraMain) {
							for(Cliente c : seg.getListaClientes()) {
								if(((ClientePF) c).getCPF().equals(cpf_cnpj4)) {
									System.out.println(c.getListaVeiculo()); 
								}
							}
						}
						
					}else if(cpf_cnpj4.length() == 14) {
						for(Seguradora seg: seguradoraMain) {
							for(Cliente c : seg.getListaClientes()) {
								if(((ClientePJ) c).getCNPJ().equals(cpf_cnpj4)) {
									System.out.println(c.getListaVeiculo()); 
								}
							}
						}
					}
						
					break;
				case 5:
					System.out.println("Listando veiculos por Seguradora");
					LinkedList<Veiculo> veiculoQuery = new LinkedList<Veiculo>();
					
					for(Seguradora s : seguradoraMain) {
						System.out.println("Seguradora numero '"+seguradoraMain.indexOf(s)+"': " + s.getNome());
					}
					System.out.println("Selecione o numero da seguradora a listar:");
					int segindex5 = Integer.parseInt(scan.nextLine().trim());
					for(Cliente client : seguradoraMain.get(segindex5).getListaClientes()) {
						for(Veiculo v : client.getListaVeiculo()) {
							veiculoQuery.add(v);
						}
					}
					System.out.println(veiculoQuery);
					break;
				case 6:
					System.out.println("Voltando ao menu Principal.");
					Main.cs();
					break;
				default:
					System.out.println("Opcao Invalida. voltando ao menu principal");
					break;
					
				}
				
				break;
			case EXCLUIR:
				Main.cs();
				//excluir
				System.out.println("Menu de Exclusao.");
				System.out.println("1- Excluir Cliente");
				System.out.println("2- Excluir Veiculo");
				System.out.println("3- Excluir Sinistro");
				System.out.println("4- Voltar");
				System.out.print("Input: ");
				
				switch( Integer.parseInt(scan.nextLine().trim()) ) {
					case 1:
						System.out.println("Excluindo Cliente");
						//exclui cliente
						if(seguradoraMain.isEmpty()) {
							System.out.println("Nenhuma seguradora cadastrada! Voltando ao menu principal.");
							break;
						}
						
						System.out.println("Digite CPF ou CNPJ do Cliente:");
						System.out.print("Input: ");
						String cpf_cnpj = scan.nextLine();
						cpf_cnpj = cpf_cnpj.replaceAll("\\D+", "");
						
						for(Seguradora s : seguradoraMain) {
							if(s.removerCliente(cpf_cnpj)) {
								System.out.println("Removido com sucesso.");
							}else {
								System.out.println("Não foi possivel remover o cliente de cpf/cnpj "+cpf_cnpj+ "na seguradora "+s.getNome());
							}
						}						
						break;
					case 2:
						System.out.println("Excluindo Veiculo");
						//excluir veiculo
						if(seguradoraMain.isEmpty()) {
							System.out.println("Nenhuma seguradora cadastrada! Voltando ao menu principal.");
							break;
						}
						System.out.println("Digite CPF ou CNPJ do Cliente dono do veiculo:");
						System.out.print("Input: ");
						String cpf_cnpj2 = scan.nextLine();
						cpf_cnpj2 = cpf_cnpj2.replaceAll("\\D+", "");

						if(cpf_cnpj2.length() == 11) {
							for(Seguradora seg: seguradoraMain) {
								for(Cliente c : seg.getListaClientes()) {
									if(((ClientePF) c).getCPF().equals(cpf_cnpj2) && !(c.getListaVeiculo().isEmpty()) ) {
										
										for(Veiculo v : c.getListaVeiculo()) {
											System.out.println("Veiculo numero '"+c.getListaVeiculo().indexOf(v)+"': \n"+ v);
										}
										System.out.println("Selecione o numero do veiculo a excluir:");
										int segindex = Integer.parseInt(scan.nextLine().trim());
										c.getListaVeiculo().remove(segindex);										
									}
								}
							}
							
						}else if(cpf_cnpj2.length() == 14) {
							for(Seguradora seg: seguradoraMain) {
								for(Cliente c : seg.getListaClientes()) {
									if(((ClientePJ) c).getCNPJ().equals(cpf_cnpj2) && !(c.getListaVeiculo().isEmpty()) ) {
										
										for(Veiculo v : c.getListaVeiculo()) {
											System.out.println("Veiculo numero '"+c.getListaVeiculo().indexOf(v)+"': \n"+ v);
										}
										System.out.println("Selecione o numero do veiculo a excluir:");
										int segindex = Integer.parseInt(scan.nextLine().trim());
										c.getListaVeiculo().remove(segindex);										
									}
								}
							}
						}
						break;
					case 3:
						System.out.println("Excluindo Sinistro");
						//excluir sinistro
						if(seguradoraMain.isEmpty()) {
							System.out.println("Nenhuma seguradora cadastrada! Voltando ao menu principal.");
							break;
						}
						System.out.println("Digite o id do sinistro a ser removido: ");
						System.out.print("Input: ");
						int IDQuery = Integer.parseInt(scan.nextLine().trim());
						
						boolean flagSinistroFound = false;
						for(Seguradora s : seguradoraMain) {
							for(Sinistro sin: s.getListaSinistros()) {
								if(sin.getId() == IDQuery) {
									flagSinistroFound = true;
									int sinIndex = s.getListaSinistros().indexOf(sin);
									s.getListaSinistros().remove(sinIndex);
									
								}
							}
							if(flagSinistroFound) {
								System.out.println("Sinistro Removido com sucesso");
							}else {
								System.out.println("Sinistro de ID: "+IDQuery+ " não foi encontrado na seguradora: "+s.getNome());
							}
						}

						break;
					case 4: 
						System.out.println("Voltando ao menu anterior");
						break;
					default:
						System.out.println("Opcao Invalida. voltando ao menu principal");
						break;
				}
				break;
			case GERAR_SINISTRO:
				//gerar sinistro
				Main.cs();
				if(seguradoraMain.isEmpty()) {
					System.out.println("Nenhuma seguradora foi cadastrada ainda.");
				}else {
					for(Seguradora s : seguradoraMain) {
						System.out.println("Seguradora numero '"+seguradoraMain.indexOf(s)+"': " + s.getNome());
					}
					System.out.println("Selecione o numero da seguradora a registrar Sinistro:");
					
					int segindex = Integer.parseInt(scan.nextLine().trim());
					
					seguradoraMain.get(segindex).gerarSinistro();
				}
				break;
			case TRANSFERIR_SEGURO:
				//tranferencia de seguro
				Main.cs();
				System.out.println("Transferencia de Seguro.");
				System.out.println("Digite o cpf/cnpj do cliente dono do Seguro: ");
				System.out.print("Input: ");
				String cpf_cnpj = scan.nextLine();
				cpf_cnpj = cpf_cnpj.replaceAll("\\D+", "");
				
				System.out.println("Transferir seguro para qual cpf/cnpj?");
				System.out.print("Input: ");
				String cpf_cnpj2 = scan.nextLine();
				cpf_cnpj2 = cpf_cnpj2.replaceAll("\\D+", "");
				double valorSeguro;
				for(Seguradora s: seguradoraMain) {					
					for(Cliente c1 : s.getListaClientes()) {
						if(cpf_cnpj.length() == 11) {
							if(((ClientePF) c1).getCPF().equals(cpf_cnpj)) {
								valorSeguro = c1.getValorSeguro();
								
								//find client2
								for(Seguradora s2: seguradoraMain) {
									for(Cliente c2 : s2.getListaClientes()) {
										if(cpf_cnpj2.length() == 11) {
											
											if( ((ClientePF) c2).getCPF().equals(cpf_cnpj2)) {
												c2.setValorSeguro(c2.getValorSeguro() + valorSeguro);
												c1.setValorSeguro(0);
												System.out.println("Valor de Seguro transferido com sucesso.");
											}
										}else if(cpf_cnpj2.length() == 14) {
											if( ((ClientePJ) c2).getCNPJ().equals(cpf_cnpj2)) {
												c2.setValorSeguro(c2.getValorSeguro() + valorSeguro);
												c1.setValorSeguro(0);
												System.out.println("Valor de Seguro transferido com sucesso.");
											}
										}
									}
								}
							}
							
						}else if(cpf_cnpj.length() == 14) {
							if(((ClientePJ) c1).getCNPJ().equals(cpf_cnpj)) {
								valorSeguro = c1.getValorSeguro();
								
								//find client2
								for(Seguradora s2: seguradoraMain) {
									for(Cliente c2 : s2.getListaClientes()) {
										if(cpf_cnpj2.length() == 11) {
											
											if( ((ClientePF) c2).getCPF().equals(cpf_cnpj2)) {
												c2.setValorSeguro(c2.getValorSeguro() + valorSeguro);
												c1.setValorSeguro(0);
												System.out.println("Valor de Seguro transferido com sucesso.");
											}
										}else if(cpf_cnpj2.length() == 14) {
											if( ((ClientePJ) c2).getCNPJ().equals(cpf_cnpj2)) {
												c2.setValorSeguro(c2.getValorSeguro() + valorSeguro);
												c1.setValorSeguro(0);
												System.out.println("Valor de Seguro transferido com sucesso.");
											}
										}
									}
								}
							}
						}
					}
					
				}
				
				break;
			case CALCULAR_RECEITA_SEGURADORA:
				//calcular receita seguradora
				Main.cs();
				if(seguradoraMain.isEmpty()) {
					System.out.println("Nenhuma seguradora cadastrada no momento.");
					break;
				}
				for(Seguradora s: seguradoraMain) {
					s.calcularPrecoSeguroCliente();
					s.calcularReceita();
					System.out.println("Valores calculados.");
				}
				
				
				break;
			case SAIR:
				//sair
				Main.cs();
				System.out.println("Fechando Menu.");
				end = true;
				break;
			default:
				System.out.println("Opcao Invalida!");
				break;
				
			}
			
		}	
		
		
	}

}
