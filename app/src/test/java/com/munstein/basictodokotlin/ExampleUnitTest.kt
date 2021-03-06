package com.munstein.basictodokotlin

import com.munstein.basictodokotlin.data.NitriteDataAccess
import com.munstein.basictodokotlin.main.MainModel
import com.munstein.basictodokotlin.model.Task
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 * :D
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    var data = NitriteDataAccess()
    var mainModel = MainModel(data)

    @Test
    fun test_add_select() {
        var task = Task("Hello NoSQL", false)
        mainModel.saveTask(task)
        var tasks = mainModel.getTasks()
        assertEquals(task.description, tasks[0].description)
    }

    @Test
    fun test_add_select_remove() {
        var task = Task("Hello NoSQL", false)
        mainModel.saveTask(task)
        var tasks = mainModel.getTasks()
        assertEquals(task.description, tasks[0].description)
        mainModel.removeTask(tasks[0])
        tasks = mainModel.getTasks()
        assertEquals(0, tasks.size)
    }

    @Test
    fun test_add_multiple() {
        var total = 55
        var task = Task("Hello NoSQL", false)

        for (i in 1..total){
            task.description += i.toString()
            mainModel.saveTask(task)
        }

        var tasks = mainModel.getTasks()
        assertEquals(total, tasks.size)
    }

    @Test
    fun test_add_task_with_same_description(){
        var total = 3
        var task = Task("Hello NoSQL", false)

        for (i in 1..total){
            mainModel.saveTask(task)
        }

        var tasks = mainModel.getTasks()
        assertEquals(1, tasks.size)
    }

    @Test
    fun test_changeFavoriteStatusToFalse() {
        var task = Task("Hello NoSQL", true)
        mainModel.saveTask(task)
        var tasks = mainModel.getTasks()
        assertEquals(task.description, tasks[0].description)
        task.isFavorite = false
        mainModel.changeFavoriteStatus(task)
        tasks = mainModel.getTasks()
        assertEquals(false, tasks[0].isFavorite)
    }

    @Test
    fun test_changeFavoriteStatusToTrue() {
        var task = Task("Hello NoSQL", false)
        mainModel.saveTask(task)
        var tasks = mainModel.getTasks()
        assertEquals(task.description, tasks[0].description)
        task.isFavorite = true
        mainModel.changeFavoriteStatus(task)
        tasks = mainModel.getTasks()
        assertEquals(true, tasks[0].isFavorite)
    }


}
