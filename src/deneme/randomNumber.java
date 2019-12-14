package deneme;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class randomNumber extends Thread{
    Random number = new Random();
    int time = 0;
    int tmp = 0;
    int interval = 0;
   public void timeSize(int time,int interval) {
        this.time = time;
        this.interval = interval;
    }
    @Override
    public void run() {
            while(true) {
                try {
                    Thread.sleep(time);
                }catch (InterruptedException ex) {
                    Logger.getLogger(randomNumber.class.getName()).log(Level.SEVERE, null, ex);
                }
                tmp = number.nextInt(interval);
                if(tmp == 0)
                    tmp++;
            
            
            }
    }
}
