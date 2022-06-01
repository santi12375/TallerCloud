package cloud.tallercloud.services;

import cloud.tallercloud.persistence.entity.ProjectTask;
import cloud.tallercloud.services.dto.ProjectTaskInDTO;

import java.util.List;

public interface ProjectTaskService {

    void save(ProjectTaskInDTO projectTaskInDTO);

    List<ProjectTask> findAll();

}
