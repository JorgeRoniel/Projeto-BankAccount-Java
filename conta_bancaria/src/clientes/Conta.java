package clientes;
import clientes.Cliente;
import operacoes.OperacoesConta;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Conta implements OperacoesConta{
    private ArrayList <Cliente> c = new ArrayList<Cliente>();
    private int indice = 0;

    public Conta() {}

    //Operações relacionadas a conta
    public void criarConta(Cliente proprietario) {
        if(this.c.add(proprietario)){
            System.out.println("Conta criada com Suceso! Seu ID: "+ this.indice);
            this.c.get(indice).setId(indice);
            this.indice++;
        }
        
    }

    @Override
    public void atualizarConta(Cliente c, int id) {
        for (Cliente cli : this.c) {
            if(cli.getId() == id){
                cli.setNome(c.getNome());
                cli.setCpf(c.getCpf());
                cli.setIdade(c.getIdade());
                System.out.println("Cliente atualizado com sucesso!");
            }
        }
    }

    @SuppressWarnings("resource")
    public void acessarConta(int id){
        for(Cliente cli : this.c){
            if(cli.getId() == id){
                System.out.println("========================================");
                System.out.println("Bem vindo(a), "+ cli.getNome() +", o que voce deseja? ");
                System.out.println("========================================");
                System.out.println("");

                Scanner scanner = new Scanner(System.in);
                int opcaoConta;
                do {
                    System.out.println("1 - depositar");
                    System.out.println("2 - sacar");
                    System.out.println("3 - consultar saldo");
                    System.out.println("4 - consultar conta");
                    System.out.println("5 - sair da conta");

                    opcaoConta = scanner.nextInt();

                    switch (opcaoConta) {
                        case 1:
                            System.out.println("Informe o valor a ser depositado: ");
                            float valor_dep = scanner.nextInt();

                            depositar(valor_dep, id);
                            break;
                        case 2:
                            System.out.println("Informe o valor a ser sacado: ");
                            float valor_saque = scanner.nextInt();

                            sacar(valor_saque, id);
                            break;
                        case 3:
                            consultarSaldo(id);
                            break;
                        case 4:
                            consultarConta(id);
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                } while (opcaoConta != 5);
            }
        }
    }

    public void consultarConta(int id){
        for(Cliente cli : this.c){
            if(cli.getId() == id){
                System.out.println(cli);
            }
        }
    }

    @Override
    public void removerConta(String nome) {
        for (Cliente cli : c) {
            if(cli.getNome() == nome){
                this.c.remove(cli.getId());
                System.out.println("Conta deletada com sucesso!");
                break;
            }
        }
    }

    //Operações Bancárias
    @Override
    public void depositar(float qtd, int id) {
        for(Cliente cli : this.c){
            if(cli.getId() == id){
                float s = cli.getSaldo() + qtd;
                cli.setSaldo(s);
                System.out.println("Deposito concluído com sucesso!");
            }
        }
    }

    @Override
    public void sacar(float qtd, int id) {
        for(Cliente cli : this.c){
            if(cli.getId() == id){
                if(qtd > cli.getSaldo()){
                    System.out.println("Saldo insuficiente para o saque!");
                }else{
                    float s = cli.getSaldo() - qtd;
                    cli.setSaldo(s);
                    System.out.println("Saque concluído com sucesso!");
                }
            }
        }
    }

    @Override
    public void consultarSaldo(int id) {
        for(Cliente cli : this.c){
            if(cli.getId() == id){
                System.out.println("===============================");
                System.out.println("");
                System.out.println("Cliente: "+ this.c.get(id).getNome());
                System.out.println("===============================");
                System.out.println("Saldo atual: "+ cli.getSaldo());
                System.out.println("");
                System.out.println("===============================");
            }
        }
    }

}
