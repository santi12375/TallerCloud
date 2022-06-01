package cloud.tallercloud.services;

import cloud.tallercloud.persistence.entity.Project;
import cloud.tallercloud.services.dto.ProjectInDTO;

import java.util.List;

public interface ProjectService {

    void save(ProjectInDTO projectInDTO);

    List<Project> findAll();
}
