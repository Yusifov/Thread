package deneme;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class show extends Thread{
    
    ArrayList<subThread> list;
    data d;
    mainThread mainThread;
    subThread a;
    subThread b;
    JProgressBar bar[];
    JLabel label[];
    int kapasite[] = new int[10];
    
    show(mainThread mainThread, subThread a, subThread b, ArrayList<subThread> list, data d, JProgressBar bar[], JLabel label[]) {
       this.mainThread = mainThread;
       this.a = a;
       this.b = b;
       this.list = list;
       this.d = d;
       this.bar = bar;
       this.label = label;
    }
    @Override
    public void run() {
       while(true) {
           for(int i=3;i<10;i++) {
               if(bar[i].getValue() == 0) {
                   bar[i].removeAll();
                   bar[i].setVisible(false);
                   label[i].removeAll();
                   label[i].setVisible(false);
               }
           }
           yuzde();
          for(int i=0;i<10;i++) {
              bar[i].setValue(kapasite[i]);
          }
       }
    }
    
    public void yuzde() {
        kapasite[0] = (int)((d.deger*100)/1000);
        bar[0].setVisible(true);
        label[0].setVisible(true);
        kapasite[1] = (int)((a.d.kapasite*100)/500);
        bar[1].setVisible(true);
        label[1].setVisible(true);
        kapasite[2] = (int)((b.d.kapasite*100)/500);
        bar[2].setVisible(true);
        label[2].setVisible(true);
        int j = 0;
        for(int i=3;i<=(2+list.size());i++) {
            kapasite[i] = (int)((list.get(j).d.kapasite*100)/500);
            if(kapasite[i] == 0) {
                list.get(j).stop = true;
                list.remove(j);
            }
            bar[i].setVisible(true);
            label[i].setVisible(true);
            j++;
        }
    }
}
