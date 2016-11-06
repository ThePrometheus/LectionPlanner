
package org.optaplanner.examples.curriculumcourse.persistence;

import org.optaplanner.examples.common.persistence.XStreamSolutionDao;
import org.optaplanner.examples.curriculumcourse.domain.CourseSchedule;

public class CurriculumCourseDao extends XStreamSolutionDao<CourseSchedule> {

    public CurriculumCourseDao() {
        super("curriculumcourse", CourseSchedule.class);
    }

}
