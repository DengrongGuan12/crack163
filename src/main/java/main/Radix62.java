package main;

/**
 * Created by dengrong on 2016/1/4.
 */
public class Radix62 {
    private int num;
    private int[] positions;
    private boolean end = false;
    public boolean isEnd(){
        return end;
    }
    public Radix62(int num){
        this.num = num;
        positions = new int[num];
    }
    public void inc(){
        int i = num-1;
        while(i>=0){
            int value = positions[i];
            if(value+1 == 62){
                positions[i] = 0;
                i--;
            }else{
                positions[i] = value+1;
                break;
            }
        }
        if(i == -1){
            end = true;
        }
    }
    public int[] getPositions(){
        return this.positions;
    }
    public static void main(String[] args){
        Radix62 radix62 = new Radix62(2);
        while(!radix62.isEnd()){
            int[] positions = radix62.getPositions();
            System.out.println(positions[0]+";"+positions[1]);
            radix62.inc();
        }

    }
}
