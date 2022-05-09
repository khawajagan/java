
import java.util.List;
import java.util.Scanner;

public class Main
{
    
    public static void main(String[] args)
    {
        int a=99;
        while (a!=0)
        {
            dl();
            System.out.println("My CPU Scheduling Simulator");
            sl();
            System.out.println("1-FCFS");
            System.out.println("2-SJF");
            System.out.println("3-SRT");
            System.out.println("4-PSN");
            System.out.println("5-PSP");
            System.out.println("6-RR");
            System.out.println("9-Sample Data Comparison");
            System.out.println("0-EXIT");
            dl();
            a = getElement("Select Algorithm To Implement : ");
            switch (a) {
                case 1:
                    fcfs(a);
                    break;
                case 2:
                    sjf(a);
                    break;
                case 3:
                    srt(a);
                    break;
                case 4:
                    psn(a);
                    break;
                case 5:
                    psp(a);
                    break;
                case 6:
                    rr(a);
                    break;
                case 9:
                    System.out.println("<><><><><><><><><> FCFS <><><><><><><><><>");
                    fcfs(a);
                    System.out.println("<><><><><><><><><>  SJF <><><><><><><><><>");
                    sjf(a);
                    System.out.println("<><><><><><><><><>  SRT <><><><><><><><><>");
                    srt(a);
                    System.out.println("<><><><><><><><><>  PS <><><><><><><><><>");
                    psn(a);
                    System.out.println("<><><><><><><><><>  PSP <><><><><><><><><>");
                    psp(a);
                    System.out.println("<><><><><><><><><>  RR <><><><><><><><><>");
                    rr(a);
                    break;
                default:
                    return;
            }
            
        }
    }
    

