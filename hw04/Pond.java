public class Pond {
  public static void main(String[] args) {
    // instantiate frogs
    Frog peepo = new Frog("Peepo");
    Frog pepe = new Frog("Pepe", 10, 15.0);
    Frog peepaw = new Frog("Peepaw", 4.6, 5.0);
    Frog gromp = new Frog("Gromp");

    // instantiate flies
    Fly fly1 = new Fly(1, 3);
    Fly fly2 = new Fly(6);
    Fly fly3 = new Fly();

    // change species of frogs
    peepo.setSpecies("1331 Frogs");
    System.out.println(peepo);

    // attempt to feed peepo
    peepo.eat(fly2);
    System.out.println(fly2);

    // make peepo a big boy and feed him again
    peepo.grow(8);
    peepo.eat(fly2);
    System.out.println(fly2);
    System.out.println(peepo);

    // my own frog
    System.out.println(gromp);
    
    // grow peepaw
    peepaw.grow(4);

    // compare Peepaw and Pepe
    System.out.println(peepaw);
    System.out.println(pepe);

    // feed the rest of the flies to Peepaw
    peepaw.eat(fly1);
    peepaw.eat(fly3);
    System.out.println(peepaw);
  }  
}
