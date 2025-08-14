package colorcoder;

public class ColorPairMapper {
    private final MajorColor major;
    private final MinorColor minor;

    public ColorPairMapper(MajorColor major, MinorColor minor) {
        this.major = major;
        this.minor = minor;
    }

    public MajorColor getMajor() { return major; }
    public MinorColor getMinor() { return minor; }

    @Override
    public String toString() {
        return major.getName() + " " + minor.getName();
    }

    public static ColorPairMapper fromPairNumber(int pairNumber) {
        int zeroBased = pairNumber - 1;
        return new ColorPairMapper(
            MajorColor.fromIndex(zeroBased / MinorColor.values().length),
            MinorColor.fromIndex(zeroBased % MinorColor.values().length)
        );
    }

    public static int toPairNumber(MajorColor major, MinorColor minor) {
        return major.getIndex() * MinorColor.values().length + minor.getIndex() + 1;
    }
}
