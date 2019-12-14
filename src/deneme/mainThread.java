 package deneme;
 
import javax.swing.JLabel;

public class mainThread extends Thread{
    data d;
    randomNumber tmp = new randomNumber();
    String a = null;
    mainThread(data d) {
       this.d = d;
    }
    @Override
    public void run() {
        tmp.timeSize(500,100);
        tmp.start();
        int wsa = 0;
        JLabel label = new JLabel();
        while(true) {
            label.setText(String.valueOf(tmp.tmp));
            if(!label.getText().equals(String.valueOf(tmp.tmp))) {
                d.deger = d.deger + tmp.tmp;
            }
            if(d.deger > 10000) break;
        }
    }
}
