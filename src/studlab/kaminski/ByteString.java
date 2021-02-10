package studlab.kaminski;

public class ByteString extends String{
    public static final int SIZE = 32;

    public ByteString(){super();}

    public ByteString(char[] string){
        if (isValid(string)){
            setLength(SIZE);
            setString(string);
            this.string = addZeros(this.string);

            if (string[0] == '-'){
                additionalCode(this.string);
            }
        }
        else{
            setLength(0);
            setString("".toCharArray());
        }
    }

    public ByteString(ByteString other) throws NullPointerException{
           this(other.getString());
    }

    private static char[] addZeros(char[] string){
        if (string == null){
            throw new NullPointerException("Symbols array points to null.");
        }

        if (string.length > SIZE){
            throw new IllegalArgumentException("It is not a number in " + SIZE + "-bits system.");
        }

        char[] stringInByteCode = new char[SIZE];

        for (int i = string.length - 1, j = SIZE - 1; j >= 0; j--,i--){
            if (i >= 0 && string[i] != '-'){
                stringInByteCode[j] = string[i];
            }
            else{
                stringInByteCode[j] = '0';
            }
        }

        if (string[0] == '-'){
            stringInByteCode[0] = '-';
        }

        return stringInByteCode;
    }

    public static void inverseCode(char[] string){
        if (string == null){
            throw new NullPointerException("Symbols array points to null.");
        }

        for (int i = 0; i < string.length; i++){
            string[i] = string[i] == '1' ? '0' : '1';
        }

        string[0] = '1';
    }

    public static void additionalCode(char[] string){
        if (string == null){
            throw new NullPointerException("Symbols array points to null.");
        }

        inverseCode(string);

        int i = string.length - 1;
        while (i >= 0 && string[i] == '1'){
            string[i--] = '0';
        }

        if (i >= 0) {
            string[i] = '1';
        }
    }

    private static boolean isValid(char[] string){
        if (string == null){
            throw new NullPointerException("Symbols array points to null.");
        }

        for (int i = 1; i < string.length; i++) {
            if (string[i] != '1' && string[i] != '0'){
                return false;
            }
        }

        return string[0] == '1' || string[0] == '0' || string[0] == '-';
    }
}
