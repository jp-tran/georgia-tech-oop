/**
 * Defines fly objects that exist within a pond.
 */
public class Fly {
  // instance variables
  private double mass;
  private double speed;

  // static constants
  public static final double DEFAULT_MASS = 5;
  public static final double DEFAULT_SPEED = 10;

  // constructors
  public Fly() {
    this(DEFAULT_MASS);
  }

  public Fly(double mass) {
    this(mass, DEFAULT_SPEED);
  }

  public Fly(double mass, double speed) {
    // the parameter "mass" takes precedence over the instance variable "mass"
    // so we have to have this.mass to refer to the instance variable
    this.mass = mass;
    this.speed = speed;
  }

  // methods

  // setters and getters
  public double getMass() {
    return mass;
  }

  public void setMass(double newMass) {
    if (isLegalMass(newMass)) {
      mass = newMass;
    }
  }

  public static boolean isLegalMass(double newMass) {
    return (newMass >= 0 ? true : false);
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double newSpeed) {
    if (isLegalSpeed(newSpeed)) {
      speed = newSpeed;
    }
  }

  public static boolean isLegalSpeed(double newSpeed) {
    return (newSpeed >= 0 ? true : false);
  }

  // overriding Java Object's toString()
  public String toString() {
    String strMass = String.format("%.2f", mass);
    String strSpeed = String.format("%.2f", speed);

    if (mass == 0) {
      return "I'm dead, but I used to be a fly with a speed of " + strSpeed + ".";
    }
    return "I'm a speedy fly with " + strSpeed + " speed and " + strMass + " mass.";
  }

  // other methods
  public void grow(int addedMass) {
    for (int i = 0; i < addedMass; i++) {
      if (mass < 20) {
        speed++;
      }
      else {
        speed += 0.5;
      }
      mass++;
    }
  }

  public boolean isDead() {
    return mass == 0;
  }
}
