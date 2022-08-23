package kg.megacom.student.services.impls;

import kg.megacom.student.domains.TeachersRepo;
import kg.megacom.student.mappers.TeachersMapper;
import kg.megacom.student.models.Teachers;
import kg.megacom.student.models.dto.TeacherDto;
import kg.megacom.student.services.TeachersService;
import org.springframework.stereotype.Service;

@Service
public class TeachersServiceImpl implements TeachersService {
    private final TeachersRepo teachersRepo;
    private final TeachersMapper teachersMapper;

    public TeachersServiceImpl(TeachersRepo teachersRepo, TeachersMapper teachersMapper) {
        this.teachersRepo = teachersRepo;
        this.teachersMapper = teachersMapper;
    }

    @Override
    public Teachers addTeacher(TeacherDto teacherDto) {
        Teachers teacher = teachersMapper.fromDto(teacherDto);
        return teachersRepo.save(teacher);
    }

    @Override
    public void deleteTeacher(TeacherDto teacherDto) {
        Teachers teacher = teachersMapper.fromDto(teacherDto);
         teachersRepo.delete(teacher);
    }

    @Override
    public Object listTeacher() {
        return teachersRepo.findAll();
    }
}
