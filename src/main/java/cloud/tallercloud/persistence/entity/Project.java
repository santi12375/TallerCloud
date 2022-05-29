package cloud.tallercloud.persistence.entity;



import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;



@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "You must fill this field")
    @Column(unique = true ,name = "projectName", nullable = false)
    private String projectName;

    @NotBlank(message = "You must fill this field")
    @Size(min = 5,max = 7,message = "The project identifier value must be between 5 and 7")
    @Column(name = "projectIdentifier", unique = true , nullable = false, updatable = false)
    private String projectIdentifier;

    @NotBlank(message = "You must fill this field")
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "backlog_id")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return Objects.equals(id,project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
