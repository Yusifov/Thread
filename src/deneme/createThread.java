package deneme;

import java.util.ArrayList;

public class createThread extends Thread{
    ArrayList<subThread> list;
    subThread sub;
    subThread sub1;
    data d;
    int nz = (int)((500*70)/100);
    int end;
    
    createThread(subThread sub, subThread sub1, ArrayList<subThread> list, data d) {
        this.sub = sub;
        this.sub1 = sub1;
        this.list = list;
        this.d = d;
    }
    
    @Override
    public void run() {
        while(true) {
            System.out.print("");
            end = list.size()-1;
            if(sub.d.kapasite >= nz) {
                list.add(new subThread(d));
                end = end +1 ;
                list.get(end).d.kapasite = (int)(sub.d.kapasite/2);
                list.get(end).start();
                sub.d.kapasite = (int)(sub.d.kapasite/2);
            } if(sub1.d.kapasite >= nz) {
                list.add(new subThread(d));
                end = end +1 ;
                list.get(end).d.kapasite = (int)(sub1.d.kapasite/2);
                list.get(end).start();
                sub1.d.kapasite = (int)(sub1.d.kapasite/2);
            }
            for(int i=0;i<list.size();i++) {
                if(list.get(i).d.kapasite >= nz) {
                    list.add(new subThread(d));
                    end = end + 1;
                    list.get(end).d.kapasite = (int)(list.get(i).d.kapasite/2);
                    list.get(i).d.kapasite = (int)(list.get(i).d.kapasite/2);
                    list.get(end).start();
                }
            }
        }
    }
}
