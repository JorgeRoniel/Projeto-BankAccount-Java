import java.util.Scanner;
import clientes.*;

@SuppressWarnings("unused")
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Conta c = new Conta();

        int opcao;
        int opcaoConta;

        do {
            System.out.println("Menu:");
            System.out.println("1 - criar conta");
            System.out.println("2 - atualizar conta");
            System.out.println("3 - acessar conta");
            System.out.println("4 - deletar conta");
            System.out.println("0 - sair");

            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite seu nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite sua idade: ");
                    int idade = scanner.nextInt();

                    scanner.nextLine();
                    System.out.println("Digite seu cpf (000.000.000-00): ");
                    String cpf = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, idade, cpf);
                    c.criarConta(cliente);
                    break;
                case 2:
                    String novo_nome, novo_cpf;
                    int nova_idade;
                    
                    scanner.nextLine();
                    System.out.println("Digite o seu ID (informado ao criar a conta): ");
                    int id = scanner.nextInt();

                    scanner.nextLine();
                    System.out.println("Digite o novo nome: ");
                    novo_nome = scanner.nextLine();

                    System.out.println("Digite a nova idade: ");
                    nova_idade = scanner.nextInt();

                    scanner.nextLine();
                    System.out.println("Digite o novo cpf (000.000.000-00): ");
                    novo_cpf = scanner.nextLine();

                    Cliente novo_cliente = new Cliente(novo_nome, nova_idade, novo_cpf);
                    c.atualizarConta(novo_cliente, id);
                    break;
                case 3:
                    System.out.println("Informe seu ID: ");
                    int a_id = scanner.nextInt();

                    c.acessarConta(a_id);
                    break;
                case 4:
                    System.out.println("Digite o nome que foi usado na criação da conta: ");
                    String n = scanner.nextLine();
                    c.removerConta(n);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}

