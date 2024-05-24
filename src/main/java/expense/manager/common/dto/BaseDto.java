package expense.manager.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDto {

	@JsonProperty("modified_at")
	private LocalDateTime modifiedAt;

	@JsonProperty("created_at")
	protected LocalDateTime createdAt;

}
