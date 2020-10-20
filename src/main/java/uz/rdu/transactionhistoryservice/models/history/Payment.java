package uz.rdu.transactionhistoryservice.models.history;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    private int rownum;

    private String account;

    private String amount;

    private Date pay_date;
}
