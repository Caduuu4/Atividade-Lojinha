package service;

import model.Cliente;
import model.ItemPedido;
import model.Pagamento;
import model.Pedido;
import model.Produto;
import repository.ClienteRepository;
import repository.ProdutoRepository;

public class LojaService {
    private int contadorPedido = 1;
    private int contadorPagamento = 1;

    /*
     * A instância do serviço de pagamento é obtida pelo método getInstance(),
     * garantindo o uso do padrão Singleton.
     * Assim, toda a aplicação compartilha a mesma conexão com o sistema
     * externo de pagamento.
     */
    private PagamentoExternoService pagamentoExternoService = PagamentoExternoService.getInstance();

    public Pedido criarPedido(int clienteId) {
        Cliente cliente = ClienteRepository.buscarPorId(clienteId);

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        Pedido pedido = new Pedido(contadorPedido++, cliente);
        System.out.println("Pedido criado com sucesso para o cliente: " + cliente.getNome());
        return pedido;
    }

    public void adicionarItemAoPedido(Pedido pedido, int produtoId, int quantidade) {
        Produto produto = ProdutoRepository.buscarPorId(produtoId);

        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }

        if (produto.getEstoque() < quantidade) {
            throw new IllegalArgumentException("Estoque insuficiente.");
        }

        ItemPedido item = new ItemPedido(produto, quantidade);
        pedido.adicionarItem(item);
        produto.reduzirEstoque(quantidade);

        System.out.println("Item adicionado: " + produto.getNome() + " x" + quantidade);
    }

    public void processarPagamento(Pedido pedido) {
        Pagamento pagamento = new Pagamento(contadorPagamento++, "PENDENTE", pedido.getValorTotal());
        pedido.setPagamento(pagamento);

        boolean aprovado = pagamentoExternoService.processar(pedido.getValorTotal());

        if (aprovado) {
            pagamento.setStatus("APROVADO");
            pedido.setStatus("PAGO");
            System.out.println("Pagamento aprovado.");
        } else {
            pagamento.setStatus("RECUSADO");
            pedido.setStatus("FALHA NO PAGAMENTO");
            System.out.println("Pagamento recusado.");
        }
    }
}