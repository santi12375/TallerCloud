package cloud.tallercloud.persistence.entity;



import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
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


    @Column(unique = true ,name = "projectName", nullable = false)
    private String projectName;


    @Column(name = "projectIdentifier", unique = true , nullable = false, updatable = false)
    private String projectIdentifier;


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
