package kg.megacom.student.services.impls;

import kg.megacom.student.domains.*;
import kg.megacom.student.models.*;
import kg.megacom.student.models.enums.PaymentStatus;
import kg.megacom.student.models.enums.StudentStatus;
import kg.megacom.student.models.requests.StudentCreateRequest;
import kg.megacom.student.services.GroupService;
import kg.megacom.student.services.StudentsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentsServiceImpl implements StudentsService {
    private final StudentRepo studentRepo;
    private final StudentGroupsRepo studentGroupsRepo;
    private final GroupService groupService;
    private final CoursesRepo coursesRepo;
    private final LessonsRepo lessonsRepo;
    private final PaymentsRepo paymentsRepo;
    public StudentsServiceImpl(StudentRepo studentRepo,
                               StudentGroupsRepo studentGroupsRepo,
                               GroupService groupService,
                               CoursesRepo coursesRepo,
                               LessonsRepo lessonsRepo,
                               PaymentsRepo paymentsRepo) {
        this.studentRepo = studentRepo;
        this.studentGroupsRepo = studentGroupsRepo;
        this.groupService = groupService;
        this.coursesRepo = coursesRepo;
        this.lessonsRepo = lessonsRepo;
        this.paymentsRepo = paymentsRepo;
    }

    @Override
    public Students createStudent(StudentCreateRequest studentCreateRequest) {
        Students student = new Students();
        student.setName(studentCreateRequest.getName());
        student.setSurName(studentCreateRequest.getSureName());
        student.setTitle(studentCreateRequest.getTitle());
        studentRepo.save(student);
        Groups group = groupService.findById(studentCreateRequest.getGroupId());


        //adding value to the StudentGroups table

         StudentGroups studentGroups = new StudentGroups();
               studentGroups.setStartDate(group.getStartDate());
               studentGroups.setEndDate(group.getEndDate());
               studentGroups.setStudents(student);
               studentGroups.setGroups(group);
               studentGroups.setStudentStatus(StudentStatus.STUDIES);
               studentGroupsRepo.save(studentGroups);

               //generating payments

        Courses courses = coursesRepo.findById(group.getCourses().getId()).orElseThrow();
        List<Lessons> lessons = lessonsRepo.findAllByGroups_Id(group.getId());

        for (int i = 0; i <courses.getDuration(); i+=courses.getPeriod()){
                Payments payment = new Payments();
                payment.setPaymentDate(lessons.get(i).getDay());
                payment.setStudents(student);
                payment.setGroups(group);
                if (lessons.get(i).getDay().after(new Date())) {
                    payment.setPaymentStatus(PaymentStatus.UNPAID);
                }else
                    payment.setPaymentStatus(PaymentStatus.PAID);
                paymentsRepo.save(payment);
        }


               return student;


    }

    @Override
    public Object updateStudent(Long id, String title) {
        studentRepo.update(id,title);

        return studentRepo.findById(id).get();
    }

    @Override
    public List<Students> listOfStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Students findById(Long studentId) {
        return studentRepo.findById(studentId).orElseThrow();
    }

}
