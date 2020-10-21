package uz.rdu.transactionhistoryservice.models.history;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    private Long rownum;

    private String account;

    private String amount;

    private String pay_date;
}
