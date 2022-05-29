package cloud.tallercloud.persistence.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "projectTask")
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "You must fill this field")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "You must fill this field")
    @Column(name = "summary", nullable = false)
    private String summary;

    @Column(name = "acceptanceCriteria")
    private String acceptanceCriteria;

    @Column(name = "taskStatus")
    private TaskStatus taskStatus;

    @Min(value = 1,message = "The min value of priority is 1")
    @Max(value = 5, message = "The max value of priority is 5")
    @Column(name = "priority")
    private int priority;

    @Min(value = 1,message = "Hours must be greater than 0")
    @Max(value = 8, message = "Hours must be less than 9")
    @Column(name = "hours" )
    private double hours;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "projectIdentifier", updatable = false)
    private String projectIdentifier;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "backlog_id")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectTask that = (ProjectTask) o;

        return Objects.equals(id,that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
