package com.vincent.algorithmapplication.interview

import java.lang.Exception
import java.util.*

/**
 * <p>文件描述：自定义栈<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/4 0004 <p>
 * <p>@update 2019/11/4 0004<p>
 * <p>版本号：1<p>
 *
 */
class CustomStack {
    private val mainStack = Stack<Int>()
    private var minStack = Stack<Int>()

    // 入栈
    fun push(element:Int){
        mainStack.push(element)
        if(minStack.empty() || element <= minStack.peek()){
            minStack.push(element)
        }
    }

    // 出栈
    fun pop():Int{
        if(mainStack.peek() == minStack.peek()){
            minStack.pop()
        }
        return mainStack.pop()
    }

    // 获取栈最小元素
    fun getMin():Int{
        if(mainStack.empty()){
            throw Exception("Stack is empty")
        }
        return minStack.peek()
    }
}
