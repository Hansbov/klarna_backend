package exjobb.klarna_backend.controller;

import exjobb.klarna_backend.KlarnaIntegration;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class KlarnaCallController {
    KlarnaIntegration klarnaIntegration;
    KlarnaCallController(){
        this.klarnaIntegration = new KlarnaIntegration();
    }
    @PostMapping("/order")
    public  @ResponseBody Mono<String> newOrder(@RequestBody JSONObject req){
        return this.klarnaIntegration.createOrder(req);
    }

    @GetMapping("/order/{orderId}")
    public @ResponseBody Mono<String> getOrder(@PathVariable(value="orderId") String id){
        return this.klarnaIntegration.fetchOrder(id);
    }

}
