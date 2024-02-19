package net.machichi.inventoryservice;

import net.machichi.inventoryservice.entities.Product;
import net.machichi.inventoryservice.inventoryservice.InventoryServiceApplication;
import net.machichi.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.UUID;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    public CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                            .name("Computer")
                            .price(42000)
                            .quantity(14)
                    .build());

            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Printer")
                    .price(2000)
                    .quantity(8)
                    .build());

            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Smart Phone")
                    .price(42000)
                    .quantity(20)
                    .build());
        };

    }
}