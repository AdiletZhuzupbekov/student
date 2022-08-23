package kg.megacom.student.mappers;

import kg.megacom.student.models.Groups;
import kg.megacom.student.models.Students;
import kg.megacom.student.models.dto.GroupsDto;
import kg.megacom.student.models.dto.StudentsDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class GroupMapper {

    private final ModelMapper modelMapper;

    public Groups toEntity(GroupsDto groupsDto){
        return Objects.isNull(groupsDto) ? null : modelMapper.map(groupsDto,Groups.class);
    }
}
