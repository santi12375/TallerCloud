package cloud.tallercloud.services;


import cloud.tallercloud.persistence.entity.Backlog;

import java.util.List;

public interface BacklogService {

    void save(Backlog backlog);

    List<Backlog> findAll();



}
