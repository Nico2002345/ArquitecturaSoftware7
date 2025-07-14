/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
public class Competitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @NotNull
    @Column(name = "create_At", updatable = false)
    @Temporal(TemporalType.DATE)
    private Calendar createdAt;

    @NotNull
    @Column(name = "updated_At")
    @Temporal(TemporalType.DATE)
    private Calendar updatedAt;

    private String name;
    private String surname;
    private int age;
    private String telephone;
    private String cellphone;
    private String address;
    private String city;
    private String country;
    private boolean winner;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competitor")
    private Set<Producto> products;

    public Competitor() {}

    public Competitor(String nameN, String surnameN, int ageN, String telephoneN,
                      String cellphoneN, String addressN, String cityN,
                      String countryN, boolean winnerN, String emailN, String passwordN) {
        this.name = nameN;
        this.surname = surnameN;
        this.age = ageN;
        this.telephone = telephoneN;
        this.cellphone = cellphoneN;
        this.address = addressN;
        this.city = cityN;
        this.country = countryN;
        this.winner = winnerN;
        this.email = emailN;
        this.password = passwordN;
    }

    // Métodos de ciclo de vida JPA
    @PrePersist
    private void creationTimeStamp() {
        this.createdAt = Calendar.getInstance();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    public void updateTimeStamp() {
        this.updatedAt = Calendar.getInstance();
    }

    // Getters y Setters
    public long getId() { return Id; }
    public void setId(long id) { this.Id = id; }

    public Calendar getCreatedAt() { return createdAt; }
    public void setCreatedAt(Calendar createdAt) { this.createdAt = createdAt; }

    public Calendar getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Calendar updatedAt) { this.updatedAt = updatedAt; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getCellphone() { return cellphone; }
    public void setCellphone(String cellphone) { this.cellphone = cellphone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public boolean isWinner() { return winner; }
    public void setWinner(boolean winner) { this.winner = winner; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Set<Producto> getProducts() {
        return products;
    }

    public void setProducts(Set<Producto> products) {
        this.products = products;
    }

    // Conversión a DTO (sin contraseña ni productos)
    public CompetitorDTO toDTO() {
        CompetitorDTO dto = new CompetitorDTO();
        dto.setName(this.name);
        dto.setSurname(this.surname);
        dto.setAge(this.age);
        dto.setTelephone(this.telephone);
        dto.setCellphone(this.cellphone);
        dto.setAddress(this.address);
        dto.setCity(this.city);
        dto.setCountry(this.country);
        dto.setEmail(this.email);
        return dto;
    }
}
