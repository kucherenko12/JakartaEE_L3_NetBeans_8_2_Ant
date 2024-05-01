/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jakartaee_l2.dao;

import com.example.jakartaee_l2.entities.Account;
import java.util.Optional;

/**
 *
 * @author Acer
 */
public class AccountDAOStub implements AccountDAO
{

    @Override
    public Optional<Account> findAccount(String username, String password)
    {
        if(username.equals("a")&&password.equals("a"))
        {
            return (Optional.of(new Account(0, "a", "a")));
        }
        else { return (Optional.empty()); }
    }
    
}
