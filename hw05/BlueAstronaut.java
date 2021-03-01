import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
  private int numTasks;
  private int taskSpeed; // non-zero and positive

  private static final int DEFAULT_SUS_LEVEL = 15;
  private static final int DEFAULT_NUM_TASKS = 6;
  private static final int DEFAULT_TASK_SPEED = 10;

  // constructors
  public BlueAstronaut(String name) {
    this(name, DEFAULT_SUS_LEVEL, DEFAULT_NUM_TASKS, DEFAULT_TASK_SPEED);
  }

  public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
    super(name, susLevel);
    this.numTasks = numTasks >= 0 ? numTasks : 0;
    this.taskSpeed = taskSpeed > 0 ? taskSpeed : 1;
  }

  // methods
  public void emergencyMeeting() {
    if (this.isFrozen()) return;

    Player[] players = Player.getPlayers();
    Arrays.sort(players);

    // find the player who's most sus and not frozen
    int i = players.length - 1;
    Player mostSusPlayer = players[i];
    if (mostSusPlayer.isFrozen()) return;

    // if two players have the same sus level, no one is voted off
    if (i - 1 >= 0 && !players[i-1].isFrozen() && players[i-1].getSusLevel() == mostSusPlayer.getSusLevel()) {
      return;
    }
    else {
      mostSusPlayer.setFrozen(true);
    }

    this.gameOver();
  }

  public void completeTask() {
    if (this.isFrozen()) return;

    int newNumTasks;
    if (taskSpeed > 20) {
      newNumTasks = this.numTasks - 2;
    }
    else {
      newNumTasks = this.numTasks - 1;
    }
    this.setNumTasks(newNumTasks);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof BlueAstronaut) {
      BlueAstronaut b = (BlueAstronaut) o;
      boolean samePlayerStats = super.equals(o);
      boolean sameNumTasks = this.numTasks == b.numTasks;
      boolean sameTaskSpeed = this.taskSpeed == b.taskSpeed;
      return samePlayerStats && sameNumTasks && sameTaskSpeed;
    }
    return false;
  }

  public void setNumTasks(int numTasks) {
    if (this.numTasks == 0) return;

    this.numTasks = numTasks >= 0 ? numTasks : 0;

    // if numTasks is reduced to zero for the first time
    if (this.numTasks == 0) {
      System.out.println("I have completed all my tasks");
      int newSusLevel = (int) (this.getSusLevel() * 0.5);
      this.setSusLevel(newSusLevel);
    }
  }

  public String toString() {
    String outputNormal = super.toString();
    String outputFinal = outputNormal + " I have " + this.numTasks + " task(s) left over.";
    return this.getSusLevel() > 15 ? outputFinal.toUpperCase() : outputFinal;
  }
}
