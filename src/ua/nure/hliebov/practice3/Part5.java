package ua.nure.hliebov.practice3;

public class Part5 {
    public static void main(String[] args) {
        System.out.println("Part5");
        System.out.println("============================");
        int[] decimalNumbers = { 1, 2, 3, 4, 5, 94, 95, 96, 97, 98, 99, 100 };

        for (int decimal : decimalNumbers) {
            String roman = decimal2Roman(decimal);
            int convertedDecimal = roman2Decimal(roman);
            System.out.printf("%d --> %s --> %d%n", decimal, roman, convertedDecimal);
        }
        System.out.println("============================");
        System.out.println();
    }
    public static String decimal2Roman(int x) {
        if (x < 1 || x > 100) {
            throw new IllegalArgumentException("Number out of range (1-100): " + x);
        }

        StringBuilder result = new StringBuilder();

        int[] decimalValues = { 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanSymbols = { "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        for (int i = 0; i < decimalValues.length; i++) {
            while (x >= decimalValues[i]) {
                result.append(romanSymbols[i]);
                x -= decimalValues[i];
            }
        }

        return result.toString();
    }

    public static int roman2Decimal(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Invalid Roman numeral: " + s);
        }

        s = s.toUpperCase();
        int result = 0;

        int[] decimalValues = { 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanSymbols = { "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        int i = 0;
        int j = 0;

        while (i < s.length()) {
            if (s.startsWith(romanSymbols[j], i)) {
                result += decimalValues[j];
                i += romanSymbols[j].length();
            } else {
                j++;
            }
        }

        return result;
    }
}
