package com.java5.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private int age;

    @Column(name = "mark")
    private Double mark;

    @Column(name = "hoc_luc")
    private String hocLuc;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Role role;

    public String xacDinhHocLuc(){
        if(this.getMark()>=8)
            return "Gioi";
        else if(this.getMark()>6)
            return "Kha";
        else {
            return "Trung Binh";
        }
    }
}
