package cloud.tallercloud.persistence.entity;


import cloud.tallercloud.commons.EntityBase;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "projectTask")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectTask extends EntityBase {

    @NotBlank(message = "El name no puede ser vacio")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "El summary no puede ser vacio")
    @Column(name = "summary", nullable = false)
    private String summary;

    @Column(name = "acceptanceCriteria")
    private String acceptanceCriteria;

    @Pattern(regexp="^(Not Stared|In Progress|completed|deleted)$",message="invalid code")
    @Column(name = "taskStatus")
    private String taskStatus;
    @Min(1)
    @Max(5)
    @Column(name = "priority")
    private int priority;
    @Min(1)
    @Max(8)
    @Positive (message = "La cantidad debe ser mayor que cero")
    @Column(name = "hours" )
    private double hours;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "startDate")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "endDate")
    private Date endDate;
    @NotBlank(message = "No puede estar en blanco y no se puede actualizar")
    @Column(name = "projectIdentifier", updatable = false)
    private String projectIdentifier;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "backlog_id")
    private Backlog backlog;

}
