public class word {
    public String word;
    public int counter;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "word='" + word + '\'' +
                ", counter=" + counter;
    }

    public word(String word, int counter) {
        this.word = word;
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
