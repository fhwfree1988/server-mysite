package com.project.site.config.DataInsertion;

import com.project.site.Modules.Product.model.entity.Product;
import com.project.site.Modules.Product.model.entity.ProductCost;
import com.project.site.Modules.Product.repository.ProductCostRepository;
import com.project.site.Modules.Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductData {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCostRepository productCostRepository;

    public void loadData() {

        if (productRepository.findAll().size() == 0) {
            int count = 0;
            while (count < 10) {

                Product product = Product.builder().id((long) (count+2))
                        .productName("P_" + count)
                        .isActive(true)
                        .build();
                product = productRepository.save(product);

                ProductCost productCost = ProductCost.builder()
                        .product(product)
                        .Cost(count*20)
                        .isActive(true)
                        .build();
                productCostRepository.save(productCost);
                count++;

            }
        }
    }

//    public CommandLineRunner loadData(ProductRepository productRepository){
//        return (args) ->{
//            if(productRepository.findAll().size() == 0) {
//                int count = 0;
//                while (count < 10) {
//                    Product user = Product.builder()
//                            .productName("P1")
//                            .isActive(true)
//                            .build();
//                    productRepository.save(user);
//                    count++;
//                }
//            }
//
//            /*DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            Date date = new Date();
//            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            Reservation reservation = Reservation.builder()
//                    .reservationDate(localDate)
//                    .startTime(LocalTime.of(12, 00))
//                    .endTime(LocalTime.of(13, 00))
//                    .user(user)
//                    .amenityType(Types.AmenityType.POOL)
//                    .build();
//
//            reservationRepository.save(reservation);*/
//        };
//    }
}
