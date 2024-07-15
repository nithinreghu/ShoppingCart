package com.shopping.controller;

import com.shopping.exception.ItemNotFoundException;
import com.shopping.model.ItemsDTO;
import com.shopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/item/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<ItemsDTO> getItem(@PathVariable int id) throws ItemNotFoundException {
        return new ResponseEntity<>(shoppingCartService.getItemByID(id), HttpStatus.OK) ;
    }

    @GetMapping("/item/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
    public ResponseEntity<List<ItemsDTO>> getItems() {
        return new ResponseEntity<>(shoppingCartService.getItems(), HttpStatus.OK) ;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ItemsDTO>  createItem(@RequestBody ItemsDTO itemsDTO) throws ItemNotFoundException {
        return  new ResponseEntity<>(shoppingCartService.createItem(itemsDTO), HttpStatus.CREATED);
    }
}
