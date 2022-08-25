package kg.megacom.student.services.impls;

import kg.megacom.student.domains.CoursesRepo;
import kg.megacom.student.domains.GroupsRepo;
import kg.megacom.student.domains.PaymentsRepo;
import kg.megacom.student.domains.StudentRepo;
import kg.megacom.student.mappers.PaymentMapper;
import kg.megacom.student.models.Courses;
import kg.megacom.student.models.Groups;
import kg.megacom.student.models.Payments;
import kg.megacom.student.models.Students;
import kg.megacom.student.models.enums.PaymentStatus;
import kg.megacom.student.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentsRepo paymentsRepo;
    private final PaymentMapper paymentMapper;
    private final GroupsRepo groupsRepo;
    private final StudentRepo studentRepo;
    private final CoursesRepo coursesRepo;

    public PaymentServiceImpl(PaymentsRepo paymentsRepo, PaymentMapper paymentMapper, GroupsRepo groupsRepo, StudentRepo studentRepo, CoursesRepo coursesRepo) {
        this.paymentsRepo = paymentsRepo;
        this.paymentMapper = paymentMapper;
        this.groupsRepo = groupsRepo;
        this.studentRepo = studentRepo;
        this.coursesRepo = coursesRepo;
    }


    @Override
    public Object payment(Date paymentDate, Long groupId, Long studentId, double payment) {
        Students student = studentRepo.findById(studentId).get();
        Groups groups = groupsRepo.findById(groupId).get();
        Courses courses = coursesRepo.findById(groups.getId()).get();
        double cost = courses.getPrice();
        double debt = student.getDebt();

        try {
            if(student.isDeleted()){
                return ResponseEntity.ok("Student is deleted");
            }
            Payments payments = new Payments();

            if (debt + payment == 0 ) {
                payments.setPaymentStatus(PaymentStatus.valueOf("DEBT"));
            }else if (debt + payment > 0 & debt + payment < cost){
                payments.setPaymentStatus(PaymentStatus.valueOf("PARTIALLY"));
                payment = payment + debt;
                payments.setPayment(payment);
            }else {
                payments.setPaymentStatus(PaymentStatus.valueOf("PAID"));
                payment = payment + debt;
                payments.setPayment(payment);
            }
            paymentsRepo.save(payments);
            return payments;
        }catch (Exception e){
            return ResponseEntity.ok("Group doesn't exists");
        }

    }
}
