public class Hero {
    private String name;
    private int hitPoints;
    public Hero(String name){
        this.name = name;
        this.hitPoints = 100;
    }
    public String getName(){
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public String toString(){
        return "Hero{name='"+name+"', hitPoints="+Integer.toString(hitPoints)+"}";
    }
    public void attack(Hero opponent){
        double random = Math.random();
        double result = random * 0.99;
        if (result<0.5){
            opponent.hitPoints -=10;
        } if (result>=0.5){
            hitPoints-= 10;
        }
    }
    public void senzuBean(){
        hitPoints = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent){
        while (hitPoints!=0&&opponent.hitPoints!=0){
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return this.name+": "+Integer.toString(this.hitPoints)+" "+opponent.name+": "+Integer.toString(opponent.hitPoints);
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] results = new int[2];
        for (int i = 0; i<n; i++){
            senzuBean();
            opponent.senzuBean();
            fightUntilTheDeathHelper(opponent);
            if (opponent.hitPoints<=0){
                results[0]++;
            } else{
                results[1]++;
            }
        }
        return results;
    }
    public String nFightsToTheDeath(Hero opponent, int n){
        int[] results = nFightsToTheDeathHelper(opponent, n);
        int heroWins = results[0];
        int opponentWins = results[1];
        if (heroWins==opponentWins){
            return getName()+": "+Integer.toString(heroWins)+" wins\n"+opponent+": "+Integer.toString(opponentWins)+" wins\nOMG! It was actually a draw!";
        } if (heroWins>opponentWins){
            return getName()+": "+Integer.toString(heroWins)+" wins\n"+opponent+": "+Integer.toString(opponentWins)+" wins\n"+getName()+" wins!";
        } else return getName()+": "+Integer.toString(heroWins)+" wins\n"+opponent+": "+Integer.toString(opponentWins)+" wins\n"+opponent+" wins!";
    }
    public void dramaticFightToTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        while ((getHitPoints()!=0)&&(opponent.getHitPoints()!=0)){
            attack(opponent);
            System.out.println(getName()+": "+Integer.toString(getHitPoints())+opponent+": "+Integer.toString(opponent.getHitPoints()));
        }
        if (getHitPoints()>opponent.getHitPoints()){
            System.out.println(getName()+" wins!");
        } else if (getHitPoints()<opponent.getHitPoints()){
            System.out.println(opponent+" wins!");
        }
    }
}
