package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Models.City;


public class CityDaoImpl implements CityDao {

// ********** Print Cities *******************
	public void printCities() {
		
		try (Connection conn = DataBase.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery("SELECT Name FROM city")){
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
// ********** Find By Id *******************
	@Override
	public City findById(int id) {
		City result = null;
		
		try(Connection conn = DataBase.getConnection();
				PreparedStatement statement = createPreparedStatement(conn, id);
				ResultSet rs = statement.executeQuery()){
			
			while(rs.next()) {
				result =  createCityFromResultSet(rs);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

// ********** Find By CountryCode ************
	@Override
	public List<City> findByCode(String code) {	
		List<City> list = new ArrayList<>();
		City result = null;
		
		try (Connection conn = DataBase.getConnection();
				PreparedStatement statement = createPreparedStatementCode(conn, code);
				ResultSet rs = statement.executeQuery()){
			
			while(rs.next()) {
				result = createCityFromResultSet(rs);
				list.add(result);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
// ********** Find By Name *******************
	@Override
	public List<City> findByName(String name) {
		List<City> list = new ArrayList<>();
		City result = null;
		
		try (Connection conn = DataBase.getConnection();
				PreparedStatement statement = createPreparedStatementName(conn, name);
				ResultSet rs = statement.executeQuery()){
			
			while(rs.next()) {
				result = createCityFromResultSet(rs);
				list.add(result);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

// ********** Find All Cities *******************
	@Override
	public List<City> findAll() {
		List<City> list = new ArrayList<>();
		City result = null;
		
		try (Connection conn = DataBase.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM city")){
			
			while(rs.next()) {
				result = createCityFromResultSet(rs);
				list.add(result);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

// ********** Add new city to the dataBase *************
	@Override
	public City add(City city) {
		
		try (Connection conn = DataBase.getConnection();
				PreparedStatement statement = createPreparedStatementAdd(conn, city);){
			
			 statement.executeUpdate();
			 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
// ********** Update a city in the dataBase *************
	@Override
	public City update(City city) {
		try (Connection conn = DataBase.getConnection();
				PreparedStatement statement = createPreparedStatementUpdate(conn, city);){
			
			 statement.executeUpdate();
			 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

// ********** Delete a city from the dataBase *************
	@Override
	public int delete(City city) {
		
		try (Connection conn = DataBase.getConnection();
				PreparedStatement statement = createPreparedStatementDelete(conn, city);){
			
			 statement.executeUpdate();
			 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	private PreparedStatement createPreparedStatement(Connection conn, int number) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM city WHERE ID = ?");
		statement.setInt(1, number);
		return statement;
	}
	
	private PreparedStatement createPreparedStatementName(Connection conn, String name)throws SQLException {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM city WHERE NAME = ?");
		statement.setString(1, name);
		return statement;
	}
	
	private PreparedStatement createPreparedStatementCode(Connection conn, String code)throws SQLException {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM city WHERE COUNTRYCODE = ?");
		statement.setString(1, code);
		return statement;
	}
	
	private PreparedStatement createPreparedStatementAdd(Connection conn, City city)throws SQLException {
		PreparedStatement statement = conn.prepareStatement("INSERT INTO city VALUES(?,?,?,?)");
		statement.setString(1, city.getName());
		statement.setString(2, city.getCountryCode());
		statement.setString(3, city.getDistrict());
		statement.setInt(4, city.getPopulation());
		return statement;
	}
	
	private PreparedStatement createPreparedStatementUpdate(Connection conn, City city)throws SQLException {
		PreparedStatement statement = conn.prepareStatement("UPDATE city SET NAME = ?, COUNTRYCODE = ?, DISTRICT = ?, POPULATION = ? WHERE ID = ? ");
		statement.setString(1, city.getName());
		statement.setString(2, city.getCountryCode());
		statement.setString(3, city.getDistrict());
		statement.setInt(4, city.getPopulation());
		statement.setInt(5, city.getId());
		return statement;
	}
	
	private PreparedStatement createPreparedStatementDelete(Connection conn, City city)throws SQLException {
		PreparedStatement statement = conn.prepareStatement("DELETE FROM city WHERE ID = ?");
		statement.setInt(1, city.getId());
		return statement;
	}
	
	private City createCityFromResultSet(ResultSet rs) throws SQLException{
		return new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
	}
	
}
