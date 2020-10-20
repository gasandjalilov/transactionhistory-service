package uz.rdu.transactionhistoryservice.reposiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.rdu.transactionhistoryservice.models.Response;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
public interface ResponseRepositories extends JpaRepository<Response, UUID> {
}
