package kg.megacom.student.services.impls;

import kg.megacom.student.domains.GroupsRepo;
import kg.megacom.student.domains.StudentGroupsRepo;
import kg.megacom.student.domains.StudentRepo;
import kg.megacom.student.models.StudentGroups;
import kg.megacom.student.models.Students;
import kg.megacom.student.models.enums.StudentStatus;
import kg.megacom.student.services.StudentGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {
    private final StudentRepo studentRepo;
    private final GroupsRepo groupsRepo;
    private final StudentGroupsRepo studentGroupsRepo;

    public StudentGroupServiceImpl(StudentRepo studentRepo, GroupsRepo groupsRepo, StudentGroupsRepo studentGroupsRepo) {
        this.studentRepo = studentRepo;
        this.groupsRepo = groupsRepo;
        this.studentGroupsRepo = studentGroupsRepo;
    }


    @Override
    public ResponseEntity create(Date startDate, Date endDate,
                                 Long studentId, Long groupId) {
        try {
            Students student = studentRepo.findById(studentId).get();
            if(student.isDeleted()){
                return ResponseEntity.ok("Student is deleted");
            }
            StudentGroups studentGroups = new StudentGroups();
            studentGroups.setStudents(student);
            studentGroups.setGroups(groupsRepo.findById(groupId).get());
            studentGroups.setStartDate(startDate);
            studentGroups.setEndDate(endDate);
            studentGroups.setStudentStatus(StudentStatus.STUDIES);
            return ResponseEntity.ok(studentGroupsRepo.save(studentGroups));
        } catch(Exception e){
            return ResponseEntity.ok("Group doesn't exists");
        }
    }
}
