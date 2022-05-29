package cloud.tallercloud.persistence.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "backlog")
public class Backlog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "You must fill this field")
    @Column(name = "projectIdentifier", nullable = false)
    private String projectIdentifier;

    @JsonManagedReference
    @OneToMany(mappedBy = "backlog", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ProjectTask> projectTask;


    @OneToOne(mappedBy = "backlog", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Project project;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backlog backlog = (Backlog) o;
        return Objects.equals(id,backlog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
