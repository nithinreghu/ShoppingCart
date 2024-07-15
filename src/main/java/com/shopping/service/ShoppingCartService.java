package com.shopping.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.entity.Item;
import com.shopping.exception.ItemNotFoundException;
import com.shopping.model.ItemsDTO;
import com.shopping.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    private ObjectMapper objectMapper;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ObjectMapper objectMapper){
        this.shoppingCartRepository = shoppingCartRepository;
        this.objectMapper = objectMapper;
    }
    public ItemsDTO getItemByID(int id) throws ItemNotFoundException {
        Item itemEntity = shoppingCartRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("not correct id"));
        return objectMapper.convertValue(itemEntity, ItemsDTO.class);
    }

    public ItemsDTO createItem(ItemsDTO itemsDTO) throws ItemNotFoundException {
        Item itemEntity = shoppingCartRepository.save(objectMapper.convertValue(itemsDTO, Item.class));
        return getItemByID(itemEntity.getId());
    }

    public List<ItemsDTO> getItems() {
        List<Item> itemsEntity = shoppingCartRepository.findAll();
        return itemsEntity.stream().map(e -> objectMapper.convertValue(e, ItemsDTO.class)).collect(Collectors.toList());
    }
}
