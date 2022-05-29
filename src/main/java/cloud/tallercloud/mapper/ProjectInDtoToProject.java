package cloud.tallercloud.mapper;

import cloud.tallercloud.persistence.entity.Project;
import cloud.tallercloud.services.dto.ProjectInDTO;
import org.springframework.stereotype.Component;

@Component
public class ProjectInDtoToProject implements IMapper<ProjectInDTO, Project> {

    @Override
    public Project map(ProjectInDTO in) {
        Project project =  new Project();
        project.setProjectName(in.getProjectName());
        project.setDescription(in.getDescription());
        project.setStartDate(in.getStartDate());
        project.setEndDate(in.getEndDate());
        return project;
    }
}
