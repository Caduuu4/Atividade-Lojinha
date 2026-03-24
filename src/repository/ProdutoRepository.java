package repository;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private static final List<Produto> produtos = new ArrayList<>();

    static {
        produtos.add(new Produto(1, "Notebook", 3500.00, 10));
        produtos.add(new Produto(2, "Mouse", 80.00, 30));
        produtos.add(new Produto(3, "Teclado", 150.00, 20));
    }

    public static List<Produto> listarProdutos() {
        return produtos;
    }

    public static Produto buscarPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
}