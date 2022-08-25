package kg.megacom.student.services.impls;

import kg.megacom.student.domains.CoursesRepo;
import kg.megacom.student.mappers.CourseMapper;
import kg.megacom.student.models.Courses;
import kg.megacom.student.models.dto.CourseDto;
import kg.megacom.student.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final CoursesRepo coursesRepo;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CoursesRepo coursesRepo, CourseMapper courseMapper) {
        this.coursesRepo = coursesRepo;
        this.courseMapper = courseMapper;
    }

    @Override
    public Courses addCourse(CourseDto courseDto) {
        Courses course = courseMapper.toEntity(courseDto);
        coursesRepo.save(course);
        return course;
    }


    @Override
    public Courses findById(Long id) {
        return coursesRepo.findById(id).orElseThrow();
    }
}
