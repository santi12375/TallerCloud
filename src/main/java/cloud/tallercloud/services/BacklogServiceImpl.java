package cloud.tallercloud.services;

import cloud.tallercloud.mapper.BacklogInDtoToBacklog;
import cloud.tallercloud.persistence.entity.Backlog;
import cloud.tallercloud.persistence.repository.BacklogRepository;
import cloud.tallercloud.services.dto.BacklogInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BacklogServiceImpl implements BacklogService{

    private final BacklogRepository backlogRepository;
    private final BacklogInDtoToBacklog mapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(BacklogInDTO backlogInDTO) {
        Backlog backlog = mapper.map(backlogInDTO);
        backlogRepository.save(backlog);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Backlog> findAll() {
        return backlogRepository.findAll();
    }
}
