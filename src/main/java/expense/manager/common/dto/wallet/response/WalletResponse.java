package expense.manager.common.dto.wallet.response;

import expense.manager.common.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper=false)
public class WalletResponse extends BaseDto {
    private String id;
    private String name;
    private BigDecimal balance;
}
