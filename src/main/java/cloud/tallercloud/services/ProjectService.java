package cloud.tallercloud.services;

import cloud.tallercloud.persistence.entity.Project;

import java.util.List;

public interface ProjectService {

    void save(Project project);

    List<Project> findAll();

    List<Project> findProjectByProjectIdentifier(String identifier);
}
