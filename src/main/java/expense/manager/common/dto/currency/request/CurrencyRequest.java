package expense.manager.common.currency.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyRequest {
    private long id;

    private String name;

    @JsonProperty("icon_url")
    private String iconUrl;
}
