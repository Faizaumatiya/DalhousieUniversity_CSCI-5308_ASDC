import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TimerSubject {
    private static TimerSubject theOneInstance = null;
    private final List<ITimerObserver> observers;
    public static TimerSubject instance()
    {
        if (null == theOneInstance)
        {
            theOneInstance = new TimerSubject();
        }
        return theOneInstance;
    }

    public TimerSubject()
    {
        observers = new ArrayList<ITimerObserver>();
    }
    public void attach(ITimerObserver observer)
    {
        observers.add(observer);
    }
    public void detach(ITimerObserver observer)
    {
        observers.remove(observer);
    }
    public void notifySubjects()
    {
        ListIterator<ITimerObserver> iter = observers.listIterator();
        while (iter.hasNext())
        {
            iter.next().timeElapsed(1);
        }
    }
}
