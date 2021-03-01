import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor{
  private String skill;

  public static final int DEFAULT_SUS_LEVEL = 15;
  public static final String DEFAULT_SKILL = "experienced";

  // Contructors
  public RedAstronaut(String name) {
    this(name, DEFAULT_SUS_LEVEL, DEFAULT_SKILL);
  }

  public RedAstronaut(String name, int susLevel, String skill) {
    super(name, susLevel);
    this.skill = skill.toLowerCase();
  }

  // Methods
  public void emergencyMeeting() {
    if (this.isFrozen()) return;
    
    Player[] players = Player.getPlayers();
    Arrays.sort(players);
    int i = players.length - 1;
    Player curr = players[i];

    // find the player who's most sus and who's neither frozen nor the imposter
    for (i = players.length - 1; i >= 0; i--) {
      curr = players[i];
      if (curr.isFrozen()) return; 
      if (this.equals(curr)) continue;
      break;
    }

    // if two players have the same sus level, no one is voted off
    if (i - 1 >= 0 && !players[i-1].isFrozen() && players[i-1].getSusLevel() == curr.getSusLevel()) {
      return;
    }
    else {
      curr.setFrozen(true);
    }

    this.gameOver();
  }

  public void freeze(Player p) {
    boolean pIsImpostor = this.getClass().equals(p.getClass());
    if (this.isFrozen() || p.isFrozen() || pIsImpostor) {
      return;
    }

    boolean isSuccessfulFreeze = this.getSusLevel() < p.getSusLevel();
    if (isSuccessfulFreeze) {
      p.setFrozen(true);
    }
    else {
      this.setSusLevel(this.getSusLevel() * 2);
    }

    this.gameOver();
  }
  
  public void sabotage(Player p) {
    boolean pIsImpostor = this.getClass().equals(p.getClass());
    if (this.isFrozen() || p.isFrozen() || pIsImpostor) {
      return;
    }
    
    int crewmateSusLevel = p.getSusLevel();
    if (this.getSusLevel() < 20) {
      p.setSusLevel((int) (crewmateSusLevel * 1.5));
    }
    else {
      p.setSusLevel((int) (crewmateSusLevel * 1.25));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof RedAstronaut) {
      RedAstronaut r = (RedAstronaut) o;
      boolean samePlayerStats = super.equals(o); 
      boolean sameSkill = this.skill.equals(r.skill);
      return samePlayerStats && sameSkill;
    }
    return false;
  }

  public String toString() {
    String outputNormal = super.toString();
    String outputFinal = outputNormal + " I am an " + this.skill + " player!";
    return this.getSusLevel() > 15 ? outputFinal.toUpperCase() : outputFinal;
  }
}
