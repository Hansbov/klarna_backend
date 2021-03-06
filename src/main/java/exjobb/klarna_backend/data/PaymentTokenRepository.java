package exjobb.klarna_backend.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PaymentTokenRepository extends JpaRepository<PaymentToken,Long> {

    List<PaymentToken> findByPaymentDate(Date date);
}
