package parrot;

public class Parrot {

    public static final double BASE_SPEED = 12.0;
    public static final double LOAD_FACTOR = 9.0;

    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        return switch (type) {
            case EUROPEAN -> BASE_SPEED;
            case AFRICAN -> Math.max(0, BASE_SPEED - LOAD_FACTOR * numberOfCoconuts);
            case NORWEGIAN_BLUE -> (isNailed) ? 0 : getBaseSpeed(this, voltage);
        };
    }

    public String getCry() {
        return switch (type) {
            case EUROPEAN -> "Sqoork!";
            case AFRICAN -> "Sqaark!";
            case NORWEGIAN_BLUE -> voltage > 0 ? "Bzzzzzz" : "...";
        };
    }

    public static double getBaseSpeed(Parrot parrot, double voltage) {
        return Math.min(24.0, voltage * BASE_SPEED);
    }

}
