import java.sql.*;

public class main {
    public static void main(String[] arg) {
        try{
            Connection conn = new ConnectionFactory().Create();

            //Statement Example of SQL Injection
            Statement stm = conn.createStatement();
            String name = "\'Rafael\'";
            String cpf = "\'12345678911\'); DELETE FROM CLIENTE; SELECT * FROM CLIENTE WHERE (1 = 1";
            stm.execute(String.format("INSERT INTO cliente(nome, cpf) VALUES(%s, %s);", name, cpf));

            stm = conn.createStatement();
            ResultSet result = stm.executeQuery("SELECT ID, NOME, CPF FROM CLIENTE");

            if(result.next())
            {
                while(result.next())
                {
                    System.out.println(result.getInt(1) + " - " + " nome: " + result.getString(2) + " cpf: " + result.getString(3));
                }
            }
            else{
                System.out.println("not found any row because of the SQL Injection");
            }

            //Example of Prepared Statement
            try(PreparedStatement pstm = conn.prepareStatement("INSERT INTO cliente(nome, cpf) VALUES(?, ?);", Statement.RETURN_GENERATED_KEYS))
            {
                pstm.setString(1, name);
                pstm.setString(2, cpf);

                pstm.execute();
            }catch (SQLException ex)
            {
                ex.printStackTrace();
            }

        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }

    }
}
