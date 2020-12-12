package outerService;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class ServiceSms {

    public static void sendSms(String phoneNumber) throws IOException {

        // Send data
        HttpURLConnection conn = (HttpURLConnection) new URL("https://http-api.d7networks.com/send?" +
                "username=uqqw9850" +
                "&password=qvcwi1hA" +
                "&dlr-method=POST" +
                "&dlr-url=https://4ba60af1.ngrok.io/receive" +
                "&dlr=yes" +
                "&dlr-level=3" +
                "&from=BookStoreEWA" +
                "&content=Votre%20commande%20a%20été%20validée%20avec%20succès" +
                "&to=+216"+ phoneNumber).openConnection();


        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        final StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            //stringBuffer.append(line);
            System.out.println( "message"+line);
        }
        rd.close();

        //return stringBuffer.toString();
    }

    public static void main(String[] args) throws IOException {
//        ServiceSms.test();
    }
}
