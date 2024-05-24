package expense.manager.common.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "custom-generator",
            strategy = GenerationType.IDENTITY)
    @GenericGenerator(
            name = "custom-generator",
            strategy = "expense.manager.common.utility.BaseIdentifierGenerator")
    protected String id;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Date createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    protected Date modifiedAt;

    @Column
    @Version
    protected int version;
}
