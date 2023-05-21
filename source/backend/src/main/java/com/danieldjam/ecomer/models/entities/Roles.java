/*
package com.danieldjam.ecomer.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @Column(name = "rol_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rolId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "rolesList")
    private List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        this.userList.add(user);
        user.getRolesList().add(this);
    }

    public void removeUser(User user){
        this.userList.remove(user);
        user.getRolesList().remove(this);
    }

    public void removeAllUsers(){
        for (User user : new ArrayList<>(userList)) {
            removeUser(user);
        }
    }

}*/
