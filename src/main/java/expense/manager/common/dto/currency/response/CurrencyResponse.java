package expense.manager.common.currency.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyResponse extends BaseDto{
    private long id;
    private String name;

    @JsonProperty("icon_url")
    private String iconUrl;
}
