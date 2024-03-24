package study.codereview.order.ui;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.codereview.order.application.OrderQueryService;
import study.codereview.order.application.OrderService;
import study.codereview.order.application.dto.OrderCreateRequest;
import study.codereview.order.ui.infrastructure.dto.OrderCreateResponse;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/api/orders")
@RestController
public class OrderController {

    private final OrderService orderService;
    private final OrderQueryService orderQueryService;

    // TODO: CQRS를 적용하여 어떤 문제를 해결했나? => 아무것도 없다. 오히려 복잡도만 증가함.
    // 일단은 걷어보자.
    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody @Valid final OrderCreateRequest request) {
        Long orderId = orderService.createOrder(request);
        return ResponseEntity.created(URI.create("/api/orders/" + orderId))
                .build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderCreateResponse> findCreatedOrder(@PathVariable final Long orderId) {
        OrderCreateResponse response = orderQueryService.findCreatedOrder(orderId);
        return ResponseEntity.ok()
                .body(response);
    }
}
