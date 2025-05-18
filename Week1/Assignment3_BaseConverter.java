package Week1;

public class Assignment3_BaseConverter {
    public static int toDecimal(String inputValue, int inputBase) throws NumberFormatException {
        return Integer.parseInt(inputValue, inputBase);
    }

    public static String fromDecimal(int decimalValue, int outputBase) {
        switch (outputBase) {
            case 2: return Integer.toBinaryString(decimalValue);
            case 10: return Integer.toString(decimalValue);
            case 16: return Integer.toHexString(decimalValue).toUpperCase();
            default: return "";
        }
    }
}
