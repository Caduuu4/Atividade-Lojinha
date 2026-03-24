package service;

import java.util.Random;

public class PagamentoExternoService {

    /*
     * Padrão Singleton:
     * Esta classe utiliza o padrão Singleton para garantir que exista apenas
     * uma única instância responsável pela comunicação com o sistema externo
     * de pagamento durante toda a execução da aplicação.
     *
     * Isso é importante porque evita múltiplas conexões desnecessárias com o
     * serviço de pagamento, centraliza a comunicação em um único ponto e
     * mantém o controle do acesso a esse recurso compartilhado.
     */

    private static PagamentoExternoService instancia;
    private Random random;

    private PagamentoExternoService() {
        this.random = new Random();
    }

    public static PagamentoExternoService getInstance() {
        if (instancia == null) {
            instancia = new PagamentoExternoService();
        }
        return instancia;
    }

    public boolean processar(double valor) {
        System.out.println("Enviando pagamento ao sistema externo...");
        System.out.println("Valor: R$ " + valor);

        return random.nextBoolean();
    }
}