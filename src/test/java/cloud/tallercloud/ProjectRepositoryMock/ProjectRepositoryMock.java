package cloud.tallercloud.ProjectRepositoryMock;

import cloud.tallercloud.persistence.entity.Project;
import cloud.tallercloud.persistence.repository.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ProjectRepositoryMock {

    @Autowired
    private ProjectRepository projectRepository;
    @Test
    public void when_findAll_return_ListProject(){

        Project project= Project.builder()
                .projectName("Prueba Test")
                .projectIdentifier("44da99")
                .description("Prueba para testear el guardado de proyectos")
                .startDate("2021-01-04")
                .endDate("2021-01-10")
                .backlog( null)
                .build();
        projectRepository.save(project);
        List<Project> projects = projectRepository.findAll();
        Assertions.assertThat(projects.size()).isEqualTo(1);

    }
}
