package kg.megacom.student.services.impls;

import kg.megacom.student.domains.GroupsRepo;
import kg.megacom.student.mappers.GroupMapper;
import kg.megacom.student.models.Groups;
import kg.megacom.student.models.dto.GroupsDto;
import kg.megacom.student.services.GroupService;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupMapper groupMapper;
    private final GroupsRepo groupsRepo;

    public GroupServiceImpl(GroupMapper groupMapper, GroupsRepo groupsRepo) {
        this.groupMapper = groupMapper;
        this.groupsRepo = groupsRepo;
    }

    @Override
    public Groups toEntity(GroupsDto groupsDto) {
        Groups groups = groupMapper.toEntity(groupsDto);
        groupsRepo.save(groups);
        return groups;
    }
}
