package AcademiaJavaJDBC;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
public class BancoDeDados implements InterfaceBancoDados{

    public static Connection connection;
    public static Scanner reader = new Scanner(System.in);
    public static Log meuLogger;

    //Classe executável
    public static void main(String[] args) throws IOException{
        meuLogger = new Log("Log.txt");

        try{
            meuLogger.logger.setLevel(Level.INFO);
        }catch(Exception e){
            meuLogger.logger.info("Exeption: "+e.getMessage());
            e.printStackTrace();
        }

        meuLogger.logger.info("O seu Bando de Dados foi iniciado com sucesso. Qual opção você precisa usar?");
        showMenu();
    }
    public static void showMenu(){
        int optionSelect = 0;

        while(optionSelect != 5){
            System.out.println("1 - Inserir Dados");
            System.out.println("2 - Alterar Dados");
            System.out.println("3 - Excluir Dados");
            System.out.println("4 - Consultar Dados");
            System.out.println("5 - Desconectar do Banco");
            optionSelect = reader.nextInt();

            dataProcess(optionSelect);
        }
    }

    public static void dataProcess(int numSelected){
        final String db_url = "jdbc:mysql://localhost:3306/reunião?user=root$password=";
        final String db_query = "SELECT * FROM pessoa";
        final String db_user = "root";
        final String db_password = "";
        BancoDeDados dataBank = new BancoDeDados();

        if(numSelected == 5){
            dataBank.desconectar();
        }else{
            dataBank.conectar(db_url, db_user, db_password);
            do {
                switch (numSelected){
                    case 1:
                        String name;
                        String email;
                        String cargo;
                        System.out.println("Informe o nome: ");
                        reader.nextLine();
                        name = reader.nextLine();
                        System.out.println("Informe o email: ");
                        //reader.nextLine();
                        email = reader.nextLine();
                        System.out.println("Informe o cargo: ");
                        //reader.nextLine();
                        cargo = reader.nextLine();

                        dataBank.inserirAlterarExcluir("INSERT INTO pessoa(nome, email, cargo) VALUES (" + "'"
                                + name + "'" + "," + "'" + email + "'" + "," + "'" + cargo + "'" + ")");
                        break;

                    case 2:
                        dataBank.consultar(db_query);
                        System.out.println("Selecione o ID do usuário qeu deseja alterar: ");
                        int idUser = reader.nextInt();
                        String nameAlt;
                        String emailAlt;
                        String cargoAlt;
                        System.out.println("Informe o novo Nome: ");
                        reader.nextLine();
                        nameAlt = reader.nextLine();
                        System.out.println("Informe o novo Email: ");
                        emailAlt = reader.nextLine();
                        System.out.println("Informe o novo Cargo: ");
                        cargoAlt = reader.nextLine();

                        dataBank.inserirAlterarExcluir("UPDATE pessoa SET nome = " + "'"
                                + nameAlt + "'" + "," + "email = " + "'" + emailAlt + "'" + "," + "cargo = " +
                                "'" + cargoAlt + "'" + "WHERE id = " + idUser);
                        break;

                    case 3:
                        dataBank.consultar(db_query);
                        System.out.println("Selecione o ID do usuário que deseja Deletar: ");
                        int idUserDel = reader.nextInt();

                        dataBank.inserirAlterarExcluir("DELETE FROM pessoa WHERE id = " + idUserDel);
                        break;

                    case 4:
                        dataBank.consultar(db_query);
                        break;
                    }
                    showMenu();
                    numSelected = reader.nextInt();
                }while (numSelected != 5);
            }
        }
    @Override
    public void conectar(String db_url, String db_user, String db_password) {
        try{
            connection = DriverManager.getConnection(db_url,db_user, db_password);
            //System.out.println("Conexão estabelecida");
            meuLogger.logger.info("conexão estabelecida");
        } catch (SQLException e) {
            //System.out.println("Não foi possível conectar ao banco de dados"+ e.getMessage());
            e.printStackTrace();
            meuLogger.logger.info("Não foi possivel conectar ao banco de dados");
        }
    }

    @Override
    public void desconectar() {
        try {
            if (connection != null) {
                connection.close();
                //System.out.println("Você fez logout com sucesso!");
                meuLogger.logger.info("Você desconectou o Banco de Dados");
            }
        } catch (SQLException e) {
            //System.out.println("Não foi possível desconectar do banco de dados.");
            meuLogger.logger.info("Erro ao Desconectar");
            e.printStackTrace();
        }
    }

    @Override
    public void consultar(String db_query) {

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(db_query);
            //preparedStatement = connection.prepareStatement("SELECT * FROM pessoa");
            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+", "
                +resultSet.getString(2)+", "+resultSet.getString(3)+", "
                +resultSet.getString(4));
        }
        meuLogger.logger.info("Você realizou sua consulta com sucesso.");
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
            //System.out.println("Não foi possível conectar ao banco de dados: "+ e);
            meuLogger.logger.info("Não foi possível conectar ao Banco de Dados.");
            e.printStackTrace();
        }
    }
    @Override
    public void inserirAlterarExcluir(String db_query) {
        int rowsAffected = 0;
        try {
            Statement statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(db_query);

            if (db_query.contains("INSERT")){
                meuLogger.logger.info("Você inseriu dados com sucesso.");
            } else if (db_query.contains("UPDATE")) {
                meuLogger.logger.info("Você atualizou o Banco de Dados com sucesso.");
            } else if (db_query.contains("DELETE")) {
                meuLogger.logger.info("Você removeu dados com sucesso.");
            }
            statement.close();
        } catch (SQLException e) {
            meuLogger.logger.info("Não foi possível executar a operação de inserção/alteração/exclusão no banco de dados.");
            //System.out.println("Não foi possível executar a operação de inserção/alteração/exclusão no banco de dados.");
            e.printStackTrace();
        }
        meuLogger.logger.info(rowsAffected + " linhas foram afetadas.");
        meuLogger.logger.info("\n Operações realizadas com sucesso.");
        System.out.println(rowsAffected + " linhas foram afetadas.");
        //return rowsAffected;
    }

    /* {
        BancoDeDados bancoDeDados = new BancoDeDados();

        bancoDeDados.conectar("jdbc:mysql://localhost:3306/reunião?user=root$password=", "root", "");
        bancoDeDados.consultar("SELECT * FROM pessoa");
        System.out.println("Conectado ao MySQL");
        //bancoDeDados.inserirAlterarExcluir("INSERT INTO pessoa(nome, email, cargo) VALUES (" + "'" + "Carla" + "'" + "," + "'"+ "carla@uel.com" + "'" + "," + "'"+"Professor" + "'"+")");
        //bancoDeDados.inserirAlterarExcluir("UPDATE pessoa SET nome = " + "'" + "Bruno" + "'" + "," + "email = " + "'"+ "bruno@uel.com" + "'" + " WHERE id = " + 2);
        //bancoDeDados.inserirAlterarExcluir("DELETE FROM pessoa WHERE id = " + 5);
        //bancoDeDados.desconectar();
    }*/

}


