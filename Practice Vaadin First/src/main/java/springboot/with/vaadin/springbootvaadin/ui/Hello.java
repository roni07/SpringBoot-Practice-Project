package springboot.with.vaadin.springbootvaadin.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import springboot.with.vaadin.springbootvaadin.product.Product;
import springboot.with.vaadin.springbootvaadin.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@SpringUI
public class Hello extends UI {

    private ProductService productService;

    public Hello(ProductService productService) {
        super();
        this.productService = productService;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        Grid<Product> productGrid = new Grid<>();
        productGrid.setItems(productService.getAllProduct());
        productGrid.addColumn(Product::getProductId).setCaption("Product ID");
        productGrid.addColumn(Product::getProductName).setCaption("Product Name");
        productGrid.addColumn(Product::getUnitPrice).setCaption("Unit Price");



        Label label = new Label("Welcome");
        Button button = new Button("Press");

        Button done = new Button("Done");

        button.addClickListener(clickEvent -> {
           label.setValue("Yes");
           Notification.show("PRESSED");
        });

        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(label);
        horizontalLayout.addComponent(button);


        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponent(productGrid);

        verticalLayout.addComponent(done);

        setContent(verticalLayout);
    }
}
