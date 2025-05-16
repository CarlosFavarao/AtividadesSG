package model;

import java.math.BigDecimal;

public class User {
    private String name;
    private BigDecimal balance;

    public boolean canWithdraw(BigDecimal amount){
        return balance.compareTo(amount) >= 0;
    }

    public void withdraw(BigDecimal amount){
        balance = balance.subtract(amount);
    }

    //---------------------------------------------
    //Construtores, getters e setters
    public User(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance){
        this.balance = balance;
    }
}
