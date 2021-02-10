package studlab.kaminski;

import java.util.*;

public class String implements Cloneable{
    protected char[] string;
    protected int length;

    public String(){
        clear();
    }

    public String(char[] string) {
        setString(string);
        setLength(string.length);
    }

    public String(String other){
        if (other == null){
            throw new NullPointerException("String object points to null.");
        }

        setLength(other.getLength());
        setString(other.getString());
    }

    public char[] getString() {
        return string.clone();
    }

    protected void setString(char[] string) {
        if (string == null){
            throw new NullPointerException("String is null.");
        }

        this.string = string.clone();
    }

    public int getLength() {
        return length;
    }

    protected void setLength(int length) {
        if (length < 0){
            throw new IllegalArgumentException("Length of string must be more or equals zero.");
        }

        this.length = length;
    }

    public static boolean isEmpty(String string){
        if (string == null){
            throw new NullPointerException("String points to null.");
        }
        return string.getLength() == 0;
    }

    public static String concat(final String lhs, final String rhs){
        if (lhs == null || lhs.getString() == null){
            throw new NullPointerException("Left-hand-side parameter or string points to null.");
        }

        if (rhs == null || rhs.getString() == null){
            throw new NullPointerException("Right-hand-side parameter or string points to null.");
        }

        if (isEmpty(lhs)){
            try {
                return rhs.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        if (isEmpty(rhs)){
            try {
                return lhs.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        char[] sum = new char[lhs.getLength() + rhs.getLength()];

        System.arraycopy(lhs.getString(), 0, sum, 0, lhs.getLength());
        System.arraycopy(rhs.getString(), 0, sum, lhs.getLength(), rhs.getLength());

        return new String(sum);
    }

    public void clear(){
        setString("".toCharArray());
        setLength(0);
    }

    public void display(){
        if (getLength() == 0){
            System.out.println("Empty string");
        }
        else{
            System.out.println(string);
        }
    }

    public String clone() throws CloneNotSupportedException {
        return (String)super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        String string1 = (String) o;
        return length == string1.length &&
                Arrays.equals(string, string1.string);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(length);
        result = 31 * result + Arrays.hashCode(string);
        return result;
    }
}
