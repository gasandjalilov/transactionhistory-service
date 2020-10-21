package uz.rdu.transactionhistoryservice.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.rdu.transactionhistoryservice.interfaces.RequestProcedures;
import uz.rdu.transactionhistoryservice.models.Request;
import uz.rdu.transactionhistoryservice.models.history.P2p_in;
import uz.rdu.transactionhistoryservice.models.history.P2p_out;
import uz.rdu.transactionhistoryservice.models.history.Payment;
import uz.rdu.transactionhistoryservice.reposiories.RequestRepositories;
import uz.rdu.transactionhistoryservice.reposiories.ResponseRepositories;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class ProcedureRequestsImpl implements RequestProcedures {
    private EntityManagerFactory emf;

    @Autowired
    RequestRepositories reqRepository;

    @Autowired
    ResponseRepositories respRepository;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public List<Payment> getLast10Payments(Request request) {
        EntityManager em = emf.createEntityManager();
        StoredProcedureQuery str = em.createStoredProcedureQuery("client_cmpgn.PKG_CMPGN_UTOLOV_APP.get_last_payments")
                .registerStoredProcedureParameter("p_msisdn", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_cur", void.class, ParameterMode.REF_CURSOR)
                .setParameter("p_msisdn", request.getMsisdn());

        str.execute();
        List<Object[]> rows = str.getResultList();
        List<Payment> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            log.info("getLast10Payments: Object : {} , {}",row[1], row[2]);
            result.add(new Payment(((BigDecimal) row[0]).longValue(),
                    (String) row[1].toString(),
                    (String) row[2].toString(),
                    (String) row[3].toString()));

        }
        em.clear();
        em.close();

        return result;
    }

    @Override
    public List<P2p_in> getInP2PFor30Days(Request request) {
        EntityManager em = emf.createEntityManager();
        StoredProcedureQuery str = em.createStoredProcedureQuery("client_cmpgn.PKG_CMPGN_UTOLOV_APP.get_last_p2p_in")
                .registerStoredProcedureParameter("p_msisdn", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_cur", void.class, ParameterMode.REF_CURSOR)
                .setParameter("p_msisdn", request.getMsisdn());

        str.execute();
        List<Object[]> rows = str.getResultList();
        List<P2p_in> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {

            result.add(new P2p_in((String) row[1].toString(),
                    (String) row[2].toString(),
                    (String) row[3].toString()));

        }
        em.clear();
        em.close();

        return result;
    }

    @Override
    public List<P2p_out> getOutP2PFor30Days(Request request) {
        EntityManager em = emf.createEntityManager();
        StoredProcedureQuery str = em.createStoredProcedureQuery("client_cmpgn.PKG_CMPGN_UTOLOV_APP.get_last_p2p_out")
                .registerStoredProcedureParameter("p_msisdn", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_cur", void.class, ParameterMode.REF_CURSOR)
                .setParameter("p_msisdn", request.getMsisdn());

        str.execute();
        List<Object[]> rows = str.getResultList();
        List<P2p_out> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {

            result.add(new P2p_out((String) row[1].toString(),
                    (String) row[2],
                    (String) row[3]));

        }
        em.clear();
        em.close();

        return result;
    }
}
