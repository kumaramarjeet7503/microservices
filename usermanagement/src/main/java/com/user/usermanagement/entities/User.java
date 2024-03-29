package com.user.usermanagement.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "user")
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    private String id ;
    private String name ;
    private boolean active ;
    private String city ;
    @Transient
    private List<Rating> ratings = new ArrayList<>() ;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", isActive=" + active + ", city=" + city + ", ratings="
                + ratings + "]";
    }
}
