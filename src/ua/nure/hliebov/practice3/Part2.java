package ua.nure.hliebov.practice3;

public class Part2 {

    public static void main(String[] args){
        System.out.println("Part2");
        System.out.println("============================");
        String inputData = Util.readFile("part2.txt");
        String result = convert(inputData);
        System.out.println(result);
        System.out.println("============================");
        System.out.println();
    }
    public static String convert(String input) {
        String[] words = input.split("\\P{L}+");

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        StringBuilder minWords = new StringBuilder();
        StringBuilder maxWords = new StringBuilder();

        for (String word : words) {
            int length = word.length();

            if (length < minLength) {
                minLength = length;
                if (!minWords.toString().contains(word)) {
                    minWords = new StringBuilder(word);
                }
            } else if (length == minLength && !minWords.toString().contains(word)) {
                minWords.append(", ").append(word);
            }

            if (length > maxLength) {
                maxLength = length;
                if (!maxWords.toString().contains(word)) {
                    maxWords = new StringBuilder(word);
                }
            } else if (length == maxLength && !maxWords.toString().contains(word)) {
                maxWords.append(", ").append(word);
            }
        }

        return "Min: " + minWords.toString() + "\nMax: " + maxWords.toString();
    }
}
