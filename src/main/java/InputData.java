import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class InputData {

    private String url ="https://api.exchangeratesapi.io/latest?base=EUR";

    public InputData() throws IOException {


        System.out.println("Podaj kod waluty: ");
        Scanner scan = new Scanner(System.in);
        String rate = scan.nextLine().trim().toUpperCase();


        HttpConnection httpConnection = new HttpConnection(url);


        String responseRate = httpConnection.getJsonDocument();


        ObjectMapper mapper = new ObjectMapper();
        Pojo pojo = mapper.readValue(responseRate, Pojo.class);





        BigDecimal number = pojo.getRates().get(rate);
        if(number == null)
            System.out.println("Nie ma takiej waluty" );
        else
        System.out.println("Dzisiejszy kurs EUR/" + rate + " to " + number);



    }


}