    public static int getElement(String msg)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        int n = sc.nextInt();
        return n;
    }


    public static void getRowFromUser(CPUScheduler x, int y)
    {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i <y; i++)
        {
            System.out.println("enter process " + (i+1) + " arrival time: ");
            int at = sc.nextInt();
            System.out.println("enter process " + (i+1) + " brust time: ");
            int bt = sc.nextInt();
            x.add(new Row("P"+(i+1), at, bt));
        }
    }

    public static void fcfs(int a)
    {
        CPUScheduler fcfs = new FirstComeFirstServe();
        if (a!=9)
        {
            int x = getElement("Enter No. Of Processes : ");
            getRowFromUser(fcfs, x);
        }
        else
        {        
            fcfs.add(new Row("P1", 0, 5));
            fcfs.add(new Row("P2", 2, 4));
            fcfs.add(new Row("P3", 4, 3));
            fcfs.add(new Row("P4", 6, 6));
            fcfs.add(new Row("P5", 8, 1));
        }
        fcfs.process();
        display(fcfs);
    }
    
    public static void sjf(int a)
    {
        CPUScheduler sjf = new ShortestJobFirst();
        if (a!=9)
        {
            int x = getElement("Enter No. Of Processes : ");
            getRowFromUser(sjf, x);
        }
        else
        {   
            sjf.add(new Row("P1", 0, 5));
            sjf.add(new Row("P2", 2, 4));
            sjf.add(new Row("P3", 4, 3));
            sjf.add(new Row("P4", 6, 6));
            sjf.add(new Row("P5", 8, 1));
        }
        sjf.process();
        display(sjf);
    }
    
    public static void srt(int a)
    {
        CPUScheduler srt = new ShortestRemainingTime();
        if (a!=9)
        {
            int x = getElement("Enter No. Of Processes : ");
            getRowFromUser(srt, x);
        }
        else
        {   
            srt.add(new Row("P1", 0, 5));
            srt.add(new Row("P2", 2, 4));
            srt.add(new Row("P3", 4, 3));
            srt.add(new Row("P4", 6, 6));
            srt.add(new Row("P5", 8, 1));
        }
        srt.process();
        display(srt);
    }
    
    public static void psn(int a)
    {
        CPUScheduler psn = new PriorityNonPreemptive();
        if (a!=9)
        {
            int x = getElement("Enter No. Of Processes : ");
            getRowFromUser(psn, x);
        }
        else
        {   
            psn.add(new Row("P1", 0, 5));
            psn.add(new Row("P2", 2, 4));
            psn.add(new Row("P3", 4, 3));
            psn.add(new Row("P4", 6, 6));
            psn.add(new Row("P5", 8, 1));
        }
        psn.process();
        display(psn);
    }
    
    public static void psp(int a)
    {
        CPUScheduler psp = new PriorityPreemptive();
        if (a!=9)
        {
            int x = getElement("Enter No. Of Processes : ");
            getRowFromUser(psp, x);
        }
        else
        {   
            psp.add(new Row("P1", 0, 5));
            psp.add(new Row("P2", 2, 4));
            psp.add(new Row("P3", 4, 3));
            psp.add(new Row("P4", 6, 6));
            psp.add(new Row("P5", 8, 1));

        }
        psp.process();
        display(psp);
    }
    
    public static void rr(int a)
    {
        CPUScheduler rr = new RoundRobin();
        if (a!=9)
        {
            int x = getElement("Enter No. Of Processes : ");
            getRowFromUser(rr, x);
            rr.setTimeQuantum(getElement("Enter Time Quantum Value : "));
        }
        else
        {   
            rr.setTimeQuantum(2);
            rr.add(new Row("P1", 0, 5));
            rr.add(new Row("P2", 2, 4));
            rr.add(new Row("P3", 4, 3));
            rr.add(new Row("P4", 6, 6));
            rr.add(new Row("P5", 8, 1));
        }
        rr.process();
        display(rr);
    }
    public static void sl()
    {
        System.out.println(repeatChar('-', 40));
    }
    public static void dl()
    {
        System.out.println(repeatChar('=', 40));
    }

    public static void myGanttChart1(CPUScheduler a)
    {
        String l1=""; 
        String l2="";
        System.out.println();
        int tl=0;
        for (int i = 0; i < a.getTimeline().size(); i++)
        {
            List<Event> timeline = a.getTimeline();
            int xx = timeline.get(i).getStartTime();
            int yy = timeline.get(i).getFinishTime();
            int zz = yy - xx;
            //System.out.println(zz);
            tl = xx - tl;
            String myspace = repeatChar(' ', xx);
            String mytl = repeatChar('█', zz);
            String mypn = timeline.get(i).getProcessName();
            // System.out.println(myspace+ "\t" + mytl + "{}");
            //System.out.print(  myspace   + mytl + "(" + mypn + "-" + xx + "<>" + zz + ")");
            l1=l1+"|"+mypn+" ST : "+xx+"\t";
            if ( tl > 19 )
            { l1 = l1+"\t\t"; }
            else if ( tl > 9)
            { l1 = l1+"\t"; }
            l2=l2+"|"+mytl + " RT : "+zz+"\t";
            tl =  xx;
            if (i == a.getTimeline().size() - 1)
            {
                dl();
                System.out.print("Gantt Chart Start Time: 0 End Time: "+timeline.get(i).getFinishTime()+"\n");
                sl();
            }
        }
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(("* ST = Start Time  RT = Running Time"));
        dl();
        System.out.println();
    }

    public static void myGanttChart2(CPUScheduler a)
    {
        String l1=""; 
        List<Event> timeline = a.getTimeline();
        
        for (Event event : timeline)
        {
            //System.out.println(event.getStartTime());
            //System.out.println("|  " + event.getProcessName());
            l1=l1+event.getStartTime()+"\n|  "+event.getProcessName()+" \n";
        }
        int myFinTime = timeline.get(timeline.size() - 1).getFinishTime();
        l1=l1+myFinTime+" \n";
        dl();
        System.out.print("Gantt Chart Start Time: 0 End Time: "+myFinTime+"\n");
        sl();    
        System.out.println(l1);
        dl();
        System.out.println();
    }

    public static void display(CPUScheduler object)
    {

        dl();
        System.out.println("Process\tAT\tBT\tWT\tTAT");
        sl();
        for (Row row : object.getRows())
        {
            System.out.println(row.getProcessName() + "\t" + row.getArrivalTime() + "\t" + row.getBurstTime() + "\t" + row.getWaitingTime() + "\t" + row.getTurnaroundTime());
        }
        dl();
        System.out.println("Average WT: " + object.getAverageWaitingTime() + "\nAverage TAT: " + object.getAverageTurnAroundTime());
        dl();
        myGanttChart1(object);
        myGanttChart2(object);
    }

    public static String repeatChar(char repeatChar, int repeatTimes) 
    {
        String result = "";
        for(int j = 0; j < repeatTimes; j++) {
            result = result + repeatChar;
        }
        return result;
    }
}
