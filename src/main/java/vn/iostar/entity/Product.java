package vn.iostar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "[product]")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer quantity;

    @Column(name = "description")
    private String desc;

    private Double price;

    // Quan hệ nhiều-1 với User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Quan hệ nhiều-1 với Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}

