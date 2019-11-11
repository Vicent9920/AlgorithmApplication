package com.vincent.algorithmapplication.interview

import java.lang.Exception
import java.util.*

/**
 * <p>文件描述：用栈实现自定义队列<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/4 0004 <p>
 * <p>@update 2019/11/4 0004<p>
 * <p>版本号：1<p>
 *
 */
class CustomQueue {
    private val stackA = Stack<Int>()
    private val stackB = Stack<Int>()

    fun push(element:Int){
        stackA.push(element)
    }

    fun pop():Int{
        if(stackB.isEmpty()){
            if(stackA.empty()){
                throw Exception("Queue is empty!")
            }
            transfer()
        }
        return stackB.pop()
    }

    private fun transfer(){
        while (stackA.isNotEmpty()){
            stackB.push(stackA.pop())
        }
    }
}
