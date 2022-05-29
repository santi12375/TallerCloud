package cloud.tallercloud.mapper;

import cloud.tallercloud.persistence.entity.ProjectTask;
import cloud.tallercloud.persistence.entity.TaskStatus;
import cloud.tallercloud.services.dto.ProjectInDTO;
import cloud.tallercloud.services.dto.ProjectTaskInDTO;
import org.springframework.stereotype.Component;

@Component
public class ProjectTaskInDtoToProjectTask implements IMapper<ProjectTaskInDTO, ProjectTask> {

    @Override
    public ProjectTask map(ProjectTaskInDTO in) {
        ProjectTask projectTask = new ProjectTask();
        projectTask.setName(in.getName());
        projectTask.setSummary(in.getSummary());
        projectTask.setAcceptanceCriteria(in.getAcceptanceCriteria());
        projectTask.setPriority(in.getPriority());
        projectTask.setHours(in.getHours());
        projectTask.setStartDate(in.getStartDate());
        projectTask.setEndDate(in.getEndDate());
        projectTask.setTaskStatus(TaskStatus.Not_Stared);
        return projectTask;
    }
}
