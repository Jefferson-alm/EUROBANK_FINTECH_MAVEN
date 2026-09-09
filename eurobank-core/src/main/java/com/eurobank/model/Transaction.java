package com.eurobank.model;

import java.time.LocalDateTime;

public class Transaction {

	private int id;
	private TransactionType type;
	private double amount;
	private LocalDateTime date;


    public Transaction() {
    }

    public Transaction(int id, TransactionType type, double amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    } 
    

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
    public String toString() {
        return "Transaction [id=" + id +
                ", type=" + type +
                ", amount=" + amount +
                ", date=" + date + "]";
    }
	
}
