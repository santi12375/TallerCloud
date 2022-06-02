package cloud.tallercloud.persistence.entity;


import cloud.tallercloud.commons.EntityBase;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "backlog")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Backlog extends EntityBase {

    @NotBlank (message = "El projectIdentifier no puede ser vacio")
    @Column(name = "projectIdentifier", nullable = false)
    private String projectIdentifier;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @NotEmpty (message = "El projectIdentifier no puede ser vacio")
    private Project project;

    @OneToMany(mappedBy = "backlog",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<ProjectTask> projectTasks;

    /**
    @JsonManagedReference
    @OneToMany(mappedBy = "backlog", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ProjectTask> projectTask;


    @OneToOne(mappedBy = "backlog", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Project project;
    **/


}
