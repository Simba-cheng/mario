package org.mario.service.impl;

import org.mario.persistent.ProjectRepository;
import org.mario.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author CYX
 * @create 2019-02-20-22:41
 */
public class ProjectServiceImpl implements ProjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void addProject(String projectName) {

        try {

            projectRepository.findProjectByProjectName(projectName);


        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    @Override
    public void deleteProject(String projectName) {

    }

    @Override
    public void updateProject(String projectName) {

    }
}
