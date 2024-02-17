package by.kladvirov.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "goods")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "orders_goods_link",
            joinColumns = {@JoinColumn(name = "good_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id")}
    )
    private Set<Order> orders = new HashSet<>();

    public Good(String name, BigDecimal price, LocalDate createDate,
                LocalDate expirationDate, Boolean isAvailable, Set<Order> orders) {
        this.name = name;
        this.price = price;
        this.createDate = createDate;
        this.expirationDate = expirationDate;
        this.isAvailable = isAvailable;
        this.orders = orders;
    }

}
