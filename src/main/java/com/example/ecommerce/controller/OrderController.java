package com.example.ecommerce.controller;

import com.example.ecommerce.dto.OrderRequest;
import com.example.ecommerce.dto.OrderStatusRequest;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.security.UserPrincipal;
import com.example.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public Order placeOrder(@AuthenticationPrincipal UserPrincipal principal, @RequestBody OrderRequest request) {
        return  orderService.placeOrder(principal.getId(), principal.getUser(), request);
    }

    @GetMapping
    public List<Order> getMyOrders(@AuthenticationPrincipal UserPrincipal principal) {
        return orderService.getOrdersForUser(principal.getId());
    }

    @GetMapping("/admin/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/admin/{id}/status")
    public Order updateOrderStatus(@PathVariable Long id, @RequestBody OrderStatusRequest request) {
        return orderService.updateOrderStatus(id, request.getStatus());
    }
}
