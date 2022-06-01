package cloud.tallercloud.services;

import cloud.tallercloud.mapper.ProjectTaskInDtoToProjectTask;
import cloud.tallercloud.persistence.entity.Project;
import cloud.tallercloud.persistence.entity.ProjectTask;
import cloud.tallercloud.persistence.entity.TaskStatus;
import cloud.tallercloud.persistence.repository.ProjectTaskRepository;
import cloud.tallercloud.services.dto.ProjectTaskInDTO;
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
    private final ProjectTaskInDtoToProjectTask mapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ProjectTask projectTask) { repository.save(projectTask); }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectTask> findAll() { return repository.findAll(); }


}
