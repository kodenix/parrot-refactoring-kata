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

    static Parrot createNorwegianBlueParrot(final boolean isNailed, final double voltage) {
        return new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, voltage, isNailed);
    }

    static Parrot createAfricanParrot(final int numberOfCoconuts) {
        return new Parrot(ParrotTypeEnum.AFRICAN, numberOfCoconuts, 0, false);
    }

    static Parrot createEuropeanParrot() {
        return new European(ParrotTypeEnum.EUROPEAN, 0, 0, false);
    }

    public double getSpeed() {
        return switch (type) {
            case EUROPEAN -> BASE_SPEED;
            case AFRICAN -> Math.max(0, BASE_SPEED - LOAD_FACTOR * numberOfCoconuts);
            case NORWEGIAN_BLUE -> (isNailed) ? 0 : getBaseSpeed(voltage);
        };
    }

    public String getCry() {
        return switch (type) {
            case AFRICAN -> African.cry();
            case NORWEGIAN_BLUE -> Norwegian.cry(voltage);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    public static double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * BASE_SPEED);
    }

}
