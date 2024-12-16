package jwt.projectjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/product")
public class ProductController {

    @GetMapping
    public String getProduct() {
        return "<html>" +
                "<style>" +
                "body{ background-color: black}" +
                "h1{color: white}" +
                "</style>" +
                "<body>" +
                "<h1>Hello World</h1>" +
                "</body>" +
                "</html>";
    }
}
