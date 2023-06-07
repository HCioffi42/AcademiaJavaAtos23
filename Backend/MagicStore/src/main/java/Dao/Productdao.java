package Dao;

import java.io.IOException;
import java.sql.*;

public class Productdao implements IDatabase{
    private Connection connection;

    public static void main(String[] args) throws IOException {
        Productdao productdao = new Productdao();
        productdao.connect("root", "", "jdbc:mysql://localhost:3306/reunião");
    }


    @Override
    public void connect(String db_user, String db_password, String db_url) {
        db_user = "root";
        db_password = "";
        db_url = "jdbc:mysql://localhost:3306/reunião"; //Tem diferenças usar desta forma? "jdbc:mysql://localhost:3306/biblioteca?user=root$password=";

        try{
            connection = DriverManager.getConnection(db_url, db_user, db_password);
            System.out.println("Conectado ao banco");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao conectar");
        }
    }

    @Override
    public void disconnect() {
        try{
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void consult(String db_query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(db_query);
            while (result.next()) {
                System.out.println(result.getInt("CODE") + "," + result.getString("NAME") + "," +
                        result.getString("CATEGORY") + result.getFloat("VALOR") + "," + result.getInt("QNT"));
            }
            //ResultSet.close();
            statement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int crud(String db_query) {
        int rowAffected = 0;
        try{
            Statement statement = connection.createStatement();
            rowAffected = statement.executeUpdate(db_query);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return 0;
    }
}
