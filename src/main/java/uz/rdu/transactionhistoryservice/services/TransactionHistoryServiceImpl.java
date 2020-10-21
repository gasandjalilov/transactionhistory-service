package uz.rdu.transactionhistoryservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.rdu.transactionhistoryservice.interfaces.RequestProcedures;
import uz.rdu.transactionhistoryservice.interfaces.TransactionHistoryService;
import uz.rdu.transactionhistoryservice.models.Request;
import uz.rdu.transactionhistoryservice.models.Response;
import uz.rdu.transactionhistoryservice.models.history.P2p_in;
import uz.rdu.transactionhistoryservice.models.history.P2p_out;
import uz.rdu.transactionhistoryservice.models.history.Payment;
import uz.rdu.transactionhistoryservice.reposiories.RequestRepositories;
import uz.rdu.transactionhistoryservice.reposiories.ResponseRepositories;

import java.util.List;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    @Autowired
    RequestProcedures requestProcedures;

    @Autowired
    RequestRepositories requestRepositories;

    @Autowired
    ResponseRepositories responseRepositories;


    @Override
    public ResponseEntity<Response> getLast10Payments(Request request) {
        request = requestRepositories.save(request);
        Response response = new Response();
        response.setRequest_id(request.getId());
        List<Payment> responseList = requestProcedures.getLast10Payments(request);
        ResponseEntity<Response> responseEntity;

        if(responseList.isEmpty()) {
            response.setCode(-1);
            responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        else{
            response.setCode(1);
            response.setBody(requestProcedures.getLast10Payments(request));
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        }
        responseRepositories.save(response);
        return responseEntity;
    }

    @Override
    public ResponseEntity<Response> getInP2PFor30Days(Request request) {
        request = requestRepositories.save(request);
        Response response = new Response();
        response.setRequest_id(request.getId());
        List<P2p_in> responseList = requestProcedures.getInP2PFor30Days(request);
        ResponseEntity<Response> responseEntity;

        if(responseList.isEmpty()) {
            response.setCode(-1);
            responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }
        else{
            response.setCode(1);
            response.setBody(requestProcedures.getLast10Payments(request));
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        }
        responseRepositories.save(response);
        return responseEntity;
    }

    @Override
    public ResponseEntity<Response> getOutP2PFor30Days(Request request) {
        request = requestRepositories.save(request);
        Response response = new Response();
        response.setRequest_id(request.getId());
        List<P2p_out> responseList = requestProcedures.getOutP2PFor30Days(request);
        ResponseEntity<Response> responseEntity;
        if(responseList.isEmpty()){
            response.setCode(-1);
            responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        else{
            response.setCode(1);
            response.setBody(requestProcedures.getLast10Payments(request));
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        }
        responseRepositories.save(response);
        return responseEntity;
    }
}
