package exjobb.klarna_backend.controller;

import exjobb.klarna_backend.services.KlarnaIntegration;
//import net.minidev.json.JSONObject;
import exjobb.klarna_backend.data.PaymentToken;
import exjobb.klarna_backend.data.PaymentTokenRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import org.json.JSONObject;
import java.sql.Date;

import java.time.LocalDate;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
public class KlarnaCallController {
    private KlarnaIntegration klarnaIntegration;
    private final PaymentTokenRepository repository;
    KlarnaCallController(PaymentTokenRepository repository){
        this.klarnaIntegration = new KlarnaIntegration();
        this.repository=repository;
    }
    @CrossOrigin(origins = "https://localhost:3000")
    @PostMapping("/order")
    public  @ResponseBody Mono<String> newOrder(@RequestBody Object req){

        return this.klarnaIntegration.createOrder(req);
    }

    @CrossOrigin(origins = "https://localhost:3000")
    @GetMapping("/order/{orderId}")
    public @ResponseBody Mono<String> getOrder(@PathVariable(value="orderId") String id){
        return this.klarnaIntegration.fetchOrder(id);
    }

    @CrossOrigin(origins = "https://localhost:3000")
    @GetMapping("/checkout/{orderId}")
    public @ResponseBody Object checkoutOrder(@PathVariable(value="orderId") String id){


        String result = this.klarnaIntegration.fetchOrder(id).block();

        if(result != null && result.contains("recurring_token")){
            PaymentToken paymentToken = new PaymentToken();
            JSONObject json = new JSONObject(result);
            paymentToken.setCustomerToken(json.getString("recurring_token"));
            LocalDate today = LocalDate.now();
            LocalDate date = today;//.plusMonths(1);
            paymentToken.setPaymentDate(Date.valueOf(date));

            repository.save(paymentToken);
        }

        return (Object) result;

    }
}
