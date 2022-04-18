package exjobb.klarna_backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTokenRepository extends JpaRepository<PaymentToken,Long> {
}
