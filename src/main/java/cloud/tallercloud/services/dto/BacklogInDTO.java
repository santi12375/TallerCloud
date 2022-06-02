package cloud.tallercloud.services.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BacklogInDTO {
    @NotBlank(message = "You must fill the project identifier field")
    private String projectIdentifier;
}
