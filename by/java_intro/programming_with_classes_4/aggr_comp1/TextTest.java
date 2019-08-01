package by.java_intro.programming_with_classes_4.aggr_comp1;

import java.util.ArrayList;
import java.util.List;

/**
 *  1. Создать объект класса Текст, используя классы Предложение, Слово. 
 * Методы: дополнить текст, вывести на консоль текст, заголовок текста.
 */

public class TextTest {
    public static void main(String[] args) {
        
        Text text = initText();
        text.printTitle();
        System.out.println("Source text: ");
        text.printText();

        text.addText(new Sentence(new ArrayList<Word>() {{
                                    add(new Word("Мама"));
                                    add(new Word("мыла"));
                                    add(new Word("раму"));
                                    }}
                    )
        );

        System.out.println("Changed text: ");
        text.printText();
    }

    public static Text initText() {
        Text text = new Text("Заголовок", new ArrayList<Sentence>() {{
                                            add(new Sentence(new ArrayList<Word>() {{
                                                                    add(new Word("Папа"));
                                                                    add(new Word("рыл"));
                                                                    add(new Word("канаву"));
                                                                    }}
                                                                ));
                                            add(new Sentence(new ArrayList<Word>() {{
                                                                    add(new Word("Пес"));
                                                                    add(new Word("терзал"));
                                                                    add(new Word("панаму"));
                                                                    }}
                                                                ));
                                        }}
        );
        return text;
    }

}

class Text {
    private String title;
    private List<Sentence> text;
    
    public Text(String title, List<Sentence> text) {
        this.title = title;
        this.text = text;
    }

    private String getFormattedText() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.size(); i++) {
            if (i < text.size() - 1 && text.size() > 1) {
                result.append(text.get(i).toString() + " ");
            } else {
                result.append(text.get(i).toString());
            }
        }
        return result.toString();
    }

    public void addText(Sentence sentence) {
        text.add(sentence);
    }

    public void printText() {
        System.out.println(getFormattedText());
    }

    public void printTitle() {
        System.out.println("Title: " + title);
    }
    
}

class Sentence {
    private List<Word> sentence;

    public Sentence(List<Word> sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sentence.size(); i++) {
            if (i < sentence.size() - 1) {
                result.append(sentence.get(i).toString() + " ");
            } else {
                result.append(sentence.get(i).toString() + ".");
            }
        }
        return result.toString();
    }

}

class Word {
    private String value;

    public Word(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}