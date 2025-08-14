package colorcoder;

public enum MinorColor {
    BLUE(0), ORANGE(1), GREEN(2), BROWN(3), SLATE(4);

    private final int index;
    MinorColor(int index) { this.index = index; }

    public int getIndex() { return index; }

    public String getName() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    public static MinorColor fromIndex(int index) {
        return values()[index];
    }
}
