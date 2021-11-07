package spring_context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> repository;

    @PostConstruct
    public void init(){
        repository = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 49),
                new Product(2L, "Chocolate", 89),
                new Product(3L, "Meat", 449),
                new Product(4L, "Mineral water", 59),
                new Product(5L, "Fish", 76)));
    }



    public List<Product> getRepository() {
        return repository;
    }

    public Product getProductById(long id){
        return repository.get((int) --id);
    }
}
