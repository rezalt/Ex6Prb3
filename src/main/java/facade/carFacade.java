/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author olls
 */
public class carFacade
{

    EntityManagerFactory emf;

    public carFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    public void setEmf(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    public EntityManagerFactory getEmf()
    {
        return emf;
    }

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public void addCar(Car car)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
        }
        finally
        {

            em.close();

        }
    }

    public void editCar(Car car)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            car = em.merge(car);
            em.getTransaction().commit();
        }
        finally
        {

            em.close();

        }
    }

    public void deleteCar(int id)
    {
        EntityManager em = getEntityManager();

        try
        {
            em.getTransaction().begin();
            Car c = em.find(Car.class, id);
            em.remove(c);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
    }

    public List<Car> getCars() throws Exception
    {
        EntityManager em = getEntityManager();

        List<Car> cars = null;

        try
        {

            em.getTransaction().begin();
            cars = em.createQuery("Select c from Car c").getResultList();
            em.getTransaction().commit();

            return cars;
        }
        catch(Exception e) 
        {
            System.out.println("nooooo!" +e);
        }
        finally
        {
            em.close();
        }
        return cars;
    }

}
