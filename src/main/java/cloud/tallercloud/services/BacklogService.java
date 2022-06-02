package cloud.tallercloud.services;


import cloud.tallercloud.persistence.entity.Backlog;
import cloud.tallercloud.services.dto.BacklogInDTO;

import java.util.List;

public interface BacklogService {

    void save(BacklogInDTO backlogInDTO);

    List<Backlog> findAll();

}
