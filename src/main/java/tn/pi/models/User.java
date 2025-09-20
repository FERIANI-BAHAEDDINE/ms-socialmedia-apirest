package tn.pi.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor @ToString
@Entity
@Builder
@Table(name = "user_details")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate birthdate;
}
