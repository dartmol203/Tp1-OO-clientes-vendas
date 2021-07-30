package Tp1;

// impotaçao das bibliotecas
import java.util.Scanner;
import java.lang.Double;


public class Tp1 {
    //declaraçao do scanner de forma a não ser necessaria a declaração a cada metodo.
    static Scanner ler = new Scanner(System.in);
    
    public static void main(String[] args){
        //declaraçao de variaveis e vetores
        int opcaoMenu;
        int quantidadeClientes = 0, quantidadeProdutos = 0, quantidadeVendas = 0;
        String[] clientes, endereco, telefone, nomeProduto, descricaoProduto, vendas;
        double[] valorCompra, porcentagemLucro, valorVenda;
        int[] quantidadeEstoque;
        
        //vetores relacionados aos clientes
        clientes = new String[120];
        endereco = new String[120];
        telefone = new String[120];

        //vetores relacionados aos produtos
        nomeProduto = new String[150];
        descricaoProduto = new String[150];
        valorCompra = new double[150];
        porcentagemLucro = new double[150];
        quantidadeEstoque = new int[150];

        //vetores relacionados as vendas
        vendas = new String[150];
        valorVenda = new double[150];

        // pre cadastro de 10 clientes
        quantidadeClientes = cadastroInicialClientes(quantidadeClientes, clientes, endereco, telefone );

        //pre cadastro de 10 produtos
        quantidadeProdutos = cadastroInicialProdutos(quantidadeProdutos, quantidadeEstoque, porcentagemLucro, valorCompra, descricaoProduto, nomeProduto);
        
        //início do programa
        System.out.println("bom dia! meu objetivo é automatizar o controle de clientes e produtos! possuo as seguintes funções:");
        do{
            menu();
            opcaoMenu = ler.nextInt();
            ler.nextLine(); // para limpar buffer de memoria
            switch(opcaoMenu){
                //diretorio de rotas dentro do codigo
                case 1 :
                    quantidadeClientes = cadastroCliente(quantidadeClientes, clientes, endereco, telefone);
                    break;

                case 2 :
                    buscaCliente(quantidadeClientes, clientes, endereco, telefone);
                    break;
                
                case 3 :
                    quantidadeProdutos = cadastroProdutos(quantidadeProdutos, nomeProduto, descricaoProduto, valorCompra, porcentagemLucro, quantidadeEstoque);
                    break;

                case 4 :
                    buscaProdutos(quantidadeProdutos, nomeProduto, descricaoProduto, valorCompra, porcentagemLucro, quantidadeEstoque);
                    break;

                case 5 :
                    quantidadeVendas = cadastroVendas(quantidadeClientes, clientes, quantidadeProdutos, nomeProduto, valorCompra, porcentagemLucro, quantidadeEstoque, quantidadeVendas, vendas, valorVenda);
                    break;

                case 6 :
                    estoqueProduto(quantidadeProdutos, nomeProduto, quantidadeEstoque);
                    break;

                case 7 :
                    System.out.println("obrigado! até mais!");
                    break;

                default:
                    System.out.println("opção invalida, por favor escolha outra:");

            }
        }while(opcaoMenu !=7);
        
    }

    //metodo para cadastro de 10 clientes ficticios
    public static int cadastroInicialClientes(int quantidadeClientes, String clientes[], String endereco[], String telefone[]){
        for(int i = 0 ; i <10; i++){
            clientes[i] = "cliente" + (i+1);
            endereco[i] = "endereco" + (i+1);
            telefone[i] = "telefone" + (i+1);
            quantidadeClientes++;
        }
        return quantidadeClientes;
    }

    //metodo para cadastro de 10 produtos 
    public static int cadastroInicialProdutos(int quantidadeProdutos, int quantidadeEstoque[], double porcentagemLucro[], double valorCompra[], String descricaoProduto[], String nomeProduto[] ){
        for(int i = 0; i<10; i++ ){
            nomeProduto[i] = "produto"+(i+1);
            descricaoProduto[i] = "descrição"+ (i+1);
            valorCompra[i] = 10*(i+1);
            porcentagemLucro[i] = 10*(i+1);
            quantidadeEstoque[i] = i+1;
            quantidadeProdutos++;
        }
        return quantidadeProdutos;
    }

    // mostra as opçoes do menu para o usuario
    public static void menu(){ 
        System.out.println("----------------------------------");
        System.out.println("1 - cadastro de novo cliente");
        System.out.println("2 - busca por cliente");
        System.out.println("3 - cadastro de novo produto");
        System.out.println("4 - busca por produto");
        System.out.println("5 - cadastro de venda");
        System.out.println("6 - mostrar produtos em estoque");
        System.out.println("7 - sair");
        System.out.println("por favor digite a opção desejada:");
        System.out.println("----------------------------------");
    }
    
