package tlaq.com.backendV64.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import tlaq.com.backendV64.entity.enums.UserType;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "username", unique = true)
    String username;
    String password;

    @Column(name= "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email", unique = true)
    String email;

    @Column(name = "phone_number", unique = true)
    String phoneNumber;

    @Column(name = "dob")
    Date dob;

    @Column(name = "sex")
    boolean sex;

    @Column(name = "email_verified", nullable = false)
    boolean emailVerified;

    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    UserType type;

    @ManyToMany
    Set<Role> roles;
}
