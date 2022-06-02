package cloud.tallercloud.services;

import cloud.tallercloud.persistence.entity.Project;
import cloud.tallercloud.persistence.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
}
