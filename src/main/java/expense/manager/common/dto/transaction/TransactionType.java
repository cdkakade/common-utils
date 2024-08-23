package expense.manager.common.dto.transaction;

public enum TransactionType {

	EXPENSE("EXPENSE"), INCOME("INCOME");

	private final String value;

	TransactionType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}
