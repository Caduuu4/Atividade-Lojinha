import model.Cliente;
import model.Pedido;
import repository.ClienteRepository;
import repository.ProdutoRepository;
import service.LojaService;

public class Main {
    public static void main(String[] args) {
        LojaService lojaService = new LojaService();

        System.out.println("=== CLIENTES CADASTRADOS ===");
        for (Cliente cliente : ClienteRepository.listarClientes()) {
            System.out.println(cliente);
        }

        System.out.println("\n=== PRODUTOS DISPONÍVEIS ===");
        ProdutoRepository.listarProdutos().forEach(System.out::println);

        System.out.println("\n=== CRIAÇÃO DE PEDIDO ===");
        Pedido pedido = lojaService.criarPedido(1);

        lojaService.adicionarItemAoPedido(pedido, 1, 2);
        lojaService.adicionarItemAoPedido(pedido, 2, 1);

        System.out.println("\nResumo do pedido:");
        System.out.println(pedido);

        System.out.println("\n=== PROCESSAMENTO DE PAGAMENTO ===");
        lojaService.processarPagamento(pedido);

        System.out.println("\n=== STATUS FINAL DO PEDIDO ===");
        System.out.println(pedido);
    }
}