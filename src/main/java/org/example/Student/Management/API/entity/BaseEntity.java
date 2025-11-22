package Student.Management.API.example.Student.Management.API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Column(name="created_at",  nullable=false)
    @CreatedDate
    @CreationTimestamp
    private Instant createdAt;

    @CreatedBy
    @Column(name="created_by",  nullable=false)
    private String createdBy;

    @LastModifiedBy
    @UpdateTimestamp
    @Column(nullable=false)
    private Instant updatedAt;

    @Column(length = 20)
    @LastModifiedBy
    private Instant updatedBy;
}
