

package org.optaplanner.examples.curriculumcourse.persistence;

import java.io.IOException;

import org.optaplanner.examples.common.persistence.AbstractTxtSolutionExporter;
import org.optaplanner.examples.curriculumcourse.domain.CourseSchedule;
import org.optaplanner.examples.curriculumcourse.domain.Lecture;

public class CurriculumCourseExporter extends AbstractTxtSolutionExporter<CourseSchedule> {
    private static final String OUTPUT_FILE_SUFFIX = "sol";

    public static void main(String[] args) {
        new CurriculumCourseExporter().convertAll();
    }

    public CurriculumCourseExporter() {
        super(new CurriculumCourseDao());
    }

    @Override
    public String getOutputFileSuffix() {
        return OUTPUT_FILE_SUFFIX;
    }

    @Override
    public TxtOutputBuilder<CourseSchedule> createTxtOutputBuilder() {
        return new CurriculumCourseOutputBuilder();
    }

    public static class CurriculumCourseOutputBuilder extends TxtOutputBuilder<CourseSchedule> {

        @Override
        public void writeSolution() throws IOException {
            for (Lecture lecture : solution.getLectureList()) {
                bufferedWriter.write(lecture.getCourse().getCode()
                        + " r" + lecture.getRoom().getCode()
                        + " " + lecture.getPeriod().getDay().getDayIndex()
                        + " " + lecture.getPeriod().getTimeslot().getTimeslotIndex() + "\r\n");
            }
        }
    }

}
