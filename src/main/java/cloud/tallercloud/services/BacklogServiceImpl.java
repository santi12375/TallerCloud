package cloud.tallercloud.services;

import cloud.tallercloud.persistence.entity.Backlog;
import cloud.tallercloud.persistence.repository.BacklogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BacklogServiceImpl implements BacklogService{

    private final BacklogRepository backlogRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Backlog backlog) {
        backlogRepository.save(backlog);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Backlog> findAll() {
        return backlogRepository.findAll();
    }



}