    // metodo usado para cadastrar um cliente
    public static int cadastroCliente(int quantidadeClientes, String clientes[], String endereco[], String telefone[]){
        
        // declaração de variaveis
        int novosClientes;
        
        System.out.println("você gostaria de cadastrar quantos clientes?");
        novosClientes = ler.nextInt();
        ler.nextLine();
        while(novosClientes<1){ // validaçao da quantidade de clientes a serem cadastrados
            System.out.println("a quantidade de clientes deve ser um numero positivo maior que 0!");
            System.out.println("digite um valor valido:");
            novosClientes = ler.nextInt();
            ler.nextLine();
        }
        
        for(int i = quantidadeClientes; i < quantidadeClientes + novosClientes; i++ ){
            
            System.out.println("por favor, digite o nome do cliente:");
            clientes[i] = ler.nextLine();
            System.out.println("por favor, digite o endereço do cliente:");
            endereco[i] = ler.nextLine();
            System.out.println("por favor, digite o telefone do cliente:");
            telefone[i] = ler.nextLine();
        }
        
        quantidadeClientes += novosClientes;
        System.out.println("clientes cadastrados!");

        return quantidadeClientes;
    }

    // metodo usado para buscar o cadastro de um cliente e poder alterar infomações desse
    public static void buscaCliente(int quantidadeClientes, String clientes[], String endereco[], String telefone[]){
        
        // declaração de variaveis
        String buscaNome;
        boolean clienteEncontrado = false;
        int posCliente = 0, querAtualizar;


        System.out.println("por favor, digite o nome do cliente que deseja encontrar:");
        buscaNome = ler.nextLine();
        System.out.println("buscando cliente " + buscaNome + " ...");

        for(int i = 0; i < quantidadeClientes; i++){
            if(clientes[i].equalsIgnoreCase(buscaNome)){
                
                posCliente = i;
                clienteEncontrado = true;
                break;
            } 
        }

        if (clienteEncontrado){
            
            System.out.println("cliente encontrado! \nele possui os seguintes dados:");
            System.out.println("nome: " + clientes[posCliente]);
            System.out.println("endereço: " + endereco[posCliente] );
            System.out.println("telefone: " + telefone[posCliente] );
            System.out.println("gostaria de alterar as informações dele? \n1- para sim \n2- para não");
            querAtualizar = ler.nextInt();
            ler.nextLine();

            if(querAtualizar==1){
                
                System.out.println("por favor, digite o novo nome do cliente:");
                clientes[posCliente] = ler.nextLine();
                
                System.out.println("por favor, digite o novo endereço do cliente:");
                endereco[posCliente] = ler.nextLine();
                
                System.out.println("por favor, digite o novo telefone do cliente:");
                telefone[posCliente] = ler.nextLine();

                System.out.println("esses são os novos dados desse cliente:");
                System.out.println("nome: " + clientes[posCliente]);
                System.out.println("endereço: " + endereco[posCliente] );
                System.out.println("telefone: " + telefone[posCliente] );
            
            }else{
                System.out.println("tudo bem, vamos continuar!");
            }
        } else{            
            System.out.println("Cliente não encontrado!");
        }

    }
   
    // metodo usado para cadastrar um produto e suas caracteristicas
    public static int cadastroProdutos(int quantidadeProdutos, String nomeProduto[], String descricaoProduto[], double valorCompra[], double porcentagemLucro[], int quantidadeEstoque[]){
        
        // declaração de variaveis
        int novosProdutos;
        
        System.out.println("gostaria de cadastrar quantos produtos?");
        novosProdutos = ler.nextInt();
        ler.nextLine();
        while(novosProdutos<1){ // validaçao da quantidade de produtos a serem cadastrados
            System.out.println("a quantidade de produtos deve ser um numero positivo maior que 0!");
            System.out.println("digite um valor valido:");
            novosProdutos =  ler.nextInt();
            ler.nextLine();
        }

        for(int i = quantidadeProdutos; i < quantidadeProdutos + novosProdutos; i++){
            
            System.out.println("por favor, digite o nome do produto:");
            nomeProduto[i] = ler.nextLine();
            System.out.println("por favor, digite a descrição do produto:");
            descricaoProduto[i] = ler.nextLine();
            System.out.println("por favor, digite o valor de compra do produto:");
            valorCompra[i] = ler.nextDouble();
            while(Double.compare(valorCompra[i], 0) < 1){ //validaçao do valor da compra do produto

                System.out.println("o valor de compra deve ser um numero positivo maior que 0!");
                System.out.println("digite um valor válido:");
                valorCompra[i] = ler.nextDouble();
            }

            System.out.println("por favor, digite a porcentagem de lucro:");
            porcentagemLucro[i] = ler.nextDouble();
            System.out.println("por favor, digite a quantidade em estoque:");
            quantidadeEstoque[i] = ler.nextInt();
            ler.nextLine();
            while(quantidadeEstoque[i] < 1){ //validaçao do valor disponivel em estoque
                System.out.println("a quantidade em estoque deve ser um numero positivo maior que zero! \ndigite outro valor:");
                quantidadeEstoque[i] = ler.nextInt();
                ler.nextLine();
            }
        }

        quantidadeProdutos += novosProdutos;
        System.out.println("produtos cadastrados!");
        
        return quantidadeProdutos;
    }

