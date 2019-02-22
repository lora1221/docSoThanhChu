package docSoThanhChu;
import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class docSoThanhChu {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your weight: (larger than 0 and smaller than 999)");
        int weight = keyboard.nextInt();
        String result = "";

        if (weight < 10 && weight >= 0) {
            result = smallerThan10(weight);
        } else if (weight == 10) {
            result = "ten";
        } else if (weight == 11) {
            result = "eleven";
        } else if (weight == 12) {
            result = "twelve";
        } else if (weight < 20) {
            result = smallerThan20(weight) + "teen";
        } else if (weight < 100) {
            result = largerThan20(weight);
        } else {
            result = largerThan100(weight);
        }

        System.out.println(result);

        keyboard.close();
    }

    public static String smallerThan10(int numb) {
        String result = "";
        switch (numb) {
            case 1:
                result = "one";
                break;
            case 2:
                result = "two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
                result = "four";
                break;
            case 5:
                result = "five";
                break;
            case 6:
                result = "six";
                break;
            case 7:
                result = "seven";
                break;
            case 8:
                result = "eight";
                break;
            case 9:
                result = "nine";
                break;
        }
        return result;
    }

    public static String smallerThan20(int numb) {
        int ones = numb % 10;
        String result = "";
        switch (ones) {
            case 3:
                result = "thir";
                break;
            case 4:
                result = "four";
                break;
            case 5:
                result = "fif";
                break;
            default:
                result = smallerThan10(ones);

        }
        return result;

    }

    public static String largerThan20(int numb) {
        int tens = numb / 10;
        int ones = numb % 10;
        String readTens = "";
        String readOnes = "";
        switch(tens) {
            case 2:
                readTens = "twenty ";
                break;
            case 4:
                readTens = "forty ";
                break;
            default:
                readTens = smallerThan20(tens) + "ty ";
        }
        readOnes = smallerThan10(ones);
        String result = readTens + readOnes;
        return result;
    }

    public static String largerThan100(int numb) {
        int hund = numb / 100;
        int rest = numb % 100;
        String hundreds = smallerThan10(hund) + " hundred and ";
        String theRest = "";
        if (rest < 10) {
            theRest = smallerThan10(rest);
        } else if (rest < 20) {
            if (rest == 10) {
                theRest = "ten";
            } else if (rest == 11) {
                theRest = "eleven";
            } else if (rest == 12) {
                theRest = "twelve";
            } else {
                theRest = smallerThan20(rest) + "teen";
            }
        } else {
            theRest = largerThan20(rest);
        }

        String result = hundreds + theRest;
        return result;
    }
}
