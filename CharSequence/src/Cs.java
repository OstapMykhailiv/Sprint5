import java.lang.CharSequence;

public class Cs implements CharSequence {
    private final String sentence = "The Java Tutorials";
    //Finds the length
@Override
    public int length() {
        int theLength = 0;
        for (int i = 0; i < sentence.length(); i++) {
            theLength++;
        }
        return theLength;
    }
    //Counts from the end
    private int fromEnd(int i) {
        return sentence.length() - 1 - i;
    }
    //Returns a char on the i-position
public char charAt(int i){
   if ((i<0)||(i>sentence.length())){
       throw new StringIndexOutOfBoundsException(i);
   }
   return sentence.charAt(sentence.length()-1-i);
}
    //Returns the sentence backwards
    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0) {
            throw new StringIndexOutOfBoundsException(start);
        }
        if (end > sentence.length()) {
            throw new StringIndexOutOfBoundsException(end);
        }
        if (start > end) {
            throw new StringIndexOutOfBoundsException(start - end);
        }
        StringBuilder sub = new StringBuilder(sentence.subSequence(fromEnd(end), fromEnd(start)));
        return sub.reverse();
    }
    public String toString() {
        StringBuilder sentence = new StringBuilder(this.sentence);
        return sentence.reverse().toString();
    }
    public static void main(String[] args) {
    Cs myobj=new Cs();
    System.out.println(myobj.subSequence(0, 17));
    System.out.println(myobj.toString());
    for (int i=0; i<myobj.length(); i++)
    {
        System.out.print(myobj.charAt(i));
    }
        System.out.println("");

}
}