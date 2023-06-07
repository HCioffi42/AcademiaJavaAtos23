//import java.util.UUID;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) { //throws InterruptedException {
        // TODO Auto-generated method stub

        try {
            Log meuLogger = new Log("Log.txt");
            meuLogger.logger.setLevel(Level.FINE);
            meuLogger.logger.info("Log de informação");
            meuLogger.logger.warning("Log de Aviso");
            meuLogger.logger.severe("Log Severo");


        } catch (Exception e) {


        }

    }


}
