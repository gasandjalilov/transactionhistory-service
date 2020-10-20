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
public class P2p_in implements Serializable {

    private String sender_card;

    private String amount;

    private Date p2p_date;
}
