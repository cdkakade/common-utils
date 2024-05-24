package expense.manager.common.dto.currency.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CurrencyRequest {

	@Min(1)
	private long id;

	@NotBlank
	private String name;

	@JsonProperty("icon_url")
	private String iconUrl;

}
