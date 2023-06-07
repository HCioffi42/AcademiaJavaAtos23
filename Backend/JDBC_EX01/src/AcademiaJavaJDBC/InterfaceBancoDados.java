package AcademiaJavaJDBC;

    public interface InterfaceBancoDados {
        public void conectar(String db_url, String db_user, String db_password);
        public void desconectar();
        public void consultar(String db_query);
        public void inserirAlterarExcluir(String db_query);
    }

