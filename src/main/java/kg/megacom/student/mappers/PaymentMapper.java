package kg.megacom.student.mappers;

import kg.megacom.student.models.Payments;
import kg.megacom.student.models.dto.PaymentsDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PaymentMapper {
    private final ModelMapper modelMapper;

    public Payments toEntity(PaymentsDto paymentsDto){
        return Objects.isNull(paymentsDto) ? null : modelMapper.map(paymentsDto,Payments.class);
    }
}