    // metodo usado para buscar o cadastro de um produto e poder alterar infomações desse
    public static void buscaProdutos(int quantidadeProdutos, String nomeProduto[], String descricaoProduto[], double valorCompra[], double porcentagemLucro[], int quantidadeEstoque[]){
        
        // declaração de variaveis
        String buscaProduto;
        boolean produtoEncontrado =  false;
        int posProduto = 0, querAtualizar;

        System.out.println("por favor digite o nome do produto que deseja pesquisar:");
        buscaProduto = ler.nextLine();
        System.out.println("buscando produto " + buscaProduto + " ...");

        for(int i = 0; i<quantidadeProdutos;i++){
            if(nomeProduto[i].equalsIgnoreCase(buscaProduto)){
                produtoEncontrado = true;
                posProduto = i;
                break;
            }
        }

        if(produtoEncontrado){
            System.out.println("produto encontrado!");
            System.out.println("nome do produto: "+ nomeProduto[posProduto]);
            System.out.println("descrição do produto: "+ descricaoProduto[posProduto]);
            System.out.println("valor de compra: "+ valorCompra[posProduto]);
            System.out.println("porcentagem de lucro: "+ porcentagemLucro[posProduto]);
            System.out.println("quantidade em estoque: "+ quantidadeEstoque[posProduto]);

            System.out.println("gostaria de alterar os dados desse produto? \n1- para sim \n2- para não");
            querAtualizar = ler.nextInt();
            ler.nextLine();
            if(querAtualizar==1){
                System.out.println("por favor, digite o novo nome do produto:");
                nomeProduto[posProduto] = ler.nextLine();
                System.out.println("por favor, digite a nova descrição do produto:");
                descricaoProduto[posProduto] = ler.nextLine();
                System.out.println("por favor, digite o novo valor de compra do produto:");
                valorCompra[posProduto] = ler.nextDouble();
                while(Double.compare(valorCompra[posProduto], 0) < 1){ //validação do valor de compra do produto
                    System.out.println("o valor de compra deve ser um numero positivo maior que 0!");
                    System.out.println("digite um valor valido:");
                    valorCompra[posProduto] = ler.nextDouble();
                }
                System.out.println("por favor, digite a nova porcentagem de lucro:");
                porcentagemLucro[posProduto] = ler.nextDouble();
                System.out.println("por favor, digite a nova quantidade em estoque:");
                quantidadeEstoque[posProduto] = ler.nextInt();
                ler.nextLine();
                while(quantidadeEstoque[posProduto] < 1){ //validação da quantidade de estoque disponivel
                    System.out.println("a quantidade em estoque deve ser um numero positivo maior que zero! \ndigite outro valor:");
                    quantidadeEstoque[posProduto] = ler.nextInt();
                    ler.nextLine();
                }

                System.out.println("esses são os novos dados desse produto:");
                System.out.println("nome do produto: "+ nomeProduto[posProduto]);
                System.out.println("descrição do produto: "+ descricaoProduto[posProduto]);
                System.out.println("valor de compra: "+ valorCompra[posProduto]);
                System.out.println("porcentagem de lucro: "+ porcentagemLucro[posProduto]);
                System.out.println("quantidade em estoque: "+ quantidadeEstoque[posProduto]);
                
            }else{
                System.out.println("tudo bem, vamos continuar!");
            }
        }else{
            System.out.println("Produto não encontrado!");
        }
    }

