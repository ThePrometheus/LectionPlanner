

package org.optaplanner.examples.curriculumcourse.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.curriculumcourse.domain.solver.LectureDifficultyWeightFactory;
import org.optaplanner.examples.curriculumcourse.domain.solver.MovableLectureSelectionFilter;
import org.optaplanner.examples.curriculumcourse.domain.solver.PeriodStrengthWeightFactory;
import org.optaplanner.examples.curriculumcourse.domain.solver.RoomStrengthWeightFactory;

@PlanningEntity(movableEntitySelectionFilter = MovableLectureSelectionFilter.class,
        difficultyWeightFactoryClass = LectureDifficultyWeightFactory.class)
@XStreamAlias("Lecture")
public class Lecture extends AbstractPersistable {

    private Course course;
    private int lectureIndexInCourse;
    private boolean locked;

    // Planning variables: changes during planning, between score calculations.
    private Period period;
    private Room room;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getLectureIndexInCourse() {
        return lectureIndexInCourse;
    }

    public void setLectureIndexInCourse(int lectureIndexInCourse) {
        this.lectureIndexInCourse = lectureIndexInCourse;
    }

    /**
     * @return true if immovable planning entity
     * @see MovableLectureSelectionFilter
     */
    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @PlanningVariable(valueRangeProviderRefs = {"periodRange"},
            strengthWeightFactoryClass = PeriodStrengthWeightFactory.class)
    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @PlanningVariable(valueRangeProviderRefs = {"roomRange"},
            strengthWeightFactoryClass = RoomStrengthWeightFactory.class)
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

    public Teacher getTeacher() {
        return course.getTeacher();
    }

    public int getStudentSize() {
        return course.getStudentSize();
    }

    public List<Curriculum> getCurriculumList() {
        return course.getCurriculumList();
    }

    public Day getDay() {
        if (period == null) {
            return null;
        }
        return period.getDay();
    }

    public int getTimeslotIndex() {
        if (period == null) {
            return Integer.MIN_VALUE;
        }
        return period.getTimeslot().getTimeslotIndex();
    }

    public String getLabel() {
        return course.getCode() + "-" + lectureIndexInCourse;
    }

    @Override
    public String toString() {
        return course + "-" + lectureIndexInCourse;
    }

}
