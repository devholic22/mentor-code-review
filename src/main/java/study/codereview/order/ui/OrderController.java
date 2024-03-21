package study.codereview.order.ui;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.codereview.order.application.OrderService;
import study.codereview.order.application.dto.OrderCreateRequest;

@RequiredArgsConstructor
@RequestMapping("/api/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody @Valid final OrderCreateRequest request) {
        orderService.createOrder(request);
        return ResponseEntity.ok().build();
    }
}
