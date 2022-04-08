package Buoi8;

public class Word implements Comparable<Word>
{
    private String value;
    private int count;

    public Word() {
        count = 0;
    }

    public Word(String value) {
        this.value = value;
        count = 0;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int compareTo(Word other)
    {
        return this.value.compareTo(other.value);
    }

    public void addCount()
    {
        count++;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                ", count=" + count +
                '}';
    }

    public boolean equalsTo(Word other)
    {
        return this.value.equals(other.value);
    }
}
