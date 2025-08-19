package com.chiron.springbootbyshreyansh.Service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class SecondProgrammaticApproach {
    TransactionTemplate transactionTemplate;

    public SecondProgrammaticApproach(TransactionTemplate transactionTemplate){
        this.transactionTemplate=transactionTemplate;
    }

    public void updateUser2(){
        TransactionCallback<TransactionStatus> dbOperationTask=(TransactionStatus status)->{
            System.out.println("Second Transaction");
            return status;
        };
        transactionTemplate.execute(dbOperationTask);
    }
}
