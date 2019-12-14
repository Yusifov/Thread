package deneme;

import javax.swing.JLabel;

public class subThread extends Thread{
    data d1;
    data d = new data();
    boolean stop = false;
    
    subThread(data d1) {
        this.d1 = d1;
    }

    @Override
    public void run(){
        
         randomNumber number = new randomNumber();
         number.timeSize(500, 50);
         number.start();
         JLabel label = new JLabel();
         returnSubThread a = new returnSubThread(d);
         boolean flag = false;
         
         while(true) {  
            label.setText(String.valueOf(number.tmp));
            if(!label.getText().equals(String.valueOf(number.tmp))) {
                if(d1.deger>=0&&(d1.deger-number.tmp)>=0) {
                    d.kapasite = d.kapasite + number.tmp;
                    d1.deger = d1.deger - number.tmp;
                }
            }
            if(d.kapasite > 0 && flag == false) {
                a.start();
                flag = true;
            }
            if(stop == true) break;   
        }
    }
}