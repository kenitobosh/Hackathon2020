package Scheduling;

import HTMLUnitDriver.ClassInfo;
import HTMLUnitDriver.HTMLUnitDriverMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test
{
    private static List<ClassInfo> info;
    private static List<ClassInfo> res;

    public Test()
    {
        res = new ArrayList<>();
        info = new ArrayList<>();
    }

    public static List<ClassInfo> getUserClasses()
    {
        // Get Classes The User Needs To Take
        return info;
    }

    public static void match(HashMap<String, List<ClassInfo>> classes, List<ClassInfo> desire)
    {
        //Sorting Algo
        for(int i = 0; i < desire.size(); i++)
        {
            ClassInfo course = desire.get(i);
            ClassInfo trial = HTMLUnitDriverMain.list.get(course.getType()).get(i);
            ArrayList<ClassInfo> schedule = new ArrayList<>();
            if(isPossible(schedule, course))
            {
                addSort(res, course);
            }
        }

    }

    public static boolean isPossible(ArrayList<ClassInfo> schedule, ClassInfo wantClass)
    {
        for(ClassInfo course : res)
        {
            if(course.getStartTime() < wantClass.getStartTime() || course.getEndTime() > wantClass.getEndTime())
            {
                return false;
            }
        }
        return true;
    }

    public static void addSort(List<ClassInfo> list, ClassInfo classes)
    {
        for(ClassInfo scan : list)
        {
            if(classes.getStartTime() > scan.getStartTime())
            {
                continue;
            }
            list.add(classes);
        }
    }

    public ArrayList<ClassInfo> findSections(ArrayList<ClassInfo> schedule) {
        // Base case: If we have all of our sections, check if they work.
        // Assumption: schedule has only sections that do not conflict.
        if (schedule.size() == info.size()) {
            return schedule;
        }

        // Recursive case: Add a new section that works and check future courses.
        int courseIdx = schedule.size();
        List<ClassInfo> sections = (List<ClassInfo>) info.get(courseIdx);
        for (ClassInfo section : sections) {
            if (isPossible(schedule, section)) {
                schedule.add(section);
                ArrayList<ClassInfo> potentialFullSchedule = findSections(schedule);
                // If blank: failed.
                // If not blank: succeeded!
                if (!potentialFullSchedule.isEmpty()) {
                    return potentialFullSchedule;
                }
                schedule.remove(section);
            }
        }
        return new ArrayList<>();
    }
}

