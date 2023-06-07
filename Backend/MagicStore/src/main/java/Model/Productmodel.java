package Model;

import Dao.IDatabase;

public class Productmodel implements IDatabase {
    private int code;
    private String name;
    private String category;
    private float valor;

    @Override
    public void connect(String db_user, String db_password, String db_url) {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public void consult(String db_query) {

    }

    @Override
    public int crud(String db_query) {
        return 0;
    }
}
