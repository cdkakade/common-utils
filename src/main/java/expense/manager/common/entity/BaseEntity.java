package expense.manager.common.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@Id
	@GeneratedValue(generator = "custom-generator", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "custom-generator", strategy = "expense.manager.common.utility.BaseIdentifierGenerator")
	protected String id;

	@CreatedDate
	@Column(name = "created_at", updatable = false, nullable = false)
	protected LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "modified_at")
	protected LocalDateTime modifiedAt;

	@Column
	@Version
	protected int version;

}
