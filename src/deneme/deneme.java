package deneme;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class deneme {
        
    public static void main(String[] args) {
        
        ArrayList<subThread> list = new ArrayList<subThread>(); 
        data d = new data();
        mainThread mainThread = new mainThread(d);
        subThread a = new subThread(d);
        subThread b = new subThread(d);
        createThread c = new createThread(a, b, list, d);
        mainThread.start();
        a.start();
        b.start();
        c.start();
        
        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel(new GridLayout(10, 0));
        JPanel panel2 = new JPanel(new GridLayout(10,0));
        JPanel anaPanel = new JPanel(new GridLayout(0, 2));
        JProgressBar bar[] = new JProgressBar[10];
        JLabel label[] = new JLabel[10];
        for(int i=0;i<10;i++) {
            bar[i] = new JProgressBar();
            if(i == 0)
                label[i] = new JLabel("Main Thread");
            else
                 label[i] = new JLabel("Sub -> "+i+" Thread ");
            bar[i].setValue(0);
            bar[i].setStringPainted(true);
            bar[i].setVisible(false);
            label[i].setVisible(false);
            panel2.add(label[i]);
            panel1.add(bar[i]);
        }
        anaPanel.add(panel2);
        anaPanel.add(panel1);
        frame.add(anaPanel);
        frame.setSize(600,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        show q = new show(mainThread, a, b, list, d, bar ,label);
        q.start();
       
       /*JLabel label = new JLabel();
        String value;
        while(true) {
           
            value = String.valueOf(d.deger);
            label.setText(value);
            if(!label.getText().equals(String.valueOf(d.deger))) {
                System.out.println(mainThread.getName()+"->"+d.deger);
                System.out.println(a.getName()+"->"+a.d.kapasite);
                System.out.println(b.getName()+"->"+b.d.kapasite);
                for(int i=0;i<list.size();i++) {
                    System.out.println(list.get(i).getName() + "->" + list.get(i).d.kapasite);
                }
                System.out.println("///////////////");
            }
        }*/
    }
}
