import java.sql.*;
import java.util.HashMap;

public class Solution {
    static HashMap<String, Double> teamAbility;
    static final double a1 = 0.23, a2 = 0.30, a3 = 0.29, a4 = 0.18;
    //主客场胜率(偶然因素)
    static double homeTeamWinRate, awayTeamWinRate;
    //计算主客场胜率
    static void CalcWinRate(){
        try {
            Connection connection = Data.ConnectToMysql();
            String sql = "select * from Game";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int homeTeamWin = 0, awayTeamWin = 0;
            while (resultSet.next()){
                if (resultSet.getInt("home_team_score") > resultSet.getInt("away_team_score")){
                    homeTeamWin++;
                }else if (resultSet.getInt("home_team_score") < resultSet.getInt("away_team_score")){
                    awayTeamWin++;
                }
            }
            homeTeamWinRate = (double) homeTeamWin/(homeTeamWin+awayTeamWin);
            awayTeamWinRate = (double) awayTeamWin/(homeTeamWin+awayTeamWin);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //获取球队实力
    static void GetTeamAbility(){
        teamAbility = new HashMap<>();
        try {
            Connection connection = Data.ConnectToMysql();
            String sql = "select * from Team";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                teamAbility.put(resultSet.getString("team_name"), resultSet.getDouble("strength"));
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //预测球队得分
    static void CalcAbilityCompare(){
        GetTeamAbility();
        try {
            Connection connection = Data.ConnectToMysql();
            String sql = "select * from Game where ability_compare=0";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String home = resultSet.getString("home_team");
                String away = resultSet.getString("away_team");
                Double abilityCompare = teamAbility.get(home)/teamAbility.get(away);
                sql = "update Game set ability_compare=? where home_team=? and away_team=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, String.valueOf(abilityCompare));
                preparedStatement.setString(2, home);
                preparedStatement.setString(3, away);
                preparedStatement.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String []args){
        String home_team_name, away_team_name;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请依次输入主客场球队名称");
//        home_team_name = scanner.nextLine();
//        away_team_name = scanner.nextLine();
        home_team_name = "山东鲁能";
        away_team_name = "上海上港";
        Team home_team = new Team(home_team_name);
        Team away_team = new Team(away_team_name);
        System.out.println(home_team.getName() + ":" + home_team.getLevel() + "," + home_team.getMorale() + "," + home_team.getStrength());
        System.out.println(away_team.getName() + ":" + away_team.getLevel() + "," + away_team.getMorale() + "," + away_team.getStrength());

        CalcWinRate();
        System.out.println("主场胜率："+homeTeamWinRate + ", 客场胜率："+awayTeamWinRate);

        CalcAbilityCompare();
    }
}
