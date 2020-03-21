package app;

public class App {
    public static void main(String[] args) throws Exception {
        String a = "Hello Java";
        System.out.println(reverseString(a));
    }

    public static String reverseString(String text){

        String reverseText = "";

        for(int i = text.length() - 1; i > -1; i--){
            reverseText += text.charAt(i);
        }

        return reverseText;
    }
}