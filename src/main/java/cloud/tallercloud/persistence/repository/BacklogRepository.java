package cloud.tallercloud.persistence.repository;

import cloud.tallercloud.persistence.entity.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog,Long> {

    @Override
    List<Backlog> findAll();
}
