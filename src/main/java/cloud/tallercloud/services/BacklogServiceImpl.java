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
    private List<Backlog> backlogList;

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

    @Override
    public boolean findBacklogsByProjectIdentifier(String projectIdentifier) {
        backlogList = backlogRepository.findBacklogByProjectIdentifier(projectIdentifier);
        return !backlogList.isEmpty();
    }

    @Override
    public boolean findBacklogByProjectId(Long projectId) {
        backlogList = backlogRepository.findBacklogByProjectId(projectId);
        return !backlogList.isEmpty();
    }

    @Override
    public boolean findBacklogById(Long backlogId) {
        backlogList = backlogRepository.findBacklogById(backlogId);
        return backlogList.isEmpty();
    }

}
