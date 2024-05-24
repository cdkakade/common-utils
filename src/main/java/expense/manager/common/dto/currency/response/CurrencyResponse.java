package expense.manager.common.dto.currency.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrencyResponse {

    private long id;

    private String name;

    @JsonProperty("icon_url")
    private String iconUrl;
}
