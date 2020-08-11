package Scheduling;

import java.util.ArrayList;
import java.util.List;

public class Test
{
    public static void main(String[] args)
    {
        String[] computer = {"M", "W", "F"};
        Course computerScience = new Course(1100, 1150, "Bob","Grainger", computer, false);

        String[] art = {"M", "W", "F"};
        Course artHistory = new Course(1200, 1250, "Bob","Grainger", art, false);

        Course[] courses = {artHistory, computerScience};

    }

    public static List<Course> res = new ArrayList<>();
    public static List<Integer> times = new ArrayList<>();

    public static List<Course> plan(Course[] load)
    {
        for (Course current : load)
        {
            if(isAvailable(current))
            {
                res.add(current);
                sort(res);
            }
        }
        return res;
    }

    public static boolean isAvailable(Course current)
    {
        if (!times.contains(current.start) && !times.contains(current.end)) {
            return false;
        }
        return true;
    }

    private static List<Course> sort(List<Course> inital)
    {


        return inital;
    }
}

