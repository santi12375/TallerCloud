package cloud.tallercloud.persistence.repository;

import cloud.tallercloud.persistence.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Override
    List<Project> findAll();

    List<Project> findProjectByProjectIdentifier(String identifier);

}
