package cloud.tallercloud.services;

import cloud.tallercloud.mapper.ProjectTaskInDtoToProjectTask;
import cloud.tallercloud.persistence.entity.ProjectTask;
import cloud.tallercloud.persistence.entity.TaskStatus;
import cloud.tallercloud.persistence.repository.ProjectTaskRepository;
import cloud.tallercloud.services.dto.ProjectInDTO;
import cloud.tallercloud.services.dto.ProjectTaskInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*Cuando empezamos a bajar en capas , necesito objetos de la capa anterior*/
/* Las validaciones se pueden aplicar en la entidad o en el DTO*/
@Service
@RequiredArgsConstructor
public class ProjectTaskService {

    private final ProjectTaskRepository repository;
    private final ProjectTaskInDtoToProjectTask mapper;

    public ProjectTask createProjectTask(ProjectTaskInDTO projectTaskInDTO){
        ProjectTask projectTask = mapper.map(projectTaskInDTO);
        return this.repository.save(projectTask);
    }

    public List<ProjectTask> findAll(){
        return this.repository.findAll();
    }

    public List<ProjectTask> findAllByTaskStatus(TaskStatus taskStatus){
        return this.repository.findAllByTaskStatus(taskStatus);
    }
}
