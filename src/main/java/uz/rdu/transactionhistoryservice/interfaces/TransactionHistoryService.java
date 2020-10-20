package uz.rdu.transactionhistoryservice.interfaces;

import org.springframework.http.ResponseEntity;
import uz.rdu.transactionhistoryservice.models.Request;
import uz.rdu.transactionhistoryservice.models.history.P2p_in;
import uz.rdu.transactionhistoryservice.models.history.P2p_out;
import uz.rdu.transactionhistoryservice.models.history.Payment;

import java.util.List;

public interface TransactionHistoryService {

    ResponseEntity<List<Payment>> getLast10Payments(Request request);

    ResponseEntity<List<P2p_in>> getInP2PFor30Days(Request request);

    ResponseEntity<List<P2p_out>> getOutP2PFor30Days(Request request);
}
