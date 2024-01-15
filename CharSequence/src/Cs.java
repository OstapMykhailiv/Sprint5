import java.lang.CharSequence;

public class Cs implements CharSequence {
    private final String sentence = "Select one of the sentences from this book to use as the data.";
    //Finds the index of last character
    private int fromEnd(int i) {
        return sentence.length() - 1 - i;
    }

    //Finds the length
    @Override
    public int length() {
        int theLength = 0;
        for (int i = 0; i < sentence.length(); i++) {
            theLength++;
        }
        return theLength;
    }

    //Finds the character at needed index
    @Override
    public char charAt(int i) {
        if ((i < 0) || (i >= sentence.length())){
            throw new StringIndexOutOfBoundsException(i);
        }
        return sentence.charAt(fromEnd(i));
    }
    //Finds the subSequence that is needed to be reversed
    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0){
            throw new StringIndexOutOfBoundsException(start);
        }
        if (end > sentence.length()){
            throw new StringIndexOutOfBoundsException(end);
        }
        if (start > end){
            throw new StringIndexOutOfBoundsException(start);
        }
        StringBuilder sub = new StringBuilder(sentence.subSequence(fromEnd(end), fromEnd(start)));
        return sub.reverse();
    }
    public static void main(String[] args) {
        Cs cs = new Cs();
        System.out.println(cs.subSequence(0, cs.sentence.length()-1));
    }
}
