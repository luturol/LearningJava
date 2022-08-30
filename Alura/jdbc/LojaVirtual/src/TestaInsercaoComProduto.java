import modelo.Produto;

import java.sql.*;

public class TestaInsercaoComProduto {
    public static void main(String[] args) {
        Produto comoda = new Produto("Comoda", "2 portas");

        try (Connection conn = new ConnectionFactory().Create()) {
            var produtoDao = new PersistenciaProduto(conn);
            produtoDao.salvarProduto(comoda);

            var produtos = produtoDao.listar();
            produtos.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(comoda);
    }
}
