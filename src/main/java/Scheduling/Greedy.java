package Scheduling;

import java.util.List;
/*8
public class Greedy 
{
    private List<Course> courses;
    private boolean possible;

    public void Schedule() {
        possible = true;
    }

    public void generate() {
        for(Course course : courses) {
            if(!setLecture(course)) {
                possible = false;
                return;
            }
        }
        possible = true;
    }

    private boolean setLecture(Course course) {
        if (course.getLectures().size() > 0) {
            for (DetailedSection lecture : course.getLectures()) {
                if (canBeAdded(lecture)) {
                    course.setSelectedLecture(lecture);
                    if(setDiscussion(course)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return setDiscussion(course);
    }

    private boolean setDiscussion(Course course) {
        if (course.getDiscussions().size() > 0) {
            for (DetailedSection discussion : course.getDiscussions()) {
                if (canBeAdded(discussion)) {
                    course.setSelectedDiscussion(discussion);
                    if(setLab(course)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return setLab(course);
    }

    private boolean setLab(Course course) {
        if (course.getLabs().size() > 0) {
            for (DetailedSection lab : course.getLabs()) {
                if (canBeAdded(lab)) {
                    course.setSelectedLab(lab);
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private boolean canBeAdded(DetailedSection newSection) {
        for (Course course : courses) {
            // Lecture
            if (course.getSelectedLecture() != null) {
                if (newSection.conflictsWith(course.getSelectedLecture())) {
                    return false;
                }
            }

            // Discussion
            if (course.getSelectedDiscussion() != null) {
                if (newSection.conflictsWith(course.getSelectedDiscussion())) {
                    return false;
                }
            }

            // Lab
            if (course.getSelectedLab() != null) {
                if (newSection.conflictsWith(course.getSelectedLab())) {
                    return false;
                }
            }
        }

        return true;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public boolean isPossible() {
        return possible;
    }


}
*/