    // metodo usado para cadastrar uma venda 
    public static int cadastroVendas(int quantidadeClientes, String clientes[], int quantidadeProdutos, String nomeProduto[],double valorCompra[], double porcentagemLucro[], int quantidadeEstoque[], int quantidadeVendas, String vendas[], double valorVenda[]){
        
        // declaração de variaveis
        int idCliente,qntProdutosVendidos, idProduto = 0;

        if(quantidadeClientes == 0 || quantidadeProdutos == 0){ //verificaçao se há clientes e produtos cadastrados
        
            System.out.println("Por favor cadastre pelo menos um cliente e um produto primeiro!");
        } else{
        
            System.out.println("vamos cadastrar uma venda");

            System.out.println("escolha um dos clientes cadastrados:\n");
            System.out.println("id - nome do cliente");
            for(int i = 0; i < quantidadeClientes; i++){
                System.out.println((i+1) + " - " + clientes[i]);
            }
            
            System.out.println("\npor favor digite o id do cliente:");
            idCliente = ler.nextInt();
            ler.nextLine();
            while(idCliente <1 || idCliente > quantidadeClientes){ // verificador do id de cliente requisitado
                System.out.println("o id do cliente deve ser maior que 0 e até " + quantidadeClientes);
                System.out.println("por favor digite outro id:");
                idCliente = ler.nextInt();
                ler.nextLine();

            }

            System.out.println("vamos cadastrar os produtos para a venda:");
            System.out.println("id - nome do produto - preço de venda - quantidade em estoque");
            do{//loop para cadastro de mais de 1 produtos em uma venda
                for(int i = 0; i<quantidadeProdutos; i++){
                    System.out.println((i + 1) + " - " + nomeProduto[i] + " - " + (valorCompra[i] * (1 + porcentagemLucro[i]/100) ) + " - " + quantidadeEstoque[i]);
                }
                System.out.println("digite o id do produto que deseja adicionar a venda: (se quiser encerrar a venda, digite 0)");
                idProduto = ler.nextInt();
                ler.nextLine();
                while(idProduto<0 || idProduto > quantidadeProdutos + 1 ){ //verificador do id do produto digitado
                    System.out.println("o numero inserido deve ser entre 0 e " + quantidadeProdutos + " e deve haver pelo menos 1 disponivel em estoque");
                    System.out.println("por favor digite outro id:");
                    idProduto = ler.nextInt();
                    ler.nextLine();
                }
                if(idProduto!= 0 && quantidadeEstoque[idProduto-1] == 0 ){//verificaçao de estoque disponivel
                    System.out.println("esse produto está sem estoque!");
                }else{    
                    if(idProduto > 0){
                        System.out.println("quer adicionar quantas unidades ao pedido?");
                        qntProdutosVendidos = ler.nextInt();
                        ler.nextLine();
                        while(qntProdutosVendidos<1 || qntProdutosVendidos > quantidadeEstoque[idProduto - 1]){
                            System.out.println("a quantidade digitada deve ser um numero positivo até " + quantidadeEstoque[idProduto - 1]);
                            System.out.println("digite um valor valido:");
                            qntProdutosVendidos = ler.nextInt();
                            ler.nextLine();
                        }
                        valorVenda[quantidadeVendas] += (qntProdutosVendidos * (valorCompra[idProduto - 1] * (1 + porcentagemLucro[idProduto - 1]/100) ) );
                        quantidadeEstoque[idProduto - 1] -= qntProdutosVendidos;
                        System.out.println("o valor da venda até agora é: " + valorVenda[quantidadeVendas]);
                    }
                }
            }while(idProduto>0);
            vendas[quantidadeVendas] = "o valor da venda " + (quantidadeVendas + 1) + " para o cliente " + clientes[idCliente-1]+" é: " + valorVenda[quantidadeVendas];
            System.out.println(vendas[quantidadeVendas]);
            
            quantidadeVendas++;

        }
        
        return quantidadeVendas;
    }

    // metodo usado para exibir o inventario de produtos da loja
    public static void estoqueProduto(int quantidadeProdutos, String nomeProduto[], int quantidadeEstoque[]){
        
        if(quantidadeProdutos == 0){ //limita a amostragem de produtos apenas quando houver algum cadastrado
            System.out.println("não há nenhum produto cadastrado\n");
        } else{
            System.out.println("esses são os produtos cadastrados:\n");
            System.out.println("id - nome do produto - quantidade em estoque\n");

            for(int i = 0; i< quantidadeProdutos; i++){
                System.out.println((i+1) + " - " + nomeProduto[i] + " - " + quantidadeEstoque[i]);
            }
        }
    }
}