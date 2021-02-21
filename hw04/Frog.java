/**
 * Defines frog objects that exist within a pond.
 */
public class Frog {
  // instace variables
  private String name;
  private int age; // in months
  private double tongueSpeed;
  private boolean isFroglet;
  private static String species; // attr is shared across all instances

  // static constants
  public static final int DEFAULT_AGE = 5;
  public static final double DEFAULT_TONGUE_SPEED = 5;
  public static final String DEFAULT_SPECIES = "Rare Pepe";

  // constructors
  public Frog(String name) {
    this(name, DEFAULT_AGE, DEFAULT_TONGUE_SPEED);
  }

  public Frog(String name, double ageInYears, double tongueSpeed) {
    this(name, (int) (ageInYears*12), tongueSpeed);
  }

  public Frog(String name, int age, double tongueSpeed) {
    this.name = name;
    this.age = age;
    this.tongueSpeed = tongueSpeed;
    this.isFroglet = 1 < age && age < 7;
    species = DEFAULT_SPECIES;
  }

  // methods
  public void grow() {
    this.grow(1);
  }

  public void grow(int numMonths) {
    // age frog and change tongue speed
    for (int i = 0; i < numMonths; i++) {
      if (age < 12) {
        tongueSpeed++;
      }
      else if (age >= 30) {
        tongueSpeed--;
      }
      age++;
    }

    // prevent tongue speed from falling below 5
    if (tongueSpeed < 5) {
      tongueSpeed = 5;
    }

    // update froglet status
    isFroglet = 1 < age && age < 7;
  }

  public void eat(Fly fly) {
    // frogs don't like dead flies
    if (fly.isDead()) return;

    // can the fly be caught?
    boolean isCaught = tongueSpeed > fly.getSpeed();

    if (isCaught) {
      if (fly.getMass() >= 0.5*age) {
        this.grow();
      }
      fly.setMass(0);
    }
    else {
      fly.grow(1);
    }
  }

  // override Java Object's toString()
  public String toString() {
    String strTongueSpeed = String.format("%.2f", tongueSpeed);
    String frogType = isFroglet ? "froglet!" : "frog.";

    return "My name is " + name + " and I'm a rare " + frogType + " I'm " + age + " months old and my tongue has a speed of " + strTongueSpeed + ".";
  }

  // getters and setters for species
  public String getSpecies() {
    return species;
  }

  public void setSpecies(String newSpecies) {
    if (isValidSpecies(newSpecies)) {
      species = newSpecies;
    }
  }

  public boolean isValidSpecies(String newSpecies) {
    return (newSpecies != "" ? true : false);
  }
}