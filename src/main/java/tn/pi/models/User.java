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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_gen")
    @SequenceGenerator(name = "user_gen", initialValue = 1, allocationSize = 1)
    private Integer id;
    private String name;
    private LocalDate birthdate;
}
