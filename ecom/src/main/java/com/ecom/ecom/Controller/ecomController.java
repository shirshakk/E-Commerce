package com.ecom.ecom.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestPart;

import com.ecom.ecom.Service.ecomService;
import com.ecom.ecom.model.ecomModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ecomController {
    @Autowired
    private ecomService ecomService;
    @PostMapping("addProduct")
public void addProduct(@RequestPart("entity") String entity, @RequestPart("fileImage") MultipartFile fileImage) {
    System.out.println("Received file: " + fileImage.getOriginalFilename());
    ObjectMapper mapper = new ObjectMapper();
    ecomModel product = null;
    try {
        product = mapper.readValue(entity, ecomModel.class);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
        throw new RuntimeException("Invalid JSON format for 'entity'");
    }
    ecomService.saveProduct(product, fileImage);
}

    @GetMapping("product")
    public List<ecomModel> getAllproduct() {
        return ecomService.getAllProduct();
    }
    @GetMapping("product/category/{device}")
    public List<ecomModel> Search(@PathVariable String device) {
        return ecomService.searchCategory(device);
    }
    @GetMapping("/product/search")
    public List<ecomModel> getMethodName(@RequestParam("query") String query) {
        System.out.println(query);
        return ecomService.searchProduct(query);
    }
    
}
