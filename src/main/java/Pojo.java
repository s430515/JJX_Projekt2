import java.math.BigDecimal;
import java.util.Map;

public class Pojo {

    private String base;
    private String date;
    private Map<String, BigDecimal> rates;

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }
}
