package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
   private final ProductRepository productRepository;
    public DataSeeder(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //clear all tha existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        //Create Categories
        Category electronics = new Category();
        electronics.setName("Electronics");
        Category clothing = new Category();
        clothing.setName("Clothing");
        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,home,clothing));

        //create products

        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest model smartphone with amazing features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(25000.00);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("GamingLaptop");
        laptop.setDescription("Latest model GamingLaptop with amazing features");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(60000.00);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Warm cozy jacket for winter is coming...");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(2500.00);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("blender for milkshakes and smoothies");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(250.00);
        blender.setCategory(home);
        productRepository.saveAll(Arrays.asList(phone,laptop,jacket,blender));

    }
}
