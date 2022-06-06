package cloud.tallercloud.persistence.repository;

import cloud.tallercloud.persistence.entity.Backlog;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog,Long> {

    @Override
    List<Backlog> findAll();

    List<Backlog> findBacklogByProjectIdentifier(String projectIdentifier);

    List<Backlog> findBacklogByProjectId(Long projectId);

    List<Backlog> findBacklogById(Long backlogId);

}
