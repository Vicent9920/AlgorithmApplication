package com.vincent.algorithmapplication.data_structure

import java.lang.Exception

/**
 * <p>文件描述：自定义对列的实现<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/10/23 0023 <p>
 * <p>@update 2019/10/23 0023<p>
 * <p>版本号：1<p>
 *
 */
class MyQueue (capaicty:Int){
    private  var array:IntArray
    var front = 0
    var rear = 0
    init {
        array = IntArray(capaicty)
    }

    fun enQueue(element:Int){
        if((rear+1)%array.size == front){
            throw Exception("队列已满")
        }
        array[rear] = element
        rear = (rear+1)%array.size
    }

    fun deQueue():Int{
        if(rear == front){
            throw Exception("队列已空")
        }
        val deQueueElement = array[front]
        front = (front+1)%array.size
        return deQueueElement
    }

    fun output(){
        for (i in array){
            print(i)
        }
        println()

        val matrix = Array(6){IntArray(6)}

    }
}