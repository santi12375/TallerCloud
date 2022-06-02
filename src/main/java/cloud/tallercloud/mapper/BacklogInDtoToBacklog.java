package cloud.tallercloud.mapper;

import cloud.tallercloud.persistence.entity.Backlog;
import cloud.tallercloud.services.dto.BacklogInDTO;

public class BacklogInDtoToBacklog implements IMapper<BacklogInDTO, Backlog> {
    @Override
    public Backlog map(BacklogInDTO in) {
        Backlog backlog = new Backlog();
        backlog.setProjectIdentifier(in.getProjectIdentifier());
        return backlog;
    }
}
