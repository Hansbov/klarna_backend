package exjobb.klarna_backend;


public class PaymentTokenNotFoundException extends RuntimeException {

    public PaymentTokenNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}