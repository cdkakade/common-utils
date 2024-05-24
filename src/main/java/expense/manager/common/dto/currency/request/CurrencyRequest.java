package expense.manager.common.dto.currency.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CurrencyRequest {

	@Min(1)
	private long id;

	@NotBlank
	private String name;

	@JsonProperty("icon_url")
	private String iconUrl;

}
