package kg.megacom.student.services.impls;

import kg.megacom.student.domains.StudentGroupsRepo;
import kg.megacom.student.models.Payments;
import kg.megacom.student.services.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final StudentGroupsRepo studentGroupsRepo;


    public PaymentServiceImpl(StudentGroupsRepo studentGroupsRepo) {
        this.studentGroupsRepo = studentGroupsRepo;
    }

//    @Bean
//    public List<Payments> paymentsGeneration(){
//
//    }
}
