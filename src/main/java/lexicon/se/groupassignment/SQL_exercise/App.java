package lexicon.se.groupassignment.SQL_exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import Data.CityDao;
import Data.CityDaoImpl;
import Models.City;


public class App 
{
    public static void main( String[] args ) throws SQLException {
    	
    	CityDao dao = new CityDaoImpl();
    	
//    	dao.printCities();											//Print all cities
//    	
//    	City id = dao.findById(859);								//Find city by Id
//    	System.out.println(id);
//    	
//    	List<City> countryCode = dao.findByCode("GBR");				//Find city by CountryCode
//    	System.out.println(countryCode);
//    	
//    	List<City> name = dao.findByName("Växjö");					//Find city by Name
//    	System.out.println(name);
    	
    	
    	
//    	List<City> findAll = dao.findAll();							//Find All cities
//    	System.out.println(findAll);

//    	City Växjö = new City(1,"Växjö", "SWE", "Kronoberg", 66275);
//    	dao.add(Växjö);
//    	List<City> name = dao.findByName("Växjö");					
//    	System.out.println(name);

//    	City karlshamn = new City(2, "Karlshamn", "SWE", "Blekinge", 20274);	
//     	dao.add(karlshamn);											//Add city to the DataBase
//     	List<City> name2 = dao.findByName("Karlshamn");							
//    	System.out.println(name2);

//    	karlshamn.setPopulation(20375);
    	City updateId = dao.findById(4083);
    	System.out.println(updateId);
    	updateId.setPopulation(42963);
    	dao.update(updateId);											//Update a city in the DataBase		
    	System.out.println(updateId);
    	
    	
    	
//    	City deleteid = dao.findById(4081);	
//    	dao.delete(deleteid);										//Delete a city from the DataBase
//    	City findid = dao.findById(4081);								
//    	System.out.println(findid);
    	
    	
    }
}
