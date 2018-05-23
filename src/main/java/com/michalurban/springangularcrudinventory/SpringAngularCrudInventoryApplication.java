package com.michalurban.springangularcrudinventory;

import com.michalurban.springangularcrudinventory.employee.Person;
import com.michalurban.springangularcrudinventory.employee.PersonRepository;
import com.michalurban.springangularcrudinventory.employee.Role;
import com.michalurban.springangularcrudinventory.item.Category;
import com.michalurban.springangularcrudinventory.item.Item;
import com.michalurban.springangularcrudinventory.item.ItemRepository;
import com.michalurban.springangularcrudinventory.item.Status;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class SpringAngularCrudInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularCrudInventoryApplication.class, args);
	}

	@Bean
    ApplicationRunner init(PersonRepository er, ItemRepository ir) {

	    return args -> {
	        fillDatabase(er, ir);
//	        ir.findAll().forEach(System.out::println);
        };
    }

    private void fillDatabase(PersonRepository er, ItemRepository ir) {

	    Person e1 = Person.builder().firstName("Mateusz").lastName("Ostafil").role(Role.MENTOR).build();
        Person e2 = Person.builder().firstName("Przemysław").lastName("Ciąćka").role(Role.MENTOR).build();
        Person e3 = Person.builder().firstName("Michał").lastName("Urban").role(Role.STUDENT).build();
        Person e4 = Person.builder().firstName("Miriam").lastName("Bałazińska").role(Role.OFFICE).build();
        Person e5 = Person.builder().firstName("Jerzy").lastName("Mardaus").role(Role.MANAGER).build();
        er.saveAll(Arrays.asList(e1, e2, e3, e4, e5));

        Item i1 = Item.builder().name("Laptop").category(Category.ELECTRONICS).description("eqwe")
                .initialValue(new BigDecimal(2000)).owner(e3)
                .purchaseDate(LocalDate.of(2017, 3, 13)).status(Status.SOLD).build();
        Item i2 = Item.builder().name("Table").category(Category.FURNITURE)
                .initialValue(new BigDecimal(300)).owner(e5)
                .purchaseDate(LocalDate.of(2016, 1, 1)).status(Status.AVAILABLE).build();
        Item i3 = Item.builder().name("Chair").category(Category.FURNITURE).description("nice chair")
                .initialValue(new BigDecimal(80)).owner(e5)
                .purchaseDate(LocalDate.of(2016, 1, 1)).status(Status.AVAILABLE).build();
        Item i4 = Item.builder().name("Chair").category(Category.ELECTRONICS).description("eqwe")
                .initialValue(new BigDecimal(80)).owner(e5)
                .purchaseDate(LocalDate.of(2016, 3, 13)).status(Status.BROKEN).build();
        Item i5 = Item.builder().name("MacBookPro").category(Category.ELECTRONICS).description("$$$")
                .initialValue(new BigDecimal(5000)).owner(e5)
                .purchaseDate(LocalDate.of(2017, 1, 13)).status(Status.DESTROYED).build();
        Item i6 = Item.builder().name("Projector").category(Category.ELECTRONICS).description("very colorful")
                .initialValue(new BigDecimal(1200)).owner(e5)
                .purchaseDate(LocalDate.of(2017, 1, 20)).status(Status.AVAILABLE).build();
        Item i7 = Item.builder().name("MacBookPro").category(Category.ELECTRONICS).description("$$$")
                .initialValue(new BigDecimal(5000)).owner(e1)
                .purchaseDate(LocalDate.of(2017, 1, 13)).status(Status.BORROWED).build();
        Item i8 = Item.builder().name("MacBookPro").category(Category.ELECTRONICS).description("$$$")
                .initialValue(new BigDecimal(5000)).owner(e4)
                .purchaseDate(LocalDate.of(2017, 1, 13)).status(Status.BORROWED).build();
        Item i9 = Item.builder().name("MacBookPro").category(Category.ELECTRONICS).description("$$$")
                .initialValue(new BigDecimal(6000)).owner(e2)
                .purchaseDate(LocalDate.of(2017, 2, 13)).status(Status.BORROWED).build();
        Item i10 = Item.builder().name("Printer").category(Category.ELECTRONICS).description("Ink printer with scanner")
                .initialValue(new BigDecimal(2000)).owner(e4)
                .purchaseDate(LocalDate.of(2017, 3, 13)).status(Status.AVAILABLE).build();
        ir.saveAll(Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10));
    }
}
