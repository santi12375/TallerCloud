package cloud.tallercloud.services;

import cloud.tallercloud.persistence.entity.ProjectTask;
import cloud.tallercloud.persistence.repository.ProjectTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*Cuando empezamos a bajar en capas , necesito objetos de la capa anterior*/
/* Las validaciones se pueden aplicar en la entidad o en el DTO*/

@Service
@RequiredArgsConstructor
public class ProjectTaskServiceImpl implements ProjectTaskService{

    private final ProjectTaskRepository repository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ProjectTask projectTask) {
        repository.save(projectTask);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectTask> findAll() { return repository.findAll(); }

    @Override
    public List<ProjectTask> findTaskByProject(String id) {
        return repository.findProjectTasksByProject(id);
    }

    @Override
    public double findHoursProject(String id) {
        return repository.GetHoursProject(id);
    }

    @Override
    public double findHoursProjectByStatus(String id, String status) {
        return repository.GetHoursProjectStatus(id,status);
    }

    @Override
    @Transactional
    public void deleteTaskStatus(Long id, String identifier) {
        repository.markProjectTaskAsDeleted(id,identifier);
    }


}
