/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author olls
 */
@Entity
public class Car implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int model_year;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date registered;

    private String make;

    private String model;

    private String description;

    private String price;

    // --- GETTERS ---
    public int getId()
    {
        return id;
    }
    
    public int getYear()
    {
        return model_year;
    }

    public Date getRegistered()
    {
        return registered;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public String getDescription()
    {
        return description;
    }

    public String getPrice()
    {
        return price;
    }

    // --- SETTERS ---
    public void setId(int id)
    {
        this.id = id;
    }

    public void setYear(int year)
    {
        this.model_year = year;
    }

    public void setRegistered(Date registered)
    {
        this.registered = registered;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }
    

    @Override
    public String toString()
    {
        return "entity.Car[ id=" + id + " ]";
    }

}
