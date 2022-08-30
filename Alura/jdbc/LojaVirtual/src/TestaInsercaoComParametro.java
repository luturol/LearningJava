import java.sql.*;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().Create();
        connection.setAutoCommit(false);
        try (var stm =
                     connection.prepareStatement("INSERT INTO PRODUTO(nome, descricao) VALUES(?, ?)",
                             Statement.RETURN_GENERATED_KEYS);){

            adicionarVariavel("Mouse", "Mouse sem fio", stm);
            adicionarVariavel("Smar TV", "45 polegadas", stm);
            adicionarVariavel("Radio", "bateria", stm);

            connection.commit();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Rollback foi executado");
            connection.rollback();
        }
    }

    public static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        stm.execute();
        ResultSet rst = stm.getGeneratedKeys();

        while (rst.next()) {
            int id = rst.getInt(1);
            System.out.println("Id criado foi " + id);
        }


    }
}
