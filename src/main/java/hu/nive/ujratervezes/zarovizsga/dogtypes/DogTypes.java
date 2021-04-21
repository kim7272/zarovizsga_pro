package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(MariaDbDataSource dogs) {
        this.dataSource = dogs;
    }


    public List<String> getDogsByCountry(String countryName){
        List<String> dogs = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
             conn.prepareStatement("select name from dog_types where country = ?"))
        {
            stmt.setString(1, countryName.toUpperCase());
            try (ResultSet rs = stmt.executeQuery();)
            {
                while (rs.next()) {
                    String name = rs.getString("name").toLowerCase();
                    dogs.add(name);
                }
            if (dogs == null){
                throw new IllegalArgumentException("No result");
            }
                return dogs;

            }
        }   catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by insert", sqle);
            }
        }
    }


