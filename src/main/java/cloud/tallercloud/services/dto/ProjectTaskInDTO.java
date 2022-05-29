package cloud.tallercloud.services.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/*Solo pedirá la información necesaria para crear el objeto*/
@Data
public class ProjectTaskInDTO {
    private String name;
    private String summary;
    private String acceptanceCriteria;
    @Min(value = 1,message = "The min value of priority is 1")
    @Max(value = 5, message = "The max value of priority is 5")
    private int priority;
    private Double hours;
    private Date startDate;
    private Date endDate;
}
