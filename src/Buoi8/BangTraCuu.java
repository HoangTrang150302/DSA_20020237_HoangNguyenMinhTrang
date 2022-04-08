package Buoi8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BangTraCuu
{
    private static List<Word> wordList = new ArrayList<>();

    public static void addToList(Word word)
    {
        boolean checkAdd = true;
        if (!wordList.isEmpty())
        {
            for (int i = 0; i < wordList.size(); i++)
            {
                if (word.equalsTo(wordList.get(i)))
                {
                    wordList.get(i).addCount();
                    checkAdd = false;
                }
            }
        }
        if (checkAdd || wordList.isEmpty())
        {
            wordList.add(word);
            word.addCount();
        }
    }

    public static void main(String []args)
    {
        Word word1 = new Word("Trang");
        Word word2 = new Word("Tit");
        Word word3 = new Word("Trang");
        addToList(word1);
        addToList(word2);
        addToList(word3);

        Collections.sort(wordList);

        for (int i = 0; i < wordList.size(); i++)
        {
            System.out.println(wordList.get(i).toString());
        }
    }

}
