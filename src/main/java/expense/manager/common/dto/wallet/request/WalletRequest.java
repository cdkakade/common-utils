package expense.manager.common.dto.wallet.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class WalletRequest {

    @NotBlank
    private String name;
    @NotNull
    private BigDecimal balance;
    @Min(1)
    private long currencyId;
}
