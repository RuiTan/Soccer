public class Player {
    private String name;
    private int number;
    private String team;
    private double shoot;
    private double valid_shoot;
    private double goal;
    private double dribbling_past;
    private double rescue;
    private double save_ball;
    private double forwardAbility;
    private double rearguardAbility;
    private double midfielderAbility;
    private double goalkeeperAbility;

    public Player(String name, int number, String team, double shoot, double valid_shoot, double goal, double dribbling_past, double rescue, double save_ball, double forwardAbility, double rearguardAbility, double midfielderAbility, double goalkeeperAbility) {
        this.name = name;
        this.number = number;
        this.team = team;
        this.shoot = shoot;
        this.valid_shoot = valid_shoot;
        this.goal = goal;
        this.dribbling_past = dribbling_past;
        this.rescue = rescue;
        this.save_ball = save_ball;
        this.forwardAbility = forwardAbility;
        this.rearguardAbility = rearguardAbility;
        this.midfielderAbility = midfielderAbility;
        this.goalkeeperAbility = goalkeeperAbility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public double getShoot() {
        return shoot;
    }

    public void setShoot(double shoot) {
        this.shoot = shoot;
    }

    public double getValid_shoot() {
        return valid_shoot;
    }

    public void setValid_shoot(double valid_shoot) {
        this.valid_shoot = valid_shoot;
    }

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public double getDribbling_past() {
        return dribbling_past;
    }

    public void setDribbling_past(double dribbling_past) {
        this.dribbling_past = dribbling_past;
    }

    public double getRescue() {
        return rescue;
    }

    public void setRescue(double rescue) {
        this.rescue = rescue;
    }

    public double getSave_ball() {
        return save_ball;
    }

    public void setSave_ball(double save_ball) {
        this.save_ball = save_ball;
    }

    public double getForwardAbility() {
        return forwardAbility;
    }

    public void setForwardAbility(double forwardAbility) {
        this.forwardAbility = forwardAbility;
    }

    public double getRearguardAbility() {
        return rearguardAbility;
    }

    public void setRearguardAbility(double rearguardAbility) {
        this.rearguardAbility = rearguardAbility;
    }

    public double getMidfielderAbility() {
        return midfielderAbility;
    }

    public void setMidfielderAbility(double midfielderAbility) {
        this.midfielderAbility = midfielderAbility;
    }

    public double getGoalkeeperAbility() {
        return goalkeeperAbility;
    }

    public void setGoalkeeperAbility(double goalkeeperAbility) {
        this.goalkeeperAbility = goalkeeperAbility;
    }
}
