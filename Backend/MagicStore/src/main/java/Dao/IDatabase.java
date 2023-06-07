package Dao;

public interface IDatabase {
    public void connect(String db_user, String db_password, String db_url);
    public void disconnect();
    public void consult(String db_query);
    public int crud(String db_query);

}
