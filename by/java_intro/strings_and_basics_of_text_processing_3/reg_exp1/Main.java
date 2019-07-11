package by.java_intro.strings_and_basics_of_text_processing_3.reg_exp1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  1.  Cоздать  приложение,  разбирающее  текст  (текст хранится  в  строке)  
 * и  позволяющее  выполнять  с  текстом  три  различных  операции:  
 * отсортировать  абзацы  по  количеству  предложений;  
 * в  каждом  предложении  отсортировать  слова  по  длине;  
 * отсортировать лексемы  в предложении  по убыванию количества  вхождений заданного символа,  а в случае  равенства – по  алфавиту. 
 */
public class Main {

    public static void main(String[] args) {
        String s = "Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.    \nЗамените в строке все вхождения 'word' на 'letter'.    \nВ строке найти количество цифр. Еще одно предложение.    \nВ строке найти количество чисел.    \nУдалить  в  строке все  лишние  пробелы.  То  есть серии  подряд  идущих  пробелов  заменить на  одиночные пробелы.  Крайние пробелы в строке удалить.  ";
        System.out.println("Текст: <\n" + s + "\n>");

        String s1 = sortParagraphBySentencesCount(s);
        System.out.println("Отсортированные абзацы по количеству предложений : <\n" + s1 + ">");

        String s2 = sortWordsOrderByLength(s);
        System.out.println("В каждом предложении отсортированы слова по длине: <\n" + s2 + "\n>");

        String s3 = sortWordsOrderBySymbol(s, 'а');
        System.out.println("Отсортированные лексемы в предложении по убыванию количества вхождений символа \"а\", а в случае равенства - по алфавиту: <\n" + s3 + "\n>");
    }

    private static String sortWordsOrderByLength(String s) {
        Pattern p = Pattern.compile("[a-zA-Zа-яА-Я\\s\\d_']+[!?.]");
        Matcher m = p.matcher(s);
        StringBuilder sb = new StringBuilder();
        while(m.find()) {
            sb.append(sortByWorldsLength(m.group()));
            sb.append(m.group().substring(m.group().length() - 1));
        }

        return sb.toString();
    }

    private static String sortByWorldsLength(String s) {
        Pattern p = Pattern.compile("[a-zA-Z_0-9а-яА-Я']+");
        Matcher m = p.matcher(s);
        int i = 0;
        Map<Integer, Integer> indexAndLength = new HashMap<>();
        Map<Integer, String> indexAndStat = new HashMap<>();
        while(m.find()) {
            int c = m.group().length();
            indexAndLength.put(i, c);
            indexAndStat.put(i, m.group());
            i++;
        }

        return getSortedStatement(indexAndLength, indexAndStat);
    }

    private static String getSortedStatement(Map<Integer, Integer> indexAndLength, Map<Integer, String> indexAndStat) {
        List<Integer> sentCount = new ArrayList<>(indexAndLength.values());
        Collections.sort(sentCount, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(Integer c : sentCount) {
            Integer index = 0;
            for (Map.Entry<Integer, Integer> entry : indexAndLength.entrySet()) {
                if (entry.getValue().equals(c)) {
                    index = entry.getKey();
                    break;
                }
            }
            sb.append(" ");
            sb.append(indexAndStat.get(index));
            indexAndLength.remove(index);
            indexAndStat.remove(index);
        }
        return sb.toString();
    }

    private static void appendListToStringBuilder(StringBuilder sb, List<String> sameCountWords) {
        for (String s: sameCountWords) {
            sb.append(" ");
            sb.append(s);
        }
    }

    private static String getSortedBySymbolAndAlphabetStatement(Map<Integer, Integer> indexAndCount, Map<Integer, String> indexAndWord) {
        List<Integer> sentCount = new ArrayList<>(indexAndCount.values());
        Collections.sort(sentCount, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        List<String> sameCountWords = new ArrayList<>();
        Integer oldCount = -1;
        for(Integer c : sentCount) {
            Integer index = 0;
            for (Map.Entry<Integer, Integer> entry : indexAndCount.entrySet()) {
                if (entry.getValue().equals(c)) {
                    index = entry.getKey();
                    break;
                }
            }

            if (oldCount != -1) {
                if (oldCount != c) {
                    Collections.sort(sameCountWords, Collections.reverseOrder());
                    appendListToStringBuilder(sb, sameCountWords);
                    sameCountWords.clear();
                }
            }
            oldCount = c;

            sameCountWords.add(indexAndWord.get(index));
            indexAndCount.remove(index);
            indexAndWord.remove(index);
        }

        Collections.sort(sameCountWords, Collections.reverseOrder());
        appendListToStringBuilder(sb, sameCountWords);

        return sb.toString();
    }

    private static String sortWordsOrderBySymbol(String s, char c) {
        Pattern p = Pattern.compile("[a-zA-Zа-яА-Я\\s\\d_']+[!?.]");
        Matcher m = p.matcher(s);
        StringBuilder sb = new StringBuilder();
        while(m.find()) {
            sb.append(sortBySymbol(m.group(), Character.toString(c)));
            sb.append(m.group().substring(m.group().length() - 1));
        }

        return sb.toString();
    }

    private static String sortBySymbol(String s, String symbol) {
        Pattern pWord = Pattern.compile("[a-zA-Z_0-9а-яА-Я']+");
        Matcher mWord = pWord.matcher(s);
        int i = 0;
        Map<Integer, Integer> indexAndCount = new HashMap<>();
        Map<Integer, String> indexAndWord = new HashMap<>();
        while(mWord.find()) {
            //int c = m.group().length();
            Pattern pSymb = Pattern.compile(symbol);
            Matcher mSymb = pSymb.matcher(mWord.group());
            int c = 0;
            while(mSymb.find()) {
                c++;
            }
            indexAndCount.put(i, c);
            indexAndWord.put(i, mWord.group());
            i++;
        }

        return getSortedBySymbolAndAlphabetStatement(indexAndCount, indexAndWord);
    }

    private static String sortParagraphBySentencesCount(String s) {
        Pattern p = Pattern.compile("(?m)^.*$");
        Matcher m = p.matcher(s);
        int i = 0;
        Map<Integer, Integer> indexAndSentCount = new HashMap<>();
        Map<Integer, String> indexAndSent = new HashMap<>();
        while(m.find()) {
            int c = getSentencesCount(m.group());
            indexAndSentCount.put(i, c);
            indexAndSent.put(i, m.group());
            i++;
        }

        return getSortedParagraph(indexAndSentCount, indexAndSent);
    }

    private static String getSortedParagraph(Map<Integer, Integer> indexAndSentCount, Map<Integer, String> indexAndSent) {
        List<Integer> sentCount = new ArrayList<>(indexAndSentCount.values());
        Collections.sort(sentCount, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(Integer c : sentCount) {
            Integer index = 0;
            for (Map.Entry<Integer, Integer> entry : indexAndSentCount.entrySet()) {
                if (entry.getValue().equals(c)) {
                    index = entry.getKey();
                    break;
                }
            }
            sb.append(indexAndSent.get(index));
            sb.append(" | count: " + indexAndSentCount.get(index) + "\n");
            indexAndSentCount.remove(index);
            indexAndSent.remove(index);
        }
        return sb.toString();
    }

    private static int getSentencesCount(String s) {
        Pattern p = Pattern.compile("\\s+[^.!?]+[.!?]");//("[^!?.].+[!?.]");
        Matcher m = p.matcher(s);
        int l = 0;
        while(m.find()) {
            l++;
        }
        return l;
    }
}