package model;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double subtotal;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return "ItemPedido{produto=" + produto.getNome()
                + ", quantidade=" + quantidade
                + ", subtotal=" + subtotal + "}";
    }
}