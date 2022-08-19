package kg.megacom.student.services.impls;

import kg.megacom.student.domains.TeachersRepo;
import kg.megacom.student.models.Teachers;
import kg.megacom.student.services.TeachersService;
import org.springframework.stereotype.Service;

@Service
public class TeachersServiceImpl implements TeachersService {
    private final TeachersRepo teachersRepo;

    public TeachersServiceImpl(TeachersRepo teachersRepo) {
        this.teachersRepo = teachersRepo;
    }

    @Override
    public Teachers addTeacher(Teachers teachers) {
        return teachersRepo.save(teachers);
    }
}
