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
            this.hitPoints = opponent.getHitPoints()-10;
        } if (result>=0.5){
            this.hitPoints = getHitPoints()-10;
        }
    }
    public void senzuBean(){
        this.hitPoints = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent){
        while ((getHitPoints()!=0)||(opponent.getHitPoints()!=0)){
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return getName()+": "+Integer.toString(getHitPoints())+opponent+": "+Integer.toString(opponent.getHitPoints());
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] fights = new int[2];
        if (n>0){
            while ((getHitPoints()!=0)||(opponent.getHitPoints()!=0)){
                double random = Math.random();
                double result = random * 0.99;
                if (result<0.5){
                    this.hitPoints = opponent.getHitPoints()-10;
                    fights[0] = fights[0]+1;
                } if (result>=0.5){
                    this.hitPoints = getHitPoints()-10;
                    fights[1] = fights[1]+1;
                }
                n-=1;
            } senzuBean();
            opponent.senzuBean();
        }
        return fights;
    }
    public String nFightsToTheDeath(Hero opponent, int n){
        int[] fights = nFightsToTheDeathHelper(opponent, n);
        int heroWins = fights[0];
        int opponentWins = fights[1];
        if (heroWins==opponentWins){
            return getName()+": "+Integer.toString(heroWins)+" wins\n"+opponent+": "+Integer.toString(opponentWins)+" wins\nOMG! It was actually a draw!";
        } if (heroWins>opponentWins){
            return getName()+": "+Integer.toString(heroWins)+" wins\n"+opponent+": "+Integer.toString(opponentWins)+" wins\n"+getName()+" wins!";
        } else return getName()+": "+Integer.toString(heroWins)+" wins\n"+opponent+": "+Integer.toString(opponentWins)+" wins\n"+opponent+" wins!";
    }
    public void dramaticFightToTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        while ((getHitPoints()!=0)||(opponent.getHitPoints()!=0)){
            attack(opponent);
            System.out.println(getName()+": "+Integer.toString(getHitPoints())+opponent+": "+Integer.toString(opponent.getHitPoints()));
        }
    }
}
