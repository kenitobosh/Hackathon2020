package HTMLUnitDriver;

import java.util.Arrays;
import java.util.List;

public class ClassInfo
{
    private String type;
    private String section;
    private int[] startAndEndTimes = new int[2];
    private String[] dayOfWeek;
    private String location;
    private String instructor;
    public ClassInfo(List<String> scrappedInfo)
    {
        this.type = scrappedInfo.get(0);
        this.section = scrappedInfo.get(1);
        String[] timeString = scrappedInfo.get(2).split(" - ");
        for(int i = 0; i < startAndEndTimes.length; i++)
        {
            boolean addToPM = false;
            if(timeString[i].contains("PM") && !timeString[i].contains("12"))
                addToPM = true;
            startAndEndTimes[i] = Integer.parseInt(timeString[i].replaceAll("\\D", ""));
            if(addToPM)
                startAndEndTimes[i] += 1200;
        }
        this.dayOfWeek = toWeekDay(scrappedInfo.get(3));
        this.location = scrappedInfo.get(4);
        this.instructor = scrappedInfo.get(5);
    }
    public String getType()
    {
        return type;
    }

    public String getSection()
    {
        return section;
    }

    public int[] getTime()
    {
        return startAndEndTimes;
    }

    public int getStartTime()
    {
        return startAndEndTimes[0];
    }

    public int getEndTime()
    {
        return startAndEndTimes[1];
    }

    public String[] getDayOfWeek()
    {
        return dayOfWeek;
    }

    public String getLoc()
    {
        return location;
    }

    public String getInstructor()
    {
        return instructor;
    }

    public String getInfo()
    {
        return "Class Type: " + type + ", Class Section: " + section + ", Class Times: " +
                startAndEndTimes[0] + "-" + startAndEndTimes[1] + ", Class Days: " +
                Arrays.toString(dayOfWeek) + ", Class Location: " + location + ", Class Instructor: " +
                instructor;
    }

    private String[] toWeekDay(String classDaysCode)
    {
        String[] weekDays = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday", "Sunday"};
        Character[] dayCodes = new Character[] {'M', 'T', 'W', 'R',
                'F', 'S', 'U'};

        String[] ClassDaysOfWeek = new String[classDaysCode.length()];
        for(int i = 0; i < classDaysCode.length(); i++)
        {
            for(int j = 0; j < dayCodes.length; j++)
            {
                if(dayCodes[j].equals(classDaysCode.charAt(i)))
                    ClassDaysOfWeek[i] = weekDays[j];
            }
        }
        return ClassDaysOfWeek;
    }
}



