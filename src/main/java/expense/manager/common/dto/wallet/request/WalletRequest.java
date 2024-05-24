package expense.manager.common.dto.wallet.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class WalletRequest {

	@NotBlank
	private String name;

	@NotNull
	private BigDecimal balance;

	@Min(1)
	@JsonProperty("currency_id")
	private long currencyId;

}
