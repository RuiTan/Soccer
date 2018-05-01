import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Team {
    private String name;
    private double strength;
    private double morale;
    private int level;

    public Team(String name, double strength, double morale, int level) {
        this.name = name;
        this.strength = strength;
        this.morale = morale;
        this.level = level;
    }

    public Team(String name){
        try {
            Connection connection = Data.ConnectToMysql();
            String sql = "select * from Team where team_name=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                this.name = resultSet.getString(1);
                this.strength = resultSet.getDouble(2);
                this.morale = resultSet.getDouble(3);
                this.level = resultSet.getInt(4);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getMorale() {
        return morale;
    }

    public void setMorale(double morale) {
        this.morale = morale;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
