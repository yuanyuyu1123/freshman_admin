package com.rs.service.impl;

import com.rs.entity.Classes;
import com.rs.service.ClassesServlet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ClassesServletImpl implements ClassesServlet {
    @Resource
    private ClassesServlet classesServlet;
    @Override
    public List<Classes> queryAllClasses() {
        List<Classes> classes = classesServlet.queryAllClasses();
        return classes;
    }

    @Override
    public Classes queryClassesByClassesId(String classesId) {
        Classes classes = classesServlet.queryClassesByClassesId(classesId);
        return classes;
    }

    @Override
    public List<String> queryClassesByCollegeName(String collegeName) {
        List<String> strings = classesServlet.queryClassesByCollegeName(collegeName);
        return strings;
    }
}
