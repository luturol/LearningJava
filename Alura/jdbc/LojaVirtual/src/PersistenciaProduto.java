import modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaProduto {
    private Connection conn;

    public PersistenciaProduto(Connection conn) {
        this.conn = conn;
    }

    public void salvarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO(nome, descricao) VALUES(?, ?)";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());

            preparedStatement.execute();

            try(ResultSet result = preparedStatement.getGeneratedKeys())
            {
                while (result.next())
                {
                    produto.setId(result.getInt(1));
                }
            }
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";

        try(PreparedStatement pstm = conn.prepareStatement(sql))
        {
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet())
            {
                while(rst.next())
                {
                    Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
                    produtos.add(produto);
                }
            }
        }

        return produtos;
    }
}
