package cloud.tallercloud.services.dto;

import lombok.Data;

import java.util.Date;

/*Solo pedirá la información necesaria para crear el objeto*/
@Data
public class ProjectTaskInDTO {
    private String name;
    private String summary;
    private String acceptanceCriteria;
    private int priority;
    private Double hours;
    private Date startDate;
    private Date endDate;
}
