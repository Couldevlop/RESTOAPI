package com.resatoAPI.com.web;

import com.resatoAPI.com.dto.OrderDTO;
import com.resatoAPI.com.entity.Order;
import com.resatoAPI.com.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resto/api/orders")
@CrossOrigin(origins = "http://localhost:4000")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO dto){
        return ResponseEntity.ok(orderService.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrder(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO dto){
        return ResponseEntity.ok(orderService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ResponseEntity.ok("Supprimé avec succès");
    }

    @GetMapping("/total-sum")
    public ResponseEntity<Double> getTotalOrdersSum() {
        return ResponseEntity.ok(orderService.getTotalForServedOrders());
    }
}
