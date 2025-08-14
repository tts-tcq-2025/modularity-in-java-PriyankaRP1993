package colorcoder;

public final class Main {

    interface IndexedColor {
        int getIndex();
        String getName();
    }

    enum MajorColor implements IndexedColor {
        WHITE(0), RED(1), BLACK(2), YELLOW(3), VIOLET(4);
        private final int index;
        MajorColor(int index) { this.index = index; }
        public int getIndex() { return index; }
        public String getName() { return name().charAt(0) + name().substring(1).toLowerCase(); }
        public static MajorColor fromIndex(int index) { return values()[index]; }
    }

    enum MinorColor implements IndexedColor {
        BLUE(0), ORANGE(1), GREEN(2), BROWN(3), SLATE(4);
        private final int index;
        MinorColor(int index) { this.index = index; }
        public int getIndex() { return index; }
        public String getName() { return name().charAt(0) + name().substring(1).toLowerCase(); }
        public static MinorColor fromIndex(int index) { return values()[index]; }
    }

    static class ColorPair {
        private final MajorColor major;
        private final MinorColor minor;

        public ColorPair(MajorColor major, MinorColor minor) {
            this.major = major;
            this.minor = minor;
        }
        public MajorColor getMajor() { return major; }
        public MinorColor getMinor() { return minor; }
        public String toString() { return major.getName() + " " + minor.getName(); }
    }

    static ColorPair getColorFromPairNumber(int pairNumber) {
        int zeroBased = pairNumber - 1;
        return new ColorPair(
            MajorColor.fromIndex(zeroBased / MinorColor.values().length),
            MinorColor.fromIndex(zeroBased % MinorColor.values().length)
        );
    }

    static int getPairNumberFromColor(MajorColor major, MinorColor minor) {
        return major.getIndex() * MinorColor.values().length + minor.getIndex() + 1;
    }

    static void testNumberToPair(int pairNumber, MajorColor expectedMajor, MinorColor expectedMinor) {
        ColorPair colorPair = getColorFromPairNumber(pairNumber);
        System.out.println("Got pair " + colorPair);
        assert colorPair.getMajor() == expectedMajor;
        assert colorPair.getMinor() == expectedMinor;
    }

    static void testPairToNumber(MajorColor major, MinorColor minor, int expectedPairNumber) {
        int pairNumber = getPairNumberFromColor(major, minor);
        System.out.println("Got pair number " + pairNumber);
        assert pairNumber == expectedPairNumber;
    }

    public static void main(String[] args) {
        testNumberToPair(4, MajorColor.WHITE, MinorColor.BROWN);
        testNumberToPair(5, MajorColor.WHITE, MinorColor.SLATE);
        testPairToNumber(MajorColor.BLACK, MinorColor.ORANGE, 12);
        testPairToNumber(MajorColor.VIOLET, MinorColor.SLATE, 25);
    }
}
