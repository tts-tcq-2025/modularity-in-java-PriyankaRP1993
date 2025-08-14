package colorcoder;

public enum MajorColor {
    WHITE(0), RED(1), BLACK(2), YELLOW(3), VIOLET(4);

    private final int index;
    MajorColor(int index) { this.index = index; }

    public int getIndex() { return index; }

    public String getName() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    public static MajorColor fromIndex(int index) {
        return values()[index];
    }
}
