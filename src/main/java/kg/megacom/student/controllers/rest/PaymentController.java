package kg.megacom.student.controllers.rest;

import kg.megacom.student.models.enums.PaymentStatus;
import kg.megacom.student.services.PaymentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/student/v1")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public Object pay(@RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd")Date paymentDate,
                      @RequestParam Long groupId,
                      @RequestParam Long studentId,
                      @RequestParam double payment
    ){
        return paymentService.payment(paymentDate,groupId,studentId,payment);
    }
}
