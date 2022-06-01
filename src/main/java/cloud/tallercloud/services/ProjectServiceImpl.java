package cloud.tallercloud.services;

import cloud.tallercloud.mapper.ProjectInDtoToProject;
import cloud.tallercloud.mapper.ProjectTaskInDtoToProjectTask;
import cloud.tallercloud.persistence.entity.Project;
import cloud.tallercloud.persistence.repository.ProjectRepository;
import cloud.tallercloud.services.dto.ProjectInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final ProjectInDtoToProject mapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ProjectInDTO projectInDTO) {
        Project project = mapper.map(projectInDTO);
        projectRepository.save(project);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
}
