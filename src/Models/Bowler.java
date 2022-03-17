package Models;

public class Bowler {

    public String name;
    public double overs;
    public int runs;
    public int wickets;
    public double economy;

    public Bowler(){
        this.overs = 0;
        this.runs = 0;
        this.wickets = 0;
        this.economy = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOvers() {
        return overs;
    }

    public void setOvers(double overs) {
        this.overs = overs;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public double getEconomy() {
        return economy;
    }

    public void setEconomy(double economy) {
        this.economy = economy;
    }
}
