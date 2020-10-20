package uz.rdu.transactionhistoryservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "TransactionHistoryResponse")
public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -402611711090142195L;

	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue
	private UUID id;
	
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private UUID request_id;
	
    @JsonInclude(Include.NON_NULL)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date ins_date;
    
    private int code;
    
    @JsonIgnore
    private String message;
    
    @Transient
    private Object body;
}
