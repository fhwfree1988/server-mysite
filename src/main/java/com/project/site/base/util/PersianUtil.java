package com.project.site.base.util;

public class PersianUtil {
    private PersianUtil() {
    }

    public static String replacePersianWithEnglishNumbers(String input) {
        return input == null ? null : input.replace('۰', '0').replace('۱', '1').replace('۲', '2').replace('۳', '3').replace('۴', '4').replace('۵', '5').replace('۶', '6').replace('۷', '7').replace('۸', '8').replace('۹', '9');
    }

    public static String replaceEnglishWithPersianNumbers(String input) {
        return input == null ? null : input.replace('0', '۰').replace('1', '۱').replace('2', '۲').replace('3', '۳').replace('4', '۴').replace('5', '۵').replace('6', '۶').replace('7', '۷').replace('8', '۸').replace('9', '۹');
    }

    public static String convertArabicCharactersToPersianCharacters(String input) {
        if (input == null) {
            return null;
        } else {
            input = input.replace("ي", "ی");
            input = input.replace("ك", "ک");
            return input;
        }
    }

    public static String convertPersianCharactersToArabicCharacters(String input) {
        if (input == null) {
            return null;
        } else {
            input = input.replace("ی", "ي");
            input = input.replace("ک", "ك");
            return input;
        }
    }

    public static boolean equalsIgnoreArabicCharacters(String input1, String input2) {
        if (input1 == null && input2 == null) {
            return true;
        } else {
            return input1 != null && input2 != null ? convertArabicCharactersToPersianCharacters(input1).equals(convertArabicCharactersToPersianCharacters(input2)) : false;
        }
    }
}