package com.vincent.algorithmapplication

import com.vincent.algorithmapplication.interview.CustomQueue
import com.vincent.algorithmapplication.interview.CustomStack
import com.vincent.algorithmapplication.interview.InterViewCode
import com.vincent.algorithmapplication.interview.Node
import org.junit.Test
import java.util.regex.Pattern

/**
 * <p>文件描述：面试算法测试<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/4 0004 <p>
 * <p>@update 2019/11/4 0004<p>
 * <p>版本号：1<p>
 *
 */
class InterView {
    // 测试链表是否有环
    @Test
    fun testLinkedCycle(){
        val node1 = Node(5)
        node1.next = Node(3)
        node1.next?.next = Node(7)
        node1.next?.next?.next = Node(2)
        node1.next?.next?.next?.next = Node(6)
        node1.next?.next?.next?.next?.next = node1.next
        println("链表是否有环：${InterViewCode.isCycle(node1)}")
        println("链表环的长度：${InterViewCode.getCycleOfLength(node1)}")
        println("链表环的入环点：${InterViewCode.getCycleOfStart(node1)}")
    }

    // 测试自定义栈
    @Test
    fun testMinStack(){
        val stack = CustomStack()
        stack.push(5)
        stack.push(7)
        stack.push(8)
        stack.push(3)
        stack.push(1)
        println(stack.getMin())
        stack.pop()
        stack.pop()
        stack.pop()
        println(stack.getMin())
    }

    // 求最大公约数
    @Test
    fun getMax(){
        // 默认方法
        println(InterViewCode.getGreatCommonDivisor(240,600))
        // 辗转相除法
        println(InterViewCode.getGreatCommonDivisor2(240,600))
        // 更相减损术
        println(InterViewCode.getGreatCommonDivisor3(240,600))
        // 位移运算
        println(InterViewCode.getGreatCommonDivisor4(240,600))

    }

    @Test
    fun testPower(){
        println(InterViewCode.isPowerOf(39))
    }

    // 求最大差
    @Test
    fun getMaxDistance(){
        println("最大相邻差：${InterViewCode.getMaxSortedDistance(intArrayOf(2,6,3,4,5,10,9))}")
    }

    // 测试栈
    @Test
    fun testCustomQueue(){
        val customQueue = CustomQueue()
        customQueue.push(1)
        customQueue.push(2)
        customQueue.push(3)
        println(customQueue.pop())
        println(customQueue.pop())
        customQueue.push(4)
        println(customQueue.pop())
        println(customQueue.pop())
    }

    // 测试字典序算法
    @Test
    fun testLexicographicalOrder(){
        var value = 12345
        for (i in 0 until 10){
            value = InterViewCode.findNearestNumber(value)
            println(value)
        }

    }

    // 测试删除K个数字的方法
    @Test
    fun testRemoveKDigits(){
        var value = InterViewCode.removeKDigits("1593212",2)
        println(value)
        value = InterViewCode.removeKDigits2("1593212",2)
        println(value)
        value = InterViewCode.removeKDigits("30200",1)
        println(value)
        value = InterViewCode.removeKDigits2("30200",1)
        println(value)
        value = InterViewCode.removeKDigits("10",2)
        println(value)
        value = InterViewCode.removeKDigits("10",2)
        println(value)
        value = InterViewCode.removeKDigits2("541270936",2)
        println(value)
        value = InterViewCode.removeKDigits("541270936",2)
        println(value)
    }


    // 整数转整数数组
    @Test
     fun numToArray(){

        val b = "123456789"
        val result = IntArray(b.length)
        val c =  b.split(Pattern.compile("/*"))
        for (i in c.indices) {
            if(c[i].isNotEmpty()){
                result[i] = Integer.valueOf(c[i])
            }

        }
        result.reverse()
       result.contentToString()
    }

    // 测试大型整数相加
    @Test
    fun testBigNumSum(){
        println(InterViewCode.bigNumSum("256","378"))
        println(InterViewCode.bigNumSum("425896556879442311568","104253689514247"))
    }

    // 测试动态规划
    @Test
    fun getBestGoldMining(){
        // 10 人 5矿 [400KG/5人,500KG/5人,200KG/3人,300KG/4人,350KG/3人]
        var value = InterViewCode.getBestGoldMining(10,5, intArrayOf(5,5,3,4,3), intArrayOf(400,500,200,300,350))
        println(value)
        value = InterViewCode.getBestGoldMining2(10,intArrayOf(5,5,3,4,3), intArrayOf(400,500,200,300,350))
        println(value)
        value = InterViewCode.getBestGoldMining3(10,intArrayOf(5,5,3,4,3), intArrayOf(400,500,200,300,350))
        println(value)
    }

}