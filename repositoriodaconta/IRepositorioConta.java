package repositoriodaconta;

import entity.Conta;
import exception.ExcecaoElementoInexistente;

public interface IRepositorioConta {
    public void inserirConta(Conta conta);
    public void alterarConta(String numero);
    public void removerConta(String numero);
    public Conta buscarConta(String numero) throws ExcecaoElementoInexistente ;
    public boolean verificarExistenciaConta(String numero) ;
    public void mostrarContas();
}