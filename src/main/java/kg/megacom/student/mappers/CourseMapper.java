package kg.megacom.student.mappers;

import kg.megacom.student.models.Courses;
import kg.megacom.student.models.Groups;
import kg.megacom.student.models.dto.CourseDto;
import kg.megacom.student.models.dto.GroupsDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CourseMapper {

    private final ModelMapper modelMapper;

    public Courses toEntity(CourseDto courseDto){
        return Objects.isNull(courseDto) ? null : modelMapper.map(courseDto,Courses.class);
    }
}
