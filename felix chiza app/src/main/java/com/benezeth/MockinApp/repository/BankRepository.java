package com.benezeth.MockinApp.repository;

import com.benezeth.MockinApp.entity.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("ALL")
public interface BankRepository extends JpaRepository <BankEntity,Long>{
    //all crud method for database
}
