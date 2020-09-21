package org.mario.persistent.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author CYX
 * @create 2019-02-20-22:19
 */
@Entity
@Table(name = "project")
public class Project {

    /**
     * pId-项目/应用编号
     */
    @Id
    @GeneratedValue
    @Column(name = "pId", nullable = false)
    private Integer pId;

    /**
     * 项目应用名称
     */
    @Column(name = "projectName", nullable = false)
    private String projectName;

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public Project() {
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Project{");
        sb.append("pId=").append(pId);
        sb.append(", projectName='").append(projectName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
