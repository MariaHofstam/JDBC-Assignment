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
//    	List<City> name = dao.findByName("Stockholm");					//Find city by Name
//    	System.out.println(name);
//    	
    	
    	
//    	List<City> findAll = dao.findAll();							//Find All cities
//    	System.out.println(findAll);

    	City Växjö = new City(1,"Växjö", "SWE", "Kronoberg", 66275);
    	dao.add(Växjö);
    	List<City> name = dao.findByName("Växjö");					
    	System.out.println(name);

//    	City karlshamn = new City("Karlshamn", "SWE", "Blekinge", 20274);	
//     	dao.add(karlshamn);											//Add city to the DataBase
//    	City addId = dao.findById(4081);								
//    	System.out.println(addId);
//
//    	//Update
//    	karlshamn.setName("Karlshamn2");
//    	System.out.println(karlshamn);
//    	
//    	dao.update(karlshamn);											//Update a city in the DataBase
//    	City addId = dao.findById(4081);								
//    	System.out.println(addId);
    	
    	
    	
//    	City deleteid = dao.findById(4081);	
//    	dao.delete(deleteid);										//Delete a city from the DataBase
//    	City findid = dao.findById(4081);								
//    	System.out.println(findid);
    	
    	
    }
}
