package com.benezeth.MockinApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bank_info")
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long  id;
    @Column(name="UserId")
    int UserId;
    @Column(name="UserName")
    String UserName;
    @Column(name="UserPhoneNo")
    int UserPhoneNo;
    @Column(name="UserAddress")
    String UserAddress;
    @Column(name="UserJob")
    String UserJob;
}
