package com.example.myapplication.data

import java.util.*
//UUID — вспомогательный класс Java, входящий в
//инфраструктуру Android, — предоставляет простой способ
//генерирования универсально-уникальных идентификаторов. В
//конструкторе такой идентификатор генерируется вызовом
//UUID.randomUUID().
data class Todo(val id: UUID = UUID.randomUUID(), val title: String ="", val data: Date = Date(),
                var isSolved: Boolean =false)

