package uz.rdu.transactionhistoryservice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.rdu.transactionhistoryservice.interfaces.TransactionHistoryService;
import uz.rdu.transactionhistoryservice.models.Request;
import uz.rdu.transactionhistoryservice.models.history.P2p_in;
import uz.rdu.transactionhistoryservice.models.history.P2p_out;
import uz.rdu.transactionhistoryservice.models.history.Payment;

import java.util.List;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {
    @Override
    public ResponseEntity<List<Payment>> getLast10Payments(Request request) {
        return null;
    }

    @Override
    public ResponseEntity<List<P2p_in>> getInP2PFor30Days(Request request) {
        return null;
    }

    @Override
    public ResponseEntity<List<P2p_out>> getOutP2PFor30Days(Request request) {
        return null;
    }
}
