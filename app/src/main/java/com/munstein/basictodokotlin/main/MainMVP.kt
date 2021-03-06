package com.munstein.basictodokotlin.main

import com.munstein.basictodokotlin.model.Task

/**
 * Created by @Munstein on 24/11/2017. --02:34
 */

interface MainMVP {

    interface model{
        fun saveTask(task : Task) : Boolean
        fun removeTask(task : Task)
        fun getTasks() : List<Task>
        fun changeFavoriteStatus(task : Task)
    }

    interface view{
        fun updateView(tasks : List<Task>)
        fun showMessage(msg : String)
    }

    interface presenter{
        fun changeFavoriteStatus(task : Task)
        fun addTask(task : Task)
        fun removeTask(task : Task)
        fun getTasks() : List<Task>
    }

}