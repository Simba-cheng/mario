package org.mario.vo.response;

import java.util.List;

/**
 * @author CYX
 * @date: 2019/2/27 11:11
 */
public class SearchAllProjectVO extends ResponseVO {

    /**
     * 项目名称
     */
    private List<String> projectNames;

    public List<String> getProjectNames() {
        return projectNames;
    }

    public void setProjectNames(List<String> projectNames) {
        this.projectNames = projectNames;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SearchAllProjectVO{");
        sb.append("projectNames=").append(projectNames);
        sb.append('}');
        return sb.toString();
    }
}
