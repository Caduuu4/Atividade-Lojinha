package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private double valorTotal;
    private String status;
    private Pagamento pagamento;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
        this.status = "ABERTO";
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        valorTotal += item.getSubtotal();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return "Pedido{id=" + id
                + ", cliente=" + cliente.getNome()
                + ", itens=" + itens
                + ", valorTotal=" + valorTotal
                + ", status='" + status + '\''
                + ", pagamento=" + pagamento
                + "}";
    }
}