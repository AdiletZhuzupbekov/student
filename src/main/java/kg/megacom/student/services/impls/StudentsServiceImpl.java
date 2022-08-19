package kg.megacom.student.services.impls;

import kg.megacom.student.domains.StudentRepo;
import kg.megacom.student.models.Students;
import kg.megacom.student.services.StudentsService;
import org.springframework.stereotype.Service;

@Service
public class StudentsServiceImpl implements StudentsService {
    private final StudentRepo studentRepo;

    public StudentsServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Students createStudent(Students students) {
        return studentRepo.save(students);
    }
}
