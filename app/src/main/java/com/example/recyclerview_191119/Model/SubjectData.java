package com.example.recyclerview_191119.Model;

public class SubjectData {


    String Subject_Name,Course_ID;

    public SubjectData(String subject_name,String course_id)
    {
        Subject_Name=subject_name;
        Course_ID=course_id;
    }
    public String getSubject_Name()
    {
        return Subject_Name;
    }

    public String getCourse_ID()
    {
        return Course_ID;
    }

    public void  setSubject_Name(String subject_name)
    {
        Subject_Name=subject_name;
    }

    public void setCourse_Id(String course_id)
    {
        Course_ID=course_id;
    }
}



