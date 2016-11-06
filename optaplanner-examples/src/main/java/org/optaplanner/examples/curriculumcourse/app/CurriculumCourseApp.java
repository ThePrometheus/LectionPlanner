

package org.optaplanner.examples.curriculumcourse.app;

import org.optaplanner.examples.common.app.CommonApp;
import org.optaplanner.examples.common.persistence.AbstractSolutionExporter;
import org.optaplanner.examples.common.persistence.AbstractSolutionImporter;
import org.optaplanner.examples.common.persistence.SolutionDao;
import org.optaplanner.examples.common.swingui.SolutionPanel;
import org.optaplanner.examples.curriculumcourse.domain.CourseSchedule;
import org.optaplanner.examples.curriculumcourse.persistence.CurriculumCourseDao;
import org.optaplanner.examples.curriculumcourse.persistence.CurriculumCourseExporter;
import org.optaplanner.examples.curriculumcourse.persistence.CurriculumCourseImporter;
import org.optaplanner.examples.curriculumcourse.swingui.CurriculumCoursePanel;

public class CurriculumCourseApp extends CommonApp<CourseSchedule> {

    public static final String SOLVER_CONFIG
            = "org/optaplanner/examples/curriculumcourse/solver/curriculumCourseSolverConfig.xml";

    public static void main(String[] args) {
        prepareSwingEnvironment();
        new CurriculumCourseApp().init();
    }

    public CurriculumCourseApp() {
        super("Course timetabling",
                "Official competition name: ITC 2007 track3 - Curriculum course scheduling\n\n" +
                        "Assign lectures to periods and rooms.",
                SOLVER_CONFIG,
                CurriculumCoursePanel.LOGO_PATH);
    }

    @Override
    protected CurriculumCoursePanel createSolutionPanel() {
        return new CurriculumCoursePanel();
    }

    @Override
    protected SolutionDao createSolutionDao() {
        return new CurriculumCourseDao();
    }

    @Override
    protected AbstractSolutionImporter[] createSolutionImporters() {
        return new AbstractSolutionImporter[]{
                new CurriculumCourseImporter()
        };
    }

    @Override
    protected AbstractSolutionExporter createSolutionExporter() {
        return new CurriculumCourseExporter();
    }

}
