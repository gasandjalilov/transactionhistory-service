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
public class P2p_out implements Serializable {
    private String receiver_card;
    private String amount;
    private String p2p_date;
}
