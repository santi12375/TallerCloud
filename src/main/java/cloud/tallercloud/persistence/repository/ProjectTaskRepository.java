package cloud.tallercloud.persistence.repository;

import cloud.tallercloud.persistence.entity.ProjectTask;
import cloud.tallercloud.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/* Heredamos de JpaRepository , primero ponemos la clase que vamos a gestionar
y luego el tipo de dato que maneja el campo primario de dicha clase*/


/*Si llegamos a esta capa es porque ya validamos toda la informacion*/
/*Orden:  Dominio(Entity) - Persistence - Service - Controllers*/
@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask,Long> {

    List<ProjectTask> findAllByTaskStatus(TaskStatus taskStatus);

}
