package uz.rdu.transactionhistoryservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TransactionHistoryRequest")
public class Request implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2787642343491099993L;

	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue
	private UUID id;
	
	private String msisdn;

    @JsonInclude(Include.NON_NULL)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date ins_date;
}
