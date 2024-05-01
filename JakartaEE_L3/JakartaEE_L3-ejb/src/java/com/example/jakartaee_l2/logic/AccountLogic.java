/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jakartaee_l2.logic;

import com.example.jakartaee_l2.dao.AccountDAO;
import com.example.jakartaee_l2.dao.AccountDAOStub;
import com.example.jakartaee_l2.entities.Account;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Acer
 */
@Stateless
public class AccountLogic
{
    public Optional<Account> findAccount(String username, String password)
    {
        AccountDAO accountDAO = new AccountDAOStub();
        //AccountDAO accountDAO = new AccountDAOStub();
        Optional<Account> accountOptional = accountDAO.findAccount(username, password);

        return(accountOptional);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
