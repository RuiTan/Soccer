public class LineUp {
    private String teamName;
    private int[] players;
    private int[] positions;
    private double attackAbility;
    private double defenciveAbility;

    public LineUp(String teamName, int[] players, int[] positions, double attackAbility, double defenciveAbility) {
        this.teamName = teamName;
        this.players = players;
        this.positions = positions;
        this.attackAbility = attackAbility;
        this.defenciveAbility = defenciveAbility;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int[] getPlayers() {
        return players;
    }

    public void setPlayers(int[] players) {
        this.players = players;
    }

    public int[] getPositions() {
        return positions;
    }

    public void setPositions(int[] positions) {
        this.positions = positions;
    }

    public double getAttackAbility() {
        return attackAbility;
    }

    public void setAttackAbility(double attackAbility) {
        this.attackAbility = attackAbility;
    }

    public double getDefenciveAbility() {
        return defenciveAbility;
    }

    public void setDefenciveAbility(double defenciveAbility) {
        this.defenciveAbility = defenciveAbility;
    }
}
