package springboot.book.springbootbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    private String streetAddress;
    private String country;
    private String city;
    private String postalCode;
}
