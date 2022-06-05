package cloud.tallercloud.persistence.repository;

import cloud.tallercloud.persistence.entity.ProjectTask;
import cloud.tallercloud.persistence.entity.TaskStatus;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/* Heredamos de JpaRepository , primero ponemos la clase que vamos a gestionar
y luego el tipo de dato que maneja el campo primario de dicha clase*/


/*Si llegamos a esta capa es porque ya validamos toda la informacion*/
/*Orden:  Dominio(Entity) - Persistence - Service - Controllers*/
@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask,Long> {

    //List<ProjectTask> findAllByTaskStatus(TaskStatus taskStatus);

    @ReadOnlyProperty
    @Query(value = "SELECT * FROM project_task where project_identifier =:identifier", nativeQuery = true)
    List<ProjectTask> findProjectTasksByProject(@Param("identifier")String identifier);

    @ReadOnlyProperty
    @Query(value = "SELECT SUM(hours) FROM project_task WHERE project_identifier =:identifier AND task_status !='deleted' ", nativeQuery = true)
    double GetHoursProject(@Param("identifier")String identifier);

    @ReadOnlyProperty
    @Query(value = "SELECT SUM(hours) FROM project_task WHERE project_identifier =:identifier AND task_status =:status ", nativeQuery = true)
    double GetHoursProjectStatus(@Param("identifier")String identifier,@Param("status") String status);

    @Modifying

    @Query(value = "UPDATE project_task SET task_status ='deleted'  WHERE id =:id and project_identifier =:identifier",nativeQuery = true)
    void markProjectTaskAsDeleted(@Param("id") Long id,@Param("identifier")String identifier);

}
