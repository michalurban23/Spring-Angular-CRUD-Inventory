package com.michalurban.springangularcrudinventory.item;

import com.michalurban.springangularcrudinventory.employee.Person;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString @EqualsAndHashCode
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Category category;

    @NotNull
    private BigDecimal initialValue;

    @NotNull
    private LocalDate purchaseDate;

    @NotNull
    private Status status;

    @ManyToOne
    private Person owner;
}
