package cloud.tallercloud.persistence.repository;

import cloud.tallercloud.persistence.entity.Backlog;
import cloud.tallercloud.persistence.entity.ProjectTask;
import cloud.tallercloud.persistence.entity.Project;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog,Long> {

    @Override
    List<Backlog> findAll();

    @ReadOnlyProperty
    @Query(value = "SELECT project_identifier FROM project where project_identifier =:identifier", nativeQuery = true)
    String findProjectIdentifier(String identifier);
}
