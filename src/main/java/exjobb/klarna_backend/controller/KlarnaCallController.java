package exjobb.klarna_backend.controller;

import exjobb.klarna_backend.KlarnaIntegration;
import org.springframework.web.bind.annotation.RestController;
import exjobb.klarna_backend.PaymentToken;
import exjobb.klarna_backend.PaymentTokenNotFoundException;
import exjobb.klarna_backend.PaymentTokenRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class KlarnaCallController {

    KlarnaCallController(){

    }
    @PostMapping("/order")
    Object newOrder(@RequestBody Object req){
        Object order = KlarnaIntegration.createOrder(req);
        return order;
    }

    @GetMapping("/order/{order_id}")
    Object getOrder(){
           return new Object();
    }

}
