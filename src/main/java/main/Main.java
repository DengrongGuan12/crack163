package main;

import java.util.ArrayList;

/**
 * Created by I322233 on 1/4/2016.
 */
public class Main {
    public static ArrayList<String> passwords = new ArrayList<String>();
    public static String url = "https://reg.163.com/logins.jsp";
    public static char chars[] = new char[62];
    static {
        int j = 0;
        for (char i='0';i<='9';i++){
            chars[j] = i;
            j++;
        }
        for(char i='a';i<='z';i++){
            chars[j] = i;
            j++;
        }
        for(char i = 'A';i<='Z';i++){
            chars[j] = i;
            j++;
        }
    }
    public static char getChar(int i){
        return chars[i];
    }
    public static char getRanChar(){
        int position = (int)(Math.random()*62);
        return chars[position];
    }
    public static void main(String[] args){
//        System.out.println("sdfsdfgdfg");
//        HttpRequest.sendGet("http://localhost/",null);
        if(HttpRequest.login("https://reg.163.com/logins.jsp","syscheckcode=7d729bf70be09a8728cc8ee8bf7052a7c61faff7&username=15950570277@163.com&password=gdr@193&product=other")){
            System.out.println("success");
        }else{
            System.out.println("failure");
        }
//        for(int i =0;i<62;i++){
//            System.out.print(getChar(i));
//        }
//        for(int i =6;i<17;i++){
//            Run run = new Run(i);
//            Thread thread = new Thread(run);
//            thread.start();
//        }

    }
}
