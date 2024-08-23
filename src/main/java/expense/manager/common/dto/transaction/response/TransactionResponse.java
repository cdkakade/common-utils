package expense.manager.common.dto.transaction.response;

import expense.manager.common.dto.transaction.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionResponse {

	private String id;

	private BigDecimal amount;

	private TransactionType type;

}
