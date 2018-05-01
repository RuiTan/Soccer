import java.sql.*;

public class Data {
    static final String connectStr = "jdbc:mysql://ekfeoz21.hkzzcdb.dnstoo.com:5805/university";
    static final String user = "university_f";
    static final String password = "tanrui106";
    public static Connection ConnectToMysql(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectStr,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void main(String[] args){
        Connection connection = ConnectToMysql();
        try {
            String sql = "select * from Players";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
