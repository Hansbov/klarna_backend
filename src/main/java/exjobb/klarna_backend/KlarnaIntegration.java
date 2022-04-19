package exjobb.klarna_backend;

import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class KlarnaIntegration {
    private final WebClient webClient;

    public KlarnaIntegration (){
        this.webClient = WebClient.create("https://api.playground.klarna.com");
    }
    public Mono<String> createOrder(Object req) {
        return this.webClient.post().uri("/checkout/v3/orders/")
                .header("Authorization","Basic "+System.getenv("credentials"))
                .bodyValue(req)
                .retrieve().bodyToMono(String.class);
    }

    public Mono<String> fetchOrder(String orderId) {
        return this.webClient.get()
                .uri("/checkout/v3/orders/" + orderId)
                .header("Authorization","Basic UEs1NTAyMF81ZTQ0MTZhZWU1M2M6Q2MwcEdYYmdlVkk4NmZkUw==")
                .retrieve().bodyToMono(String.class);
    }
}
