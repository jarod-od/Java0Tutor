package by.java_intro.strings_and_basics_of_text_processing_3.arr1;
/**
 *  1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case. 
 */
public class Main {

    public static void main(String[] args) {

        char[][] names = new char[][] {
            "camelCase".toCharArray() , "masterBranch".toCharArray() , "megaSuperMainClass".toCharArray()
        };

        System.out.println("Vars names: ");
        for (char[] name : names) {
            System.out.print(new String(name) + " ");
        }
        System.out.println();

        for (int i = 0; i < names.length; i++) {
            
            for (int j = 0; j < names[i].length; j++) {
                if(names[i][j] < 97) {
                    names[i] = convert(names[i], j);
                }
            }
        }
        System.out.println();

        System.out.println("New vars names: ");
        for (char[] name : names) {
            System.out.print(new String(name) + " ");
        }
        System.out.println();
    }

    public static char[] convert(char[] source, int index) {
        char[] t = new char[source.length + 1];
        for (int i = 0; i < index; i++) {
            t[i] = source[i];
        }
        t[index] = '_';
        t[index + 1] = (char)(source[index] + 32);
        for (int i = index + 1; i < source.length; i++) {
            t[i + 1] = source[i];
        }
        return t;
    }
}