package lab03;
import java.util.LinkedList;   	//listaSinistros and listaClientes
import java.util.Scanner;		//User Input

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private LinkedList<Sinistro> listaSinistros;
	private LinkedList<Cliente> listaClientes;
	
	//Constructor
	public Seguradora() {
		this.nome = this.telefone = this.email = this.endereco = null;
		this.listaSinistros = new LinkedList<Sinistro>();
		this.listaClientes = new LinkedList<Cliente>();
	}
	public Seguradora ( String nome , String telefone , String email , String endereco, LinkedList<Sinistro> listaSinistros, LinkedList<Cliente> listaClientes) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = listaSinistros;
		this.listaClientes = listaClientes;		
	}
	public Seguradora ( String nome , String telefone , String email , String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;	
		this.listaSinistros = new LinkedList<Sinistro>();
		this.listaClientes = new LinkedList<Cliente>();
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
	public LinkedList<Sinistro> getListaSinistros(){
		return this.listaSinistros;
	}
	public LinkedList<Cliente> getListaClientes(){
		return this.listaClientes;
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
	public void setListaSinistros(LinkedList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	public void setListaClientes(LinkedList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	//toString overwrite
	public String toString() {
		return "Nome da Seguradora: "+this.nome +"\nTelefone da Seguradora: "+this.telefone+"\nEmail da Seguradora: "+this.email+"\nEndereco da Seguradora: "+this.endereco+"\nLista de Sinistros da Seguradora: \n"+this.listaSinistros.toString()+"\nLista de Clientes da Seguradora: \n"+this.listaClientes.toString();
	}
	
	/*
	 * Cadastro de cliente
	 * Identifica se o objeto é da classe ClientePF ou ClientePJ e retorna um booleano de acordo com a função
	 * validarCPF/validarCNPJ. Se True, adicionar a lista linkada de Clientes do objeto Seguradora.
	 */
	public Boolean cadastrarCliente(Cliente cliente) {
		if(cliente instanceof ClientePF) {
			if(((ClientePF) cliente).validarCPF(((ClientePF) cliente).getCPF())) {
				this.listaClientes.push(cliente);
				return true;	
			}
			else {
				System.out.println("CPF de " + cliente.getNome() + " invalido.");
				return false;
			}
		}else if(cliente instanceof ClientePJ) { 
			if(((ClientePJ) cliente).validarCNPJ(((ClientePJ) cliente).getCNPJ())){
				this.listaClientes.push(cliente);
				return true;
			}else {
				System.out.println("CNPJ de " + cliente.getNome() + " invalido.");
				return false;
			}
		}else {
			System.out.println("Nao foi possivel adicionar " + cliente.getNome() + " a seguradora. Atributo CPF/CNPJ nao encontrado.");
			return false;
		}
	}
	
	//remoção de cliente
	/*
	 * Retorna False se a lista ja estiver vazia. Se não estiver vazia, itera sobre a listaClientes em busca de
	 * um objeto Cliente de mesmo nome que o passado por parametro da função. Retorna True ou falso dependendo 
	 * do resultado
	 */
	public Boolean removerCliente(String cliente) {
		//lista vazia
		if(this.listaClientes.size() == 0) {
			System.out.println("Seguradora nao possui clientes cadastrados.");
			return false;
		}
		//lista não vazia
		else{
			String cpf_cnpj = cliente;
			cpf_cnpj = cpf_cnpj.replaceAll("\\D+", "");
			for(int i = 0; i<this.listaClientes.size(); i++) {
				//compara string de parametro com cpf/cnpj de cada objeto Cliente
				if(cpf_cnpj.length() == 11) {
					if(((ClientePF) this.listaClientes.get(i)).getCPF().replaceAll("\\D+", "").equals(cpf_cnpj)) {
						//salva cliente para remoção de sinistro
						Cliente clienteRemovido = this.listaClientes.get(i);
						this.listaClientes.remove(i);
						
						//procura sinistros atrelados ao cliente removido e remove eles
						for(int j = 0; j < this.listaSinistros.size(); j++) {
							if(this.listaSinistros.get(j).getCliente() == clienteRemovido) {
								this.listaSinistros.remove(j);
							}
						}
						return true;
					}
					
				}else if(cpf_cnpj.length() == 14) {
					if(((ClientePJ) this.listaClientes.get(i)).getCNPJ().replaceAll("\\D+", "").equals(cpf_cnpj)) {
						//salva cliente para remoção de sinistro
						Cliente clienteRemovido = this.listaClientes.get(i);
						this.listaClientes.remove(i);
						
						//procura sinistros atrelados ao cliente removido e remove eles
						for(int j = 0; j < this.listaSinistros.size(); j++) {
							if(this.listaSinistros.get(j).getCliente() == clienteRemovido) {
								this.listaSinistros.remove(j);
							}
						}
						return true;
					}
				}
			}
			//Cliente não encontrado
			System.out.println("Cliente de cpf/cnpj "+cliente+" nao encontrado.");
			return false;			
		}
	}
	
	//ListarCliente
	/*
	 * Retorna uma lista de clientes dependendo do parametro passado. Aceita somente "cpf" ou "cnpj" como possiveis 
	 * parametros. Caso não seja encontrado nenhum cliente do tipo desejado, ou a função utilizar um parametro não
	 * previsto, a função irá retornar uma lista vazia.
	 */
	public LinkedList<Cliente> listarClientes(String tipoCliente){
		LinkedList<Cliente> listaClienteTipo = new LinkedList<Cliente>();
			if(tipoCliente.toLowerCase().equals("cpf")) {
				tipoCliente = "ClientePF";
			}else if(tipoCliente.toLowerCase().equals("cnpj")) {
				tipoCliente = "ClientePJ";
			}else {
				System.out.println("Tipo de cliente nao definido(CPF/CNPJ).");
				return listaClienteTipo;
				
			}
			for(Cliente cliente : this.listaClientes) {
				//Note, '==' nao irá comparar o valor dos dois OBJETOS String. apenas os objetos em si. por isso o uso de equals()
				if(cliente.getClass().getSimpleName().equals(tipoCliente)) { 
					listaClienteTipo.push(cliente);
					
				}
			}
		return listaClienteTipo;
		
	}
	
	//gerar Sinistro
	/*
	 * Recebe Data, Endereço, CPF ou CNPJ do usuario. Itera sobre a lista de clientes da Seguradora dependendo se
	 * foi informado CPF ou CNPJ, checa se o objeto cliente da lsita possui uma lista de Veiculos cadastrado. Se
	 * sim, armazena um veiculo escolhido pelo usuario e utiliza todos os dados para gerar um objeto Sinistro.
	 * Retorna True quando todos os dados são recuperados(data, endereço, cpf/cnpj e veiculo) e False se o cliente
	 * possuir Veiculo cadastrado, ou o usuario escolher um indice errado para escolha do veiculo(Será alterado 
	 * futuramente para permitir erros de indice)
	 */
	public Boolean gerarSinistro() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Digite a data do sinistro: \n");
		String data = userInput.nextLine();
		System.out.println("Digite o endereco do sinistro: \n");
		String endereco = userInput.nextLine();
		System.out.println("Digite o CPF/CNPJ do cliente relacionado ao sinistro: \n");
		String cpf_cnpj = userInput.nextLine();
		
		//validando geração de Sinistro
		//Seguradora HAS Cliente && Cliente HAS Veiculo
		cpf_cnpj = cpf_cnpj.replaceAll("\\D+", "");
		if(cpf_cnpj.length() == 11) {
			System.out.println("CPF escolhido");
			if(this.getListaClientes().size() > 0) {
				LinkedList<Cliente> listaClienteCPF = this.listarClientes("cpf");
				//search
				for(Cliente cliente : listaClienteCPF) {
					if(((ClientePF) cliente).getCPF().replaceAll("\\D+", "").equals(cpf_cnpj)) {
						//checar se possui carro
						if(cliente.getListaVeiculo().isEmpty()) {
							System.out.println("Cliente nao possui carros registrados em seu nome.\n");
							//userInput.close();
							return false;
						}else {
							for(Veiculo veiculo : cliente.getListaVeiculo()) {
								System.out.println("Veiculo n: "+(cliente.getListaVeiculo().indexOf(veiculo)+1));
								System.out.println(veiculo + "\n");
							}
							System.out.println("Escolha qual carro esta anexado ao sinistro: \nVeiculo n?: ");
							int veiculoInput = userInput.nextInt();
							if(veiculoInput <= 0 || veiculoInput > cliente.getListaVeiculo().size()) {
								System.out.println("Indice de veiculo incorreto!");
								//userInput.close();
								return false;
							}else {
								Veiculo veiculo = cliente.getListaVeiculo().get(veiculoInput - 1);
								//gerando Sinistro
								Sinistro sinistro = new Sinistro(data, endereco, this, veiculo, cliente);
								System.out.println("Sinistro gerado\n");
								this.getListaSinistros().add(sinistro);
								//userInput.close();
								return true;
							}
						}	
					}	
				}
				System.out.println("Nao possui cliente com o CPF indicado! \n");
				//userInput.close();
				return false;
				
			}else {
				System.out.println("Seguradora nao possui clientes cadastrados");
				return false;
			}
		}else if(cpf_cnpj.length() == 14){
			System.out.println("CNPJ escolhido");
			if(this.getListaClientes().size() > 0) {
				LinkedList<Cliente> listaClienteCNPJ = this.listarClientes("cnpj");
				//search
				for(Cliente cliente : listaClienteCNPJ) {
					if(((ClientePJ) cliente).getCNPJ().replaceAll("\\D+", "").equals(cpf_cnpj)) {
						//checar se possui carro
						if(cliente.getListaVeiculo().isEmpty()) {
							System.out.println("Cliente nao possui carros registrados em seu nome.\n");
							//userInput.close();
							return false;
						}else {
							for(Veiculo veiculo : cliente.getListaVeiculo()) {
								System.out.println("Veiculo n: "+(cliente.getListaVeiculo().indexOf(veiculo)+1));
								System.out.println(veiculo + "\n");
							}
							System.out.println("Escolha qual carro esta anexado ao sinistro: \nVeiculo n?: ");
							int veiculoInput = userInput.nextInt();
							if(veiculoInput <= 0 || veiculoInput > cliente.getListaVeiculo().size()) {
								System.out.println("Indice de veiculo incorreto!");
								//userInput.close();
								return false;
							}else {
								Veiculo veiculo = cliente.getListaVeiculo().get(veiculoInput - 1);							
								//gerando Sinistro
								Sinistro sinistro = new Sinistro(data, endereco, this, veiculo, cliente);
								System.out.println("Sinistro gerado\n");
								this.getListaSinistros().add(sinistro);
								//userInput.close();
								return true;
							}
						}	
					}
				}
				System.out.println("Nao possui cliente com o CNPJ indicado! \n");
				//userInput.close();
				return false;
			}else {
				System.out.println("Seguradora nao possui clientes cadastrados");
				return false;
			}
		}else {
			System.out.println("Numero de CPF/CNPJ invalido!");
			//userInput.close();
			return false;
		}
		
	}
	
	//visualizar sinistro
	/*
	 * Exibi na tela o Sinistro cujo nome de cliente se iguala ao nome passado por parametro
	 */
	public Boolean visualizarSinistro(String cliente) {
		Boolean hasSinistro = false;
		//lista sinistro vazia
		if(this.listaSinistros.size() == 0) {
			return false;
		}
		else {
			for(int i = 0; i< this.listaSinistros.size(); i++) {
				if(this.listaSinistros.get(i).getCliente().getNome().toLowerCase().equals(cliente.toLowerCase())) {
					System.out.println(this.listaSinistros.get(i));
					hasSinistro = true;
				}
			}
			
			return hasSinistro;
		}
	}
	
	//listar sinistros
	public LinkedList<Sinistro> listarSinistros(){
		return this.listaSinistros;
	}
	
}
