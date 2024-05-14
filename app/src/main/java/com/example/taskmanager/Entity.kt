package com.example.taskmanager

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
class Entity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var priority:String) {



}