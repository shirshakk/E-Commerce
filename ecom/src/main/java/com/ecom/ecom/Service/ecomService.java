package com.ecom.ecom.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.ecom.model.ecomModel;

import jakarta.transaction.Transactional;

import com.ecom.ecom.Repo.ecomRepo;

@Service
public class ecomService {
    @Autowired
    private ecomRepo ecomRepo;
    public void saveProduct(ecomModel product , MultipartFile fileImage) {
        
        product.setImageName(fileImage.getOriginalFilename());
        product.setImageDescription(fileImage.getContentType());
        try {
            product.setImage(fileImage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ecomRepo.save(product);
    }
    public List<ecomModel> getAllProduct(){
        return ecomRepo.findAll();
    }
    @Transactional
    public List<ecomModel> searchProduct(String device){
        return ecomRepo.findByproductCategory(device);
    }
}