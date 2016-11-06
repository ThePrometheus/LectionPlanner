

package org.optaplanner.examples.curriculumcourse.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.common.swingui.components.Labeled;

@XStreamAlias("Room")
public class Room extends AbstractPersistable implements Labeled {

    private String code;
    private int capacity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getLabel() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }

}
