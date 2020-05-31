import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {

private String jsonDocument;

    public HttpConnection(String url)

        {

                try {

                        //url = "https://api.exchangeratesapi.io/latest?base=EUR";

                        URL obj = new URL(url);
                        HttpURLConnection con = (HttpURLConnection) obj.openConnection();


                        int responseCode = con.getResponseCode();
                        System.out.println("Sending GET to " + url);
                        System.out.println("ResponseCode: " + responseCode);
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(con.getInputStream()));
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = in.readLine()) != null) {
                                response.append(inputLine);
                        }
                        in.close();

                        jsonDocument = response.toString();

/*
                        ObjectMapper mapper = new ObjectMapper();
                        String jsonInString = jsonDocument;
                        Pojo pojo = mapper.readValue(jsonInString, Pojo.class);
                        // System.out.println(pojo);
                        String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
                        // System.out.println(prettyStaff1);


                        System.out.println(pojo.getDate());
                        System.out.println(pojo.getRates().get("PLN"));*/


                } catch (Exception e) {
                        System.out.println(e);
                }


        }

        public String getJsonDocument(){
            return jsonDocument;
        }
}
