package spring_context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> selectedProducts;
    private ProductRepository productRepository;

    @PostConstruct
    public void init(){
        selectedProducts = new ArrayList<>();
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProductById(long id){
        selectedProducts.add(productRepository.getProductById(id));
        System.out.println("Добавлен " + productRepository.getProductById(id).getTitle());
    }

    public void addAllProducts(){
        selectedProducts.addAll(productRepository.getRepository());
        System.out.println("Добавлено по 1 продукиту каждого вида");
    }

    public void deleteProductById(long id){
        if(selectedProducts.size() != 0){
            selectedProducts = selectedProducts.stream().filter(p -> p.getId() != id).collect(Collectors.toList());
                System.out.println("Удален " + productRepository.getProductById(id).getTitle());
        }

        else{
            System.out.println("Продукт не найден");
        }
    }

    public void deleteAllProducts(){
        selectedProducts.clear();
        System.out.println("Очищена корзина");
    }

    public void writeCartContains(){

        int count = 0;

        if(selectedProducts.size() != 0){
            for(Product p : selectedProducts){
                System.out.println(++count + " " + p.getId() + " " + p.getTitle() + " " + p.getCost());
            }
        }
        else {
            System.out.println("\n\nВ корзине нет ничего!");
        }
    }
}
