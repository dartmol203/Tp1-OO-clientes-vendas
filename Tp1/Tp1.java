package Tp1;

import java.util.Scanner;


public class Tp1 {
    static Scanner ler = new Scanner(System.in);
    
    public static void main(String[] args){
        
        int opcaoMenu;
        int quantidadeClientes = 0;
        String[] clientes, endereco, telefone;
        
        clientes = new String[120];
        endereco = new String[120];
        telefone = new String[120];

        /*int teste[];
        teste = new int[32];
        teste[31] = 42;
        System.out.println(teste[31]);*/


        
        
        
        System.out.println("bom dia! meu objetivo é automatizar o controle de clientes e produtos! possuo as seguintes funções:");
        do{
            menu();
            opcaoMenu = ler.nextInt();
            switch(opcaoMenu){
                case 1 :
                    quantidadeClientes = cadastroCliente(quantidadeClientes, clientes, endereco, telefone);
                    break;
                case 2 :
                    
                    System.out.println(quantidadeClientes);
                    break;
                case 3 :
                    break;
                case 4 :
                    break;
                case 5 :
                    break;
                case 6 :
                    break;
                case 7 :
                    System.out.println("obrigado! até mais!");
                    break;
                default:
                
            }
        }while(opcaoMenu !=7);
        
    }

    public static void menu(){
        System.out.println("1 - cadastro de novo cliente");
        System.out.println("2 - busca por cliente");
        System.out.println("3 - cadastro de novo produto");
        System.out.println("4 - busca por produto");
        System.out.println("5 - cadastro de venda");
        System.out.println("6 - mostrar produtos em estoque");
        System.out.println("7 - sair");
        System.out.println("por favor digite a opção desejada:");
    }

    public static int cadastroCliente(int quantidadeClientes, String clientes[], String endereco[], String telefone[]){
        
        int novosClientes;
        
        System.out.println("você gostaria de cadastrar quantos clientes?");
        novosClientes =  ler.nextInt();
        ler.nextLine();
        
        for(int i = quantidadeClientes; i < quantidadeClientes + novosClientes; i++ ){
            
            System.out.println("por favor, digite o nome do cliente:");
            clientes[i] = ler.nextLine();
            System.out.println("por favor, digite o endereço do cliente:");
            endereco[i] = ler.nextLine();
            System.out.println("por favor, digite o telefone do cliente:");
            telefone[i] = ler.nextLine();
        }
        System.out.println(clientes[0] + "\n" + endereco[0] + "\n" + telefone[0]);
        quantidadeClientes += novosClientes;

        return quantidadeClientes;
    }
}