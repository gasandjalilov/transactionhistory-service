package uz.rdu.transactionhistoryservice.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import uz.rdu.transactionhistoryservice.models.Request;
import uz.rdu.transactionhistoryservice.models.Response;


public interface TransactionController {

    ResponseEntity<Response> getLast10Payments(Request request);

    ResponseEntity<Response> getInP2PFor30Days(Request request);

    ResponseEntity<Response> getOutP2PFor30Days(Request request);
}
