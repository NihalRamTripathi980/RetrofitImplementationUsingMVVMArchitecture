package com.example.retrofitusingmvvmandkotlin.model

data class Post(
    val `data`: Data,
    val status: String
){
    data class Data(
        val app_update: Int,
        val continue_watching: List<ContinueWatching>,
        val continue_watching_graph: List<ContinueWatchingGraph>,
        val my_courses: List<MyCourse>,
        val my_courses_analytics: List<MyCoursesAnalytic>,
        val popular_courses: List<PopularCourse>,
        val popular_schools: List<PopularSchool>,
        val popular_teachers: List<PopularTeacher>,
        val user_status: String
    ){
        data class ContinueWatching(
            val course_id: Int,
            val course_name: String,
            val last_mile_id: Int,
            val milestone_name: String,
            val percentage: Double
        )

        data class ContinueWatchingGraph(
            val accuracy: Double,
            val actual_milestone_duration: Int,
            val actual_play_duration: Int,
            val actual_video_time: List<Int>,
            val course_duration: Int,
            val course_id: Int,
            val course_name: String,
            val last_mile_id: Int,
            val milestone_name: String,
            val percentage: Double,
            val spent_video_time: List<Int>
        )
        data class MyCourse(
            val `class`: String,
            val description: String,
            val duration: Int,
            val id: Int,
            val image: String,
            val owner_image: String,
            val owner_name: String,
            val owner_qualification: String,
            val popularity: Int,
            val title: String
        )

        data class MyCoursesAnalytic(
            val `class`: String,
            val description: String,
            val duration: Int,
            val id: Int,
            val image: String,
            val owner_image: String,
            val owner_name: String,
            val owner_qualification: String,
            val popularity: Int,
            val title: String
        )

        data class PopularCourse(
            val description: String,
            val duration: Int,
            val id: Int,
            val image: String,
            val monthly_rate: String,
            val owner_image: String,
            val owner_name: String,
            val owner_qualification: String,
            val popularity: Int,
            val title: String
        )
        data class PopularSchool(
            val city: String,
            val country: String,
            val email: String,
            val id: Int,
            val image: String,
            val mobile: String,
            val name: String,
            val popularity: Int,
            val qualification: String,
            val short_intro: String,
            val subscriber: String
        )
        data class PopularTeacher(
            val city: String,
            val country: String,
            val email: String,
            val id: Int,
            val image: String,
            val mobile: String,
            val name: String,
            val popularity: Int,
            val qualification: String,
            val short_intro: String,
            val subscriber: String
        )
    }

}