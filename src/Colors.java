public enum Colors {
    RED(0), GREEN(1), YELLOW(2);

    private final int value;

    private Colors(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
