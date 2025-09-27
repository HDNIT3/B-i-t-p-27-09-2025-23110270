package vn.iostar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String email;
    private String password;
    private String phone;

    // Quan hệ nhiều-nhiều với Category
    @ManyToMany(mappedBy = "users")
    private Set<Category> categories = new HashSet<>();

    // Quan hệ 1-nhiều với Product (người đăng sản phẩm)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();
}

