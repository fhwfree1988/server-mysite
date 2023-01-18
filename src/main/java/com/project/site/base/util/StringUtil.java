package com.project.site.base.util;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StringUtil {
    public static final String EMPTY_STRING = "";
    public static final String SPACE = " ";
    public static final String DOT = ".";
    public static final String COMMA = ",";
    public static final String STAR = "*";
    public static final String COLON = ":";
    public static final String PERCENT = "%";
    public static final String SLASH = "/";
    public static final String BACKSLASH = "\\";
    public static final String QUOTE = "'";
    public static final String DOUBLE_QUOTE = "\"";
    public static final String DASH = "-";
    public static final String INVISIBLE_CONTROL = "\u0011";
    public static final String COMMA_CONTROL = ",\u0011";
    public static final String NULL = "null";
    public static final String PX = "px";
    public static final String HALF_SPACE = "\u200c";
    public static final String UTF_8 = "utf-8";
    public static final String NUMBER_RANGE = "0-9۰-۹";
    public static final String POSITIVE_INTEGER_NUMBER_REGEX = "[0-9۰-۹]+";
    public static final String NEGATIVE_INTEGER_NUMBER_REGEX = "\\-[0-9۰-۹]+";
    public static final String POSITIVE_DECIMAL_NUMBER_REGEX = "[0-9۰-۹]+\\.?[0-9۰-۹]*";
    public static final String NEGATIVE_DECIMAL_NUMBER_REGEX = "\\-[0-9۰-۹]+\\.?[0-9۰-۹]*";
    public static final String EMAIL_REGEX = "^[\\w\\.-_]+@([\\w\\-]+\\.)+[A-Za-z]{2,4}$";
    public static final String IDENTIFIER_REGEX = "^[\\w\\-]+$";
    public static final String MAC_ADDRESS_REGEX = "^([0-9A-Fa-f]{2}(:|-|)){5}([0-9A-Fa-f]){2}$";
    private static final Set<String> REGEX_SPECIAL_CHARACTERS = new HashSet();

    private StringUtil() {
    }

    public static boolean hasText(Object object) {
        return object != null && object.toString().trim().length() > 0;
    }

    public static String toStringOrEmpty(Object value) {
        return value != null ? value.toString() : "";
    }

    public static String getClassNameFromFullPackageName(String fullPackageName) {
        if (fullPackageName != null && fullPackageName.length() > 0) {
            String[] array = fullPackageName.split("\\.");
            if (array.length > 0) {
                return array[array.length - 1];
            }
        }

        return fullPackageName;
    }

    public static String convertStringArrayToString(String[] array, String separator) {
        if (array != null && array.length != 0) {
            StringBuilder result = new StringBuilder();

            for(int i = 0; i < array.length; ++i) {
                result.append(array[i]);
                if (i < array.length - 1) {
                    result.append(separator);
                }
            }

            return result.toString();
        } else {
            return null;
        }
    }

    public static String convertStringArrayToString(String[] array) {
        return convertStringArrayToString(array, ",");
    }

    public static String refineSeparator(String separator) {
        return REGEX_SPECIAL_CHARACTERS.contains(separator) ? "\\" + separator : separator;
    }

    public static String[] convertStringToStringArray(String input, String separator) {
        return input != null && input.trim().length() != 0 ? input.split(refineSeparator(separator)) : new String[0];
    }

    public static String[] convertStringToStringArray(String input) {
        return convertStringToStringArray(input, ",");
    }

    public static String convertCollectionToString(Collection<?> collection, String separator) {
        if (collection != null && !collection.isEmpty()) {
            StringBuilder result = new StringBuilder();
            Iterator iterator = collection.iterator();

            while(iterator.hasNext()) {
                String item = iterator.next().toString();
                result.append(item);
                if (iterator.hasNext()) {
                    result.append(separator);
                }
            }

            return result.toString();
        } else {
            return null;
        }
    }

    public static String convertCollectionToString(Collection<?> collection) {
        return convertCollectionToString(collection, ",");
    }

    public static HashSet<String> convertStringToStringSet(String input, String separator) {
        HashSet<String> result = new HashSet();
        String[] array = convertStringToStringArray(input, separator);
        String[] var4 = array;
        int var5 = array.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String string = var4[var6];
            if (hasText(string.trim())) {
                result.add(string.trim());
            }
        }

        return result;
    }

    public static HashSet<String> convertStringToStringSet(String input) {
        return convertStringToStringSet(input, ",");
    }

    public static HashSet<Long> convertStringToLongSet(String input, String separator) {
        HashSet<Long> result = new HashSet();
        String[] array = convertStringToStringArray(input, separator);
        String[] var4 = array;
        int var5 = array.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String string = var4[var6];
            string = string.trim();
            if (hasText(string)) {
                String trimmedString = PersianUtil.replacePersianWithEnglishNumbers(string);
                result.add(Long.valueOf(trimmedString));
            }
        }

        return result;
    }

    public static HashSet<Long> convertStringToLongSet(String input) {
        return convertStringToLongSet(input, ",");
    }

    public static HashSet<Integer> convertStringToIntegerSet(String input, String separator) {
        HashSet<Integer> result = new HashSet();
        String[] array = convertStringToStringArray(input, separator);
        String[] var4 = array;
        int var5 = array.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String string = var4[var6];
            string = string.trim();
            if (hasText(string)) {
                String trimmedString = PersianUtil.replacePersianWithEnglishNumbers(string);
                result.add(Integer.valueOf(trimmedString));
            }
        }

        return result;
    }

    public static Set<Integer> convertStringToIntegerSet(String input) {
        return convertStringToIntegerSet(input, ",");
    }

    public static HashSet<Short> convertStringToShortSet(String input, String separator) {
        HashSet<Short> result = new HashSet();
        String[] array = convertStringToStringArray(input, separator);
        String[] var4 = array;
        int var5 = array.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String string = var4[var6];
            string = string.trim();
            if (hasText(string)) {
                String trimmedString = PersianUtil.replacePersianWithEnglishNumbers(string);
                result.add(Short.valueOf(trimmedString));
            }
        }

        return result;
    }

    public static Set<Short> convertStringToShortSet(String input) {
        return convertStringToShortSet(input, ",");
    }

    public static ArrayList<String> convertStringToStringList(String input, String separator) {
        ArrayList<String> result = new ArrayList();
        String[] array = convertStringToStringArray(input, separator);
        String[] var4 = array;
        int var5 = array.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String string = var4[var6];
            if (hasText(string.trim())) {
                result.add(string.trim());
            }
        }

        return result;
    }

    public static ArrayList<String> convertStringToStringList(String input) {
        return convertStringToStringList(input, ",");
    }

    public static ArrayList<Long> convertStringToLongList(String input, String separator) {
        ArrayList<Long> result = new ArrayList();
        String[] array = convertStringToStringArray(input, separator);
        String[] var4 = array;
        int var5 = array.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String string = var4[var6];
            string = string.trim();
            if (hasText(string)) {
                String trimmedString = PersianUtil.replacePersianWithEnglishNumbers(string);
                result.add(Long.valueOf(trimmedString));
            }
        }

        return result;
    }

    public static ArrayList<Long> convertStringToLongList(String input) {
        return convertStringToLongList(input, ",");
    }

    public static ArrayList<Integer> convertStringToIntegerList(String input, String separator) {
        ArrayList<Integer> result = new ArrayList();
        String[] array = convertStringToStringArray(input, separator);
        String[] var4 = array;
        int var5 = array.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String string = var4[var6];
            string = string.trim();
            if (hasText(string)) {
                String trimmedString = PersianUtil.replacePersianWithEnglishNumbers(string);
                result.add(Integer.valueOf(trimmedString));
            }
        }

        return result;
    }

    public static ArrayList<Short> convertStringToShortList(String input) {
        return convertStringToShortList(input, ",");
    }

    public static ArrayList<Short> convertStringToShortList(String input, String separator) {
        ArrayList<Short> result = new ArrayList();
        String[] array = convertStringToStringArray(input, separator);
        String[] var4 = array;
        int var5 = array.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String string = var4[var6];
            string = string.trim();
            if (hasText(string)) {
                String trimmedString = PersianUtil.replacePersianWithEnglishNumbers(string);
                result.add(Short.valueOf(trimmedString));
            }
        }

        return result;
    }

    public static ArrayList<Integer> convertStringToIntegerList(String input) {
        return convertStringToIntegerList(input, ",");
    }

    public static String toFirstUpper(String input) {
        return !hasText(input) ? input : input.substring(0, 1).toUpperCase() + (input.length() > 1 ? input.substring(1) : "");
    }

    public static String toFirstLower(String input) {
        return !hasText(input) ? input : input.substring(0, 1).toLowerCase() + (input.length() > 1 ? input.substring(1) : "");
    }

    public static String convertFullyUpperCaseToUpperCamelCase(String fullyUpperCase) {
        if (!hasText(fullyUpperCase)) {
            return fullyUpperCase;
        } else {
            String[] parts = fullyUpperCase.split("_");
            StringBuilder result = new StringBuilder();
            String[] var3 = parts;
            int var4 = parts.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String part = var3[var5];
                result.append(toFirstUpper(part.toLowerCase()));
            }

            return result.toString();
        }
    }

    public static String convertFullyUpperCaseToLowerCamelCase(String fullyUpperCase) {
        return toFirstLower(convertFullyUpperCaseToUpperCamelCase(fullyUpperCase));
    }

    public static String convertUpperCamelCaseToFullyUpperCase(String upperCamelCase) {
        if (hasText(upperCamelCase) && !upperCamelCase.equals(upperCamelCase.toUpperCase())) {
            StringBuilder fullyUpperCase = new StringBuilder();

            for(int i = 0; i < upperCamelCase.length(); ++i) {
                Character currentChar = upperCamelCase.charAt(i);
                if (i > 0 && Character.isUpperCase(currentChar)) {
                    fullyUpperCase.append('_');
                }

                fullyUpperCase.append(Character.toUpperCase(currentChar));
            }

            return fullyUpperCase.toString();
        } else {
            return upperCamelCase;
        }
    }

    public static String convertLowerCamelCaseToFullyUpperCase(String lowerCamelCase) {
        return convertUpperCamelCaseToFullyUpperCase(toFirstUpper(lowerCamelCase));
    }

    public static String getCorrectedFileName(String fileName) {
        return fileName.replace('/', '_').replace('\\', '_').replace(':', '_').replace('?', '_').replace('*', '_').replace('"', '_').replace('<', '_').replace('>', '_').replace('|', '_');
    }

    public static String convertStringToCurrency(String input) {
        if (!hasText(input)) {
            return null;
        } else {
            input = convertCurrencyToString(input);
            StringBuilder currencyBuilder = new StringBuilder();
            if (input.startsWith("-")) {
                currencyBuilder.append("-");
                input = input.substring(1);
            }

            int nonDecimalPartLength = input.contains(".") ? input.indexOf(".") : input.length();

            for(int i = 0; i < input.length(); ++i) {
                if (input.charAt(i) == '.') {
                    currencyBuilder.append(input.substring(i));
                    break;
                }

                if (currencyBuilder.length() > 0 && !"-".equals(currencyBuilder.toString()) && (nonDecimalPartLength - i) % 3 == 0) {
                    currencyBuilder.append(",");
                }

                currencyBuilder.append(input.charAt(i));
            }

            return currencyBuilder.toString();
        }
    }

    public static String convertCurrencyToString(String currency) {
        return currency != null ? currency.replace(",", "") : currency;
    }

    public static String breakText(String input, int breakSize) {
        if (!hasText(input)) {
            return "";
        } else {
            return input.length() > breakSize ? input.substring(0, breakSize) + "..." : input;
        }
    }

    public static String getPackagePrefix(String fullyQualifiedClassName, int numberOfPackagePrefixParts) {
        int dotIndex = -1;

        for(int i = 0; i < numberOfPackagePrefixParts; ++i) {
            dotIndex = fullyQualifiedClassName.indexOf(46, dotIndex + 1);
        }

        return fullyQualifiedClassName.substring(0, dotIndex);
    }

    public static String getFormattedSize(long sizeInBytes, boolean showFraction) {
        if (sizeInBytes < 1024L) {
            return sizeInBytes + "B";
        } else {
            long fraction = sizeInBytes % 1024L;
            sizeInBytes /= 1024L;
            if (sizeInBytes < 1024L) {
                return (showFraction ? sizeInBytes + "." + fraction : sizeInBytes + 1L) + "KB";
            } else {
                fraction = sizeInBytes % 1024L;
                sizeInBytes /= 1024L;
                if (sizeInBytes < 1024L) {
                    return (showFraction ? sizeInBytes + "." + fraction : sizeInBytes + 1L) + "MB";
                } else {
                    fraction = sizeInBytes % 1024L;
                    sizeInBytes /= 1024L;
                    return (showFraction ? sizeInBytes + "." + fraction : sizeInBytes + 1L) + "GB";
                }
            }
        }
    }

    public static List<String> sortByLength(Collection<String> collection, boolean ascending) {
        List<String> sortedList = new ArrayList();
        if (collection != null && !collection.isEmpty()) {
            sortedList = Arrays.asList(collection.toArray(new String[collection.size()]));
            Comparator<String> comparator = Comparator.comparingInt((a) -> {
                return a.length();
            });
            comparator = ascending ? comparator : comparator.reversed();
            Collections.sort((List)sortedList, comparator);
        }

        return (List)sortedList;
    }

    public static boolean isValidIPAddress(String ip, boolean acceptStar) {
        if (ip == null) {
            return false;
        } else {
            try {
                ip = PersianUtil.replacePersianWithEnglishNumbers(ip);
                List<String> ipTokens = Arrays.asList(ip.split("\\."));
                if (ipTokens.size() != 4) {
                    return false;
                } else if (Integer.valueOf(((String)ipTokens.get(0)).trim()) > 255) {
                    return false;
                } else if (Integer.valueOf(((String)ipTokens.get(1)).trim()) > 255) {
                    return false;
                } else if (Integer.valueOf(((String)ipTokens.get(2)).trim()) > 255) {
                    return false;
                } else {
                    if (acceptStar) {
                        String[] part4Items = ((String)ipTokens.get(3)).trim().split("\\*");
                        String[] var4 = part4Items;
                        int var5 = part4Items.length;

                        for(int var6 = 0; var6 < var5; ++var6) {
                            String part4Item = var4[var6];
                            if ("*".equals(part4Item)) {
                                return true;
                            }

                            if (!"".equals(part4Item) && Integer.valueOf(part4Item) > 255) {
                                return false;
                            }
                        }
                    } else if (Integer.valueOf(((String)ipTokens.get(3)).trim()) > 255) {
                        return false;
                    }

                    return true;
                }
            } catch (NumberFormatException var8) {
                return false;
            }
        }
    }

    public static Long convertStringIpToNumber(String ip) {
        if (isValidIPAddress(ip, false)) {
            String[] ipOctets = ip.split("\\.");
            return Long.valueOf(ipOctets[0]) * 256L * 256L * 256L + Long.valueOf(ipOctets[1]) * 256L * 256L + Long.valueOf(ipOctets[2]) * 256L + Long.valueOf(ipOctets[3]);
        } else {
            return null;
        }
    }

    public static String removePreTag(String response) {
        if ((response.startsWith("<pre") || response.startsWith("<PRE")) && (response.endsWith("</pre>") || response.endsWith("</PRE>"))) {
            response = response.substring(response.indexOf(62) + 1, response.length() - 6);
        }

        return response;
    }

    public static String separateWordsBySpace(String input) {
        if (!hasText(input)) {
            return input;
        } else {
            StringBuilder output = new StringBuilder("");

            for(int i = 0; i < input.length(); ++i) {
                char currentChar = input.charAt(i);
                if (i > 0 && Character.isUpperCase(currentChar) || Character.isDigit(currentChar)) {
                    output.append(' ');
                }

                output.append(currentChar);
            }

            return output.toString();
        }
    }

    public static String separateWordsByDot(String input) {
        return !hasText(input) ? input : separateWordsBySpace(input).replace(" ", ".").toLowerCase();
    }

    public static String separateWordsByDash(String input) {
        return !hasText(input) ? input : separateWordsBySpace(input).replace(" ", "-").toLowerCase();
    }

    public static String getPlural(String singular) {
        if (!hasText(singular)) {
            return singular;
        } else if (singular.endsWith("y") && singular.length() > 1) {
            return singular.substring(0, singular.length() - 1) + "ies";
        } else {
            return !singular.endsWith("s") && !singular.endsWith("x") && !singular.endsWith("z") && !singular.endsWith("th") && !singular.endsWith("ch") && !singular.endsWith("sh") ? singular + "s" : singular + "es";
        }
    }

    static {
        REGEX_SPECIAL_CHARACTERS.add("[");
        REGEX_SPECIAL_CHARACTERS.add("]");
        REGEX_SPECIAL_CHARACTERS.add("{");
        REGEX_SPECIAL_CHARACTERS.add("}");
        REGEX_SPECIAL_CHARACTERS.add("^");
        REGEX_SPECIAL_CHARACTERS.add("$");
        REGEX_SPECIAL_CHARACTERS.add("|");
        REGEX_SPECIAL_CHARACTERS.add(".");
        REGEX_SPECIAL_CHARACTERS.add("?");
        REGEX_SPECIAL_CHARACTERS.add("*");
        REGEX_SPECIAL_CHARACTERS.add("+");
        REGEX_SPECIAL_CHARACTERS.add("(");
        REGEX_SPECIAL_CHARACTERS.add(")");
        REGEX_SPECIAL_CHARACTERS.add("\\");
    }
}
