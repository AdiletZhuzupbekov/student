package kg.megacom.student.services;

import kg.megacom.student.models.Groups;
import kg.megacom.student.models.dto.GroupsDto;

public interface GroupService {
    Groups toEntity(GroupsDto groupsDto);
}
