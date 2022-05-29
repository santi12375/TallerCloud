package cloud.tallercloud.services.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectInDTO {
    private String projectName;
    private String description;
    private Date startDate;
    private Date endDate;
}
