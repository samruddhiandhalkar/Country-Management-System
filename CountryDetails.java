package ShowDetails;

import java.util.List;

import App.HibernateUtil;
import entity.CountryClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CountryDetails 
{
	public void showCountry(CountryClass country)
	{
		EntityTransaction tra;
		try(EntityManager entityManager =HibernateUtil.getEntityManagerFactory().createEntityManager();)
		{
			tra=entityManager.getTransaction();
			entityManager.persist(country);
			tra.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			}
	}
	
	public List<CountryClass> getAllEmployee()
	{
		try(EntityManager entityManager =HibernateUtil.getEntityManagerFactory().createEntityManager();)
		{
			return entityManager.createQuery("from CountryClass",CountryClass.class).getResultList();
		}
	}
	
	
	public void updateCountry(int updateId,String new_country_capital) 
	{
		EntityTransaction transcation=null;
		
		try(EntityManager entityManager =HibernateUtil.getEntityManagerFactory().createEntityManager();)
		{
			transcation=entityManager.getTransaction();
			CountryClass c1= entityManager.find(CountryClass.class,updateId);
			if(c1!=null)
			{
				c1.setCountry_capital(new_country_capital);
				entityManager.merge(c1);
	            System.out.println("Capital updated.");
	        } 
			else
			{
	            System.out.println(" Country not found.");
	        }
			
			transcation.commit();
		}
		catch(Exception ee) 
		{
			ee.printStackTrace();
		}
	}
	
	public void delConuntry(int deleteId)
	{
		EntityTransaction transcation=null;
		
		try(EntityManager entityManager =HibernateUtil.getEntityManagerFactory().createEntityManager();)
		{
			transcation=entityManager.getTransaction();
			CountryClass country=entityManager.find(CountryClass.class,deleteId);
			if(country!=null)
			{
				entityManager.remove(country);
				System.out.println("Country can be remove");
			}
				else
				{
					System.out.println("Country cannot be found");
				}
			
			transcation.commit();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	

}
