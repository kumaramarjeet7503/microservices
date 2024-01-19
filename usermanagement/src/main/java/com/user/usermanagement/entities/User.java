package com.user.usermanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "micro_user")
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    private String id ;
    private String name ;
    private boolean is_active ;
    private String city ;

}
