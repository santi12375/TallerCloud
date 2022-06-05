package cloud.tallercloud.persistence.entity;



import cloud.tallercloud.commons.EntityBase;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;



@Getter
@Setter
@Entity
@Table(name = "project")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project extends EntityBase {
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
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "startDate")
    private String startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "endDate")
    private String endDate;

    @JsonManagedReference
    //@JoinColumn(name = "backlog_id")
    @OneToOne(fetch = FetchType.EAGER,cascade =CascadeType.PERSIST,mappedBy = "project")
    private Backlog backlog;

    /**
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "backlog_id")
    private Backlog backlog;
    **/

}
