package by.kladvirov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodCreationDto {

    private String name;

    private BigDecimal price;

    private LocalDate createDate;

    private LocalDate expirationDate;

    private Boolean isAvailable;

}
