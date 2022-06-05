package cloud.tallercloud.services;

import cloud.tallercloud.persistence.entity.ProjectTask;

import java.util.List;

public interface ProjectTaskService {

    void save(ProjectTask projectTask);

    List<ProjectTask> findAll();
    List<ProjectTask> findTaskByProject(String id);

    double findHoursProject(String id);
}
