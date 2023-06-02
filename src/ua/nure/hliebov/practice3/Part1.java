package ua.nure.hliebov.practice3;

public class Part1 {

    public static void main(String[] args) {
        String inputData = Util.readFile("part1.txt");

        String result1 = convert1(inputData);
        String result2 = convert2(inputData);
        String result3 = convert3(inputData);
        String result4 = convert4(inputData);

        System.out.println("Part1");
        System.out.println("============================");

        System.out.println("Output of convert1:");
        System.out.println("----------------------------");
        System.out.println(result1);
        System.out.println("----------------------------");

        System.out.println();
        System.out.println("Output of convert2:");
        System.out.println("----------------------------");
        System.out.println(result2);
        System.out.println("----------------------------");

        System.out.println();
        System.out.println("Output of convert3:");
        System.out.println("----------------------------");
        System.out.println(result3);
        System.out.println("----------------------------");

        System.out.println();
        System.out.println("Output of convert4:");
        System.out.println("----------------------------");
        System.out.println(result4);
        System.out.println("============================");

        System.out.println();
    }

    public static String convert1(String input) {
        StringBuilder result = new StringBuilder();
        String[] lines = input.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String  line = lines[i];
            String[] parts = line.split(";");

            String login = parts[0];
            String email = parts[2];

            result.append(login).append(": ").append(email);
            if (i+1 != lines.length)  result.append("\n");
        }

        return result.toString();
    }

    public static String convert2(String input) {
        StringBuilder result = new StringBuilder();
        String[] lines = input.split("\r?\n");
        for (int i = 1; i < lines.length; i++) {
            String  line = lines[i];
            String[] parts = line.split(";");

            String name = parts[1];
            String email = parts[2];

            result.append(name).append(" (email: ").append(email).append(")");
            if (i+1 != lines.length)  result.append("\n");
        }

        return result.toString();
    }

    public static String convert3(String input) {
        StringBuilder result = new StringBuilder();
        String[] lines = input.split("\r?\n");

        String domainsStr = "";
        for (int i = 1; i < lines.length; i++) {
            String domain = lines[i].split(";")[2].split("@")[1];

            boolean isDomainHave = false;
            if (domainsStr.contains(domain)) {
                isDomainHave = true;
            }
            if (!isDomainHave) {
                if (i == 1) {
                    domainsStr += domain;
                } else
                {
                    domainsStr += ";" + domain;
                }
            }
        }

        String[] domains = domainsStr.split(";");

        for (int i = 0; i < domains.length; i++) {
            result.append(domains[i]).append(" ==>");
            for (int k = 1; k < lines.length; k++) {
                String line = lines[k];
                if (line.contains(domains[i])) {
                    String[] parts = line.split(";");
                    String login = parts[0];
                    result.append(" ").append(login).append(";");
                }
            }
            int lastIndex = result.length() - 1;
            if (lastIndex >= 0 && result.charAt(lastIndex) == ';') {
                result.deleteCharAt(lastIndex);
            }
            if (i+1 != domains.length) result.append("\n");
        }
        return result.toString();
    }

    public static String convert4(String input) {
        StringBuilder result = new StringBuilder();
        String[] lines = input.split("\r?\n");
        result.append(lines[0]).append(";Password\n");
        for (int i = 1; i < lines.length; i++) {
            String  line = lines[i];
            result.append(line).append(";").append(generatePassword());
            if (i+1 != lines.length)  result.append("\n");
        }
        return result.toString();
    }

    private static int generatePassword() {
        return (int) (Math.random() * 9000) + 1000;
    }
}
