package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CartItemRequest;
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.security.UserPrincipal;
import com.example.ecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor

public class CartController {

    private final CartService cartService;

    @GetMapping
    public Cart getMyCart(@AuthenticationPrincipal UserPrincipal principal) {
        return cartService.getCartForUser(principal.getUser().getId());
    }

    @PostMapping("/items")
    public Cart addItem(@AuthenticationPrincipal UserPrincipal principal, @RequestBody CartItemRequest request) {
        return cartService.addItemToCart(principal.getUser().getId(), request);
    }

    @PutMapping("/items/{itemId}")
    public Cart updateItem(@AuthenticationPrincipal UserPrincipal principal, @PathVariable Long itemId, @RequestParam Integer quantity){
        return  cartService.updateItemQuantity(principal.getUser().getId(), itemId, quantity);
    }

    @DeleteMapping("/items/{itemId}")
    public Cart removeItem(@AuthenticationPrincipal UserPrincipal principal, @PathVariable Long itemId){
        return  cartService.removeItem(principal.getUser().getId(), itemId);
    }
}
