package deneme;

import javax.swing.JLabel;

public class returnSubThread extends Thread{
    
    data d;
    public returnSubThread(data d) {
        this.d = d;
    }
    
    @Override
    public void run() {
        JLabel label1 = new JLabel();
        randomNumber number1 = new randomNumber();
        number1.timeSize(300, 50);
        number1.start();
        
        while(true) {
            if(d.kapasite > 0) {
                label1.setText(String.valueOf(number1.tmp));
                if (!label1.getText().equals(String.valueOf(number1.tmp))) {
                    if ((d.kapasite - number1.tmp) >= 0) {
                        d.kapasite = d.kapasite - number1.tmp;
                    }
                }
            }
        }
    }
}
