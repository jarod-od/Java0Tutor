package by.java_intro.strings_and_basics_of_text_processing_3.reg_exp2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  2.  Дана строка, содержащая следующий текст (xml-документ): 
 * <notes>
 *  <note id = "1">
 *      <to>Вася</to>
 *      <from>Света</from>
 *      <heading>Напоминание</heading>
 *      <body>Позвони мне завтра!</body>
 *  </note>
 *  <note id = "2">
 *      <to>Петя</to>
 *      <from>Маша</from>
 *      <heading>Важное напоминание</heading>
 *      <body/>
 *      </note>
 * </notes>
 * Напишите анализатор,  позволяющий последовательно возвращать содержимое узлов xml-документа  
 * и  его  тип  (открывающий  тег,  закрывающий  тег,  содержимое  тега,  тег без тела).  
 * Пользоваться готовыми  парсерами  XML  для  решения данной  задачи  нельзя. 
 */
public class Main {

    public static void main(String[] args) {
        String xml = getStringFromXmlFile(".\\by\\java_intro\\strings_and_basics_of_text_processing_3\\reg_exp2\\Test.xml");
        printNodesContentConsistently(xml);
    }

    private static String getStringFromXmlFile(String filePath) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("ERROR: CANT READ XML");
            System.exit(1);
            return null;
        }
    }

    private static void printNodesContentConsistently(String xml) {
        List<String> content = getNodesContentConsistently(xml);
        for (String s : content) {
            System.out.println(s);
        }
    }

    private static List<String> getNodesContentConsistently(String xml) {
        List<String> content = new ArrayList<>();
        Pattern p = Pattern.compile("(?s)<([^\\s]+)(.*?)>(.+?)</(\\1)>|<(.+?)/>");
        Matcher m = p.matcher(xml);
        while(m.find()) {

            // m.group(3) - body
            if (m.group(3) != null) {
                content.add(getContent(m));
                content.addAll(getNodesContentConsistently(m.group(3)));
            } else {
                content.add(getContentWithoutBody(m));
            }
        }
        return content;
    }

    private static String getContent(Matcher m) {
        StringBuilder sb = new StringBuilder();
        sb.append("<--- \n Узел : \n");
        sb.append("Открывающий  тег: " + m.group(1) + m.group(2) + "\n");
        sb.append("Закрывающий  тег: " + m.group(4) + "\n");
        sb.append("Содержимое тега: " + m.group(3) + "\n");
        sb.append("Тег без тела (да, нет): нет" + "\n");
        sb.append("--->\n");
        return sb.toString();
    }

    private static String getContentWithoutBody(Matcher m) {
        StringBuilder sb = new StringBuilder();
        sb.append("<--- \n Узел : \n");
        sb.append("Открывающий  тег: " + m.group(5) + "\n");
        sb.append("Закрывающий  тег: отсутствует" + "\n");
        sb.append("Содержимое тега: отсутствует" + "\n");
        sb.append("Тег без тела (да, нет): да" + "\n");
        sb.append("--->\n");
        return sb.toString();
    }
}