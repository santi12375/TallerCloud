package cloud.tallercloud.services.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class ProjectInDTO {

    @NotBlank(message = "You must fill this field")
    private String projectName;
    @NotBlank(message = "You must fill this field")
    @Size(min = 5,max = 7,message = "The project identifier value must be between 5 and 7")
    private String projectIdentifier;
    @NotBlank(message = "You must fill this field")
    private String description;
    private Date startDate;
    private Date endDate;
}
