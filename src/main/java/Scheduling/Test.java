package Scheduling;

import HTMLUnitDriver.ClassInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test
{
    private static List<Course> info;
    List<ClassInfo> res;

    public Test()
    {
        res = new ArrayList<>();
        info = new ArrayList<>();
    }

    public static List<Course> getUserClasses()
    {
        // Get Classes The User Needs To Take
        return info;
    }

    public static void match(HashMap<String, List<ClassInfo>> classes, List<Course> desire)
    {
        //Sorting Algo
    }
}

