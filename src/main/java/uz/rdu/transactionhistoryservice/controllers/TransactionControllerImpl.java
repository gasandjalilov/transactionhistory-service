package uz.rdu.transactionhistoryservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import uz.rdu.transactionhistoryservice.interfaces.TransactionController;
import uz.rdu.transactionhistoryservice.interfaces.TransactionHistoryService;
import uz.rdu.transactionhistoryservice.models.Request;
import uz.rdu.transactionhistoryservice.models.Response;

public class TransactionControllerImpl implements TransactionController {

    @Autowired
    TransactionHistoryService transactionHistoryService;

    @Override
    public ResponseEntity<Response> getLast10Payments(Request request) {
        return transactionHistoryService.getLast10Payments(request);
    }

    @Override
    public ResponseEntity<Response> getInP2PFor30Days(Request request) {
        return transactionHistoryService.getInP2PFor30Days(request);
    }

    @Override
    public ResponseEntity<Response> getOutP2PFor30Days(Request request) {
        return transactionHistoryService.getOutP2PFor30Days(request);
    }
}
