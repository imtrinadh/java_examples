import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Interval{
    int start;
    int end;
    Interval(int start,int end){
        this.start=start;
        this.end=end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
public class MergeIntervals {
    public static void  main(String[] args){

        List<Interval>intervals=new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        List<Interval> merged=merge(intervals);
        System.out.println("Merged Intervals :"+merged);
    }
    public static List<Interval> merge(List<Interval> intervals){
        if (intervals==null ||intervals.size()<=1){
            return intervals;

        }
        intervals.sort(Comparator.comparingInt(i->i.start));
        List<Interval> mergedInterval=new ArrayList<>();
        Interval currentInterval=intervals.get(0);

        for (int i=1;i< intervals.size();i++){
            Interval interval=intervals.get(i);
            if (currentInterval.end>=interval.start){

                currentInterval.end=Math.max(currentInterval.end, interval.end);
            }
            else {
                mergedInterval.add(currentInterval);
                currentInterval=interval;
            }
        }
        mergedInterval.add(currentInterval);
        return mergedInterval;
    }
}
