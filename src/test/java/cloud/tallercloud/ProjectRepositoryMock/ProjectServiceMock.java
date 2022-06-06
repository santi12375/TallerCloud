package cloud.tallercloud.ProjectRepositoryMock;

import cloud.tallercloud.persistence.entity.Project;
import cloud.tallercloud.persistence.repository.ProjectRepository;
import cloud.tallercloud.services.ProjectService;
import cloud.tallercloud.services.ProjectServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ProjectServiceMock {
    @Mock
    private ProjectServiceImpl projectServiceImpl;
    @Test
    public void when_findAllService_return_ListProject(){
        Project project= Project.builder()
                .projectName("Prueba Test")
                .projectIdentifier("412123")
                .description("Prueba para testear el guardado de proyectos")
                .startDate("2021-01-04")
                .endDate("2021-01-10")
                .backlog( null)
                .build();
        projectServiceImpl.save(project);
        List<Project> projects = projectServiceImpl.findAll();
        Assertions.assertThat(projects.size()).isEqualTo(1);
    }
}
