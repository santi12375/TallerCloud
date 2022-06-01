package cloud.tallercloud.services.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/*Solo pedirá la información necesaria para crear el objeto*/
@Data
public class ProjectTaskInDTO {
    @NotBlank(message = "You must fill this field")
    private String name;
    @NotBlank(message = "You must fill this field")
    private String summary;
    private String acceptanceCriteria;
    @Min(value = 1,message = "The min value of priority is 1")
    @Max(value = 5, message = "The max value of priority is 5")
    private int priority;
    @Min(value = 1,message = "Hours must be greater than 0")
    @Max(value = 8, message = "Hours must be less than 9")
    private Double hours;
    private Date startDate;
    private Date endDate;
}
