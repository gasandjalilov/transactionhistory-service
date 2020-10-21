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

@Controller
public interface TransactionHistoryService {

    @PostMapping(value = "/retrieveLastPayments",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response> getLast10Payments(@RequestBody Request request);

    @PostMapping(value = "/retrieveLastInP2P",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response> getInP2PFor30Days(@RequestBody Request request);

    @PostMapping(value = "/retrieveLastOutP2P",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response> getOutP2PFor30Days(@RequestBody Request request);
}
