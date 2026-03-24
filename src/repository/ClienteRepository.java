package repository;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private static final List<Cliente> clientes = new ArrayList<>();

    static {
        clientes.add(new Cliente(1, "Carlos Eduardo", "carlos@email.com"));
        clientes.add(new Cliente(2, "Maria Silva", "maria@email.com"));
        clientes.add(new Cliente(3, "João Souza", "joao@email.com"));
    }

    public static List<Cliente> listarClientes() {
        return clientes;
    }

    public static Cliente buscarPorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}