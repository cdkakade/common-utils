package expense.manager.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BaseDto {

    @JsonProperty("modified_at")
    private Date modifiedAt;

    @JsonProperty("created_at")
    protected Date createdAt;
}
