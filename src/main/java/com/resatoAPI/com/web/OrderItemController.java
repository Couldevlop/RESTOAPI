package com.resatoAPI.com.web;

import com.resatoAPI.com.dto.OrderItemDTO;
import com.resatoAPI.com.service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resto/api/orderitems")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }


    @PostMapping
    public ResponseEntity<OrderItemDTO> save(@RequestBody OrderItemDTO dto){
        return ResponseEntity.ok(orderItemService.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(orderItemService.findById(id));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<OrderItemDTO> update(@PathVariable Long id, @RequestBody OrderItemDTO dto){
        return ResponseEntity.ok(orderItemService.update(id, dto));
    }


    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> getAll(){
        return ResponseEntity.ok(orderItemService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteById(@PathVariable Long id){
        return ResponseEntity.ok("Supprimé avec succès");
    }
}
