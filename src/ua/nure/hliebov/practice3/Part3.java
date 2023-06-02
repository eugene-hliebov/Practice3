package ua.nure.hliebov.practice3;

public class Part3 {
    public static void main(String[] args){
        System.out.println("Part3");
        System.out.println("============================");
        String inputData = Util.readFile("part2.txt");
        String result = convert(inputData);
        System.out.println(result);
        System.out.println("============================");
        System.out.println();
    }

    public static String convert(String input) {
        StringBuilder result = new StringBuilder(input);
        int length = input.length();
        int wordStart = -1;
        boolean capitalizeNext = false;

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);

            if (Character.isLetter(c)) {
                if (wordStart == -1) {
                    wordStart = i;
                }

                if (i > 0 && !Character.isLetter(input.charAt(i - 1))) {
                    capitalizeNext = true;
                }
            } else if (wordStart != -1) {
                if (i - wordStart >= 3) {
                    if (capitalizeNext) {
                        result.setCharAt(wordStart, Character.toUpperCase(input.charAt(wordStart)));
                    } else {
                        result.setCharAt(wordStart, Character.toLowerCase(input.charAt(wordStart)));
                    }
                }

                wordStart = -1;
                capitalizeNext = false;
            }
        }

        if (wordStart != -1 && length - wordStart >= 3) {
            if (capitalizeNext) {
                result.setCharAt(wordStart, Character.toUpperCase(input.charAt(wordStart)));
            } else {
                result.setCharAt(wordStart, Character.toLowerCase(input.charAt(wordStart)));
            }
        }

        return result.toString().substring(0, result.toString().length() - 1);
    }
}
