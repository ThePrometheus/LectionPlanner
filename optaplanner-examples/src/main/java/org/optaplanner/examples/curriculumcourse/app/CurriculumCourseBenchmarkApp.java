

package org.optaplanner.examples.curriculumcourse.app;

import org.optaplanner.examples.common.app.CommonBenchmarkApp;

public class CurriculumCourseBenchmarkApp extends CommonBenchmarkApp {

    public static void main(String[] args) {
        new CurriculumCourseBenchmarkApp().buildAndBenchmark(args);
    }

    public CurriculumCourseBenchmarkApp() {
        super(
                new ArgOption("default",
                        "org/optaplanner/examples/curriculumcourse/benchmark/curriculumCourseBenchmarkConfig.xml"),
                new ArgOption("stepLimit",
                        "org/optaplanner/examples/curriculumcourse/benchmark/curriculumCourseStepLimitBenchmarkConfig.xml"),
                new ArgOption("template",
                        "org/optaplanner/examples/curriculumcourse/benchmark/curriculumCourseBenchmarkConfigTemplate.xml.ftl", true)
        );
    }

}
