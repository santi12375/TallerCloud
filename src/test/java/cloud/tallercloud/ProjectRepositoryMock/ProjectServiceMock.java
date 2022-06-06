package cloud.tallercloud.ProjectRepositoryMock;

import cloud.tallercloud.persistence.entity.Project;
import cloud.tallercloud.persistence.repository.ProjectRepository;
import cloud.tallercloud.services.ProjectService;
import cloud.tallercloud.services.ProjectServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProjectServiceMock {

    @Mock
    private ProjectRepository projectRepository;
    private ProjectService projectService;

    @BeforeEach
    public void projectServiceTest(){
        MockitoAnnotations.openMocks(this);
        projectService = new ProjectServiceImpl(projectRepository);

        Project project= Project.builder()
                .projectName("ujikmaaa")
                .projectIdentifier("84576")
                .description("test")
                .startDate("2021-01-05")
                .endDate("2021-01-11")
                .backlog( null)
                .build();
        List<Project> projects = projectService.findAll();
        projects.add(project);
        Mockito.when(projects).thenReturn(projects);
    }

    @Test
    public void when_findProject_return_Project(){

        List<Project> projects = projectService.findAll();;
        Assertions.assertThat(projects.size()).isEqualTo(1);
    }

}