public class Gameplay {
  public static void printPlayers() {
    Player[] players = Player.getPlayers();
    System.out.println("All players: ");
    for (Player p : players) {
      String name = p.getName();
      String isFrozen = p.isFrozen() ? "frozen" : "not frozen";
      String sus = Integer.toString(p.getSusLevel());
      System.out.println(name + ", " + isFrozen + ", " + sus);
    }
    System.out.println("-------------------------");
  }
  public static void main(String[] args) {
    RedAstronaut liam = new RedAstronaut("Liam", 19, "Experienced");
    RedAstronaut susPerson = new RedAstronaut("Suspicious Person", 100, "eXpeRT");

    BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
    BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
    BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
    BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);

    System.out.print("1. ");
    liam.sabotage(bob);
    System.out.println(bob);

    System.out.print("2. ");
    liam.freeze(susPerson);
    System.out.println(susPerson);

    System.out.print("3. ");
    liam.freeze(albert);
    System.out.println(liam);
    System.out.println(albert);

    System.out.print("4. ");
    Gameplay.printPlayers();
    albert.emergencyMeeting();
    Gameplay.printPlayers();

    System.out.print("5. ");
    Gameplay.printPlayers();
    susPerson.emergencyMeeting();
    Gameplay.printPlayers();

    System.out.print("6. ");
    Gameplay.printPlayers();
    bob.emergencyMeeting();
    Gameplay.printPlayers();

    System.out.print("7. ");
    heath.completeTask();
    System.out.println(heath);

    System.out.print("8. ");
    heath.completeTask();
    System.out.println(heath);

    System.out.print("9. ");
    heath.completeTask();
    System.out.println(heath);

    System.out.print("10. ");
    liam.freeze(angel);
    System.out.println(angel);
    System.out.println(liam);

    System.out.print("11. ");
    liam.sabotage(bob);
    liam.sabotage(bob);
    System.out.println(bob);

    System.out.print("12. ");
    liam.freeze(bob);
    System.out.println(bob);

    // Crewmates win scenario
    // System.out.print("13. ");
    // Gameplay.printPlayers();
    // angel.emergencyMeeting();
    // System.out.println(liam);

    // Impostors win scenario
    System.out.print("14. ");
    for (int i = 0; i < 5; i++) {
      liam.sabotage(heath);
      System.out.println(heath);
    }

    System.out.print("15. ");
    liam.freeze(heath);
  }
}
