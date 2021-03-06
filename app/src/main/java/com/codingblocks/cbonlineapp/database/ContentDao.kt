package com.codingblocks.cbonlineapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
abstract class ContentDao : BaseDao<CourseContent> {

    @Query("SElECT * FROM CourseContent ")
    abstract fun getContent(): LiveData<List<CourseContent>>

    @Query("SElECT * FROM CourseContent where attempt_id = :attempt_id ")
    abstract fun getCourseContents(attempt_id: String): LiveData<List<CourseContent>>

    @Query("SElECT * FROM CourseContent where attempt_id = :attempt AND section_id = :section")
    abstract fun getCourseSectionContents(attempt: String, section: String): LiveData<List<CourseContent>>

    @Query("UPDATE CourseContent SET isDownloaded = 1 WHERE lectureContentId = :contentid AND section_id = :section")
    abstract fun updateContent(section: String, contentid: String)

    //TODO use case with when instead of making 3 functions
    //Dynamic paramters not working

    @Query("UPDATE CourseContent SET progress = :progress WHERE lectureContentId = :contentid AND section_id = :section")
    abstract fun updateProgressLecture(section: String, contentid: String, progress: String)

    @Query("UPDATE CourseContent SET progress = :progress WHERE documentContentId = :contentid AND section_id = :section")
    abstract fun updateProgressDocuemnt(section: String, contentid: String, progress: String)

    @Query("UPDATE CourseContent SET progress = :progress WHERE videoContentId = :contentid AND section_id = :section")
    abstract fun updateProgressVideo(section: String, contentid: String, progress: String)


}