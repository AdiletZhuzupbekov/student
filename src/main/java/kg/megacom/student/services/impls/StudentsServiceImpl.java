package kg.megacom.student.services.impls;

import kg.megacom.student.domains.StudentRepo;
import kg.megacom.student.mappers.StudentMapper;
import kg.megacom.student.models.Students;
import kg.megacom.student.models.dto.StudentsDto;
import kg.megacom.student.services.StudentsService;
import org.springframework.stereotype.Service;

@Service
public class StudentsServiceImpl implements StudentsService {
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;
    public StudentsServiceImpl(StudentRepo studentRepo, StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }

    @Override
    public Students createStudent(StudentsDto students) {
        Students student = studentMapper.toEntity(students);
        return studentRepo.save(student);
    }

    @Override
    public Object updateStudent(Long id, String title) {
        studentRepo.update(id,title);

        return studentRepo.findById(id).get();
    }

}
