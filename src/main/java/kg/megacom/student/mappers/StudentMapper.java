package kg.megacom.student.mappers;

import kg.megacom.student.models.Students;
import kg.megacom.student.models.dto.StudentsDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final ModelMapper modelMapper;

    public Students toEntity(StudentsDto studentsDto){
        return Objects.isNull(studentsDto) ? null : modelMapper.map(studentsDto,Students.class);
    }
    public StudentsDto toDTO(Students students){
        return Objects.isNull(students) ? null : modelMapper.map(students,StudentsDto.class);
    }
    public List<Students> listToEntity(List<StudentsDto> studentsDtos){
        return studentsDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}

