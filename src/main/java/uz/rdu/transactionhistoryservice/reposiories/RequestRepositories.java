package uz.rdu.transactionhistoryservice.reposiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.rdu.transactionhistoryservice.models.Request;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
public interface RequestRepositories extends JpaRepository<Request, UUID> {

}
