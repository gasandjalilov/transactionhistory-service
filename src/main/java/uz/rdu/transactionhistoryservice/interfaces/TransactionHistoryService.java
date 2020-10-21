package uz.rdu.transactionhistoryservice.interfaces;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.rdu.transactionhistoryservice.models.Request;
import uz.rdu.transactionhistoryservice.models.Response;
import uz.rdu.transactionhistoryservice.models.history.P2p_in;
import uz.rdu.transactionhistoryservice.models.history.P2p_out;
import uz.rdu.transactionhistoryservice.models.history.Payment;

import java.util.List;

public interface TransactionHistoryService {

    ResponseEntity<Response> getLast10Payments(Request request);

    ResponseEntity<Response> getInP2PFor30Days( Request request);

    ResponseEntity<Response> getOutP2PFor30Days(Request request);
}
