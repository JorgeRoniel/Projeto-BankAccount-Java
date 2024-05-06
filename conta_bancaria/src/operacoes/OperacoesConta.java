package operacoes;
import clientes.Cliente;

public interface OperacoesConta {
    
    //Operações relacionadas a conta
    public void atualizarConta(Cliente c, int id);
    public void removerConta(String nome);

    //Operações Bancárias
    public void depositar(float qtd, int id);
    public void sacar(float qtd, int id);
    public void consultarSaldo(int id);
}
