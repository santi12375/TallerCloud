package cloud.tallercloud.persistence.repository;

import cloud.tallercloud.persistence.entity.Project;
import cloud.tallercloud.persistence.entity.ProjectTask;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Override
    List<Project> findAll();


}
