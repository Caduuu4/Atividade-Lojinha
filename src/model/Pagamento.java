package model;

public class Pagamento {
    private int id;
    private String status;
    private double valor;

    public Pagamento(int id, String status, double valor) {
        this.id = id;
        this.status = status;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public double getValor() {
        return valor;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pagamento{id=" + id + ", status='" + status + "', valor=" + valor + "}";
    }
}