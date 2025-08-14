package colorcoder;

public final class Main {

    private static void testNumberToPair(int pairNumber, MajorColor expectedMajor, MinorColor expectedMinor) {
        ColorPair colorPair = ColorPair.fromPairNumber(pairNumber);
        System.out.println("Got pair " + colorPair);
        assert colorPair.getMajor() == expectedMajor;
        assert colorPair.getMinor() == expectedMinor;
    }

    private static void testPairToNumber(MajorColor major, MinorColor minor, int expectedPairNumber) {
        int pairNumber = ColorPair.toPairNumber(major, minor);
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
