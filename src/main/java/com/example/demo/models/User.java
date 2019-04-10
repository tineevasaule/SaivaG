package com.example.demo.models;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "users")
public class User  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String Password;
    private boolean active;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        userName = userName;
    }

    public User() {
    }
    public String toString()
    {
        return  "User{"+
                "id="+ id +
                ",UserName='"+ username +'\''+
                ", Password='" + Password + '\'' +
                ", active=" + active +
                ", roles=" + roles +
                '}';
    }

//    public List<Orders> completedOrders() {
//        List<Orders> orderedPizzas = new ArrayList<>();
//        for (Orders pizza : getOrders()) {
//            if (pizza.isSolt()) {
//                orderedPizzas.add(pizza);
//            }
//        }
//        return orderedPizzas;
//    }public List<Orders> uncompletedOrders() {
//        List<Orders> orderedPizzas = new ArrayList<>();
//        for (Orders pizza : getOrders()) {
//            if (!pizza.isSolt()) {
//                orderedPizzas.add(pizza);
//            }
//        }
//        return orderedPizzas;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getName() {
//        return name;
//    }
//


}
