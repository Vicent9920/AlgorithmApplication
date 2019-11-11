package com.vincent.algorithmapplication.interview

import android.app.usage.NetworkStats
import java.lang.Integer.max
import java.lang.StringBuilder
import java.util.*
import java.util.regex.Pattern
import kotlin.math.min
import kotlin.math.sqrt

/**
 * <p>文件描述：面试算法代码<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/4 0004 <p>
 * <p>@update 2019/11/4 0004<p>
 * <p>版本号：1<p>
 *
 */

data class Node(var data: Int, var next: Node? = null)
data class Bucket(var max:Int = 0,var min:Int = 0)

object InterViewCode {
    // 链表是否有环
    fun isCycle(head: Node): Boolean {
        var p1: Node? = head
        var p2: Node? = head
        while (p1 != null && p2?.next != null) {
            p1 = p1.next
            p2 = p2.next?.next
            if (p1 == p2) {
                return true
            }
        }
        return false
    }

    // 获取链表环的长度
    fun getCycleOfLength(head: Node): Int {
        var p1: Node? = head
        var p2: Node? = head
        var count = 0
        var length = 0
        while (p1 != null && p2?.next != null) {
            p1 = p1.next
            p2 = p2.next?.next
            if (p1 == p2) {
                count++
            }
            if (count == 1) {
                length += 1
            }
            if (count == 2) {
                return length
            }
        }
        return 0

    }

    // 获取链表环的起点
    fun getCycleOfStart(head: Node): Int {
        var p1: Node? = head
        var p2: Node? = head
        var count = 0

        while (p1 != null && p2?.next != null) {
            // 这是乌龟 速度始终保持
            p1 = p1.next
            // 这是兔子 速度在相遇前和相遇后有变化
            // 相遇以后慢慢跑，和乌龟速度同步
            p2 = if (count == 1) {
                p2.next
            } else {
                // 还在首圈冲刺阶段，开足马力
                p2.next?.next
            }

            if (p1 == p2) {
                count++
                if (count == 1) {
                    // 从头开始
                    p1 = head
                } else {
                    return p1?.data ?: 0
                }
            }

        }
        return 0

    }

    // 获取最大公约数
    // c 最大公约数
    fun getGreatCommonDivisor(a:Int,b:Int,c:Int = 1):Int{
        val max = kotlin.math.max(a, b)
        val min = min(a,b)
        if(max % min == 0){
            return min
        }
        var common = c
        var total = min
        for (i in 2..min){
            if(i >= total)break
            if(isPrime(i)){
                if(min % i == 0 && max % i == 0){
                    common *= i
                    total /= common
                    return getGreatCommonDivisor(max,total,common)
                }
            }
        }
        return common
    }

    // 是否是素数
    private fun  isPrime(data:Int):Boolean {
        if(data<4){
            return true
        }
        if(data%2 == 0){
            return false
        }

        val sqrt = sqrt(data.toDouble())
        for (i in 3..sqrt.toInt() step 2){
            if(data%i == 0){
                return false
            }
        }

        return true;
    }

    // 辗转相除法
    fun getGreatCommonDivisor2(a:Int,b:Int):Int{
        val max = kotlin.math.max(a, b)
        val min = min(a,b)
        if(max%min == 0){
            return min
        }
        return getGreatCommonDivisor2(max%min,min)
    }

    // 更相减损术
    fun getGreatCommonDivisor3(a:Int,b:Int):Int{
        if(a == b)return a
        val max = kotlin.math.max(a, b)
        val min = min(a,b)
        if(max % min == 0){
            return min
        }
        return getGreatCommonDivisor2(max - min,min)
    }

    // 位移运算
    fun getGreatCommonDivisor4(a:Int,b:Int):Int{
        if(a == b)return a
        if((a and 1) == 0 && (b and 1) == 0 ){
            return getGreatCommonDivisor4(a.shr(1),b.shr(1)).shl(1)
        }else if((a and 1) == 0 && (b and 1) != 0){
            return getGreatCommonDivisor4(a.shr(1),b)
        }else if((a and 1) != 0 && (b and 1) == 0){
            return getGreatCommonDivisor4(a,b.shr(1))
        }else{
            val max = kotlin.math.max(a, b)
            val min = min(a,b)
            return getGreatCommonDivisor4(max-min,min)
        }
    }

    // 求是否是2的整数次冥
    fun isPowerOf(num: Int): Boolean {
        return num and num - 1 == 0
    }

    // 求无序数组最大相邻差
    fun getMaxSortedDistance(array: IntArray):Int{
        var max = array[0]
        var min = array[0]
        // 计算数列的最大值和最小值以及差值
        for (i in array){
            if(i>max){
                max = i
            }
            if(i < min){
                min = i
            }
        }
        val d = max-min
        if(d == 0)return 0
        // 初始化桶
        val bucketNum = array.size
        val bucketList = Array(bucketNum) { _ ->
            return@Array Bucket()
        }
        // 遍历原始数组 确定桶的大小
        for (i in array){
            // 确定数组元素所归属的桶下标
            val index = (i-min)*(bucketNum-1)/d
            if(bucketList[index].min == 0 || bucketList[index].min > i){
                bucketList[index].min = i
            }
            if(bucketList[index].max == 0 || bucketList[index].max<i){
                bucketList[index].max = i
            }
        }
        // 遍历桶，找到最大值
        var leftMax = bucketList[0].max
        var result = 0
        for (i in 1 until bucketNum){
            if(bucketList[i].min == 0)continue
            if(bucketList[i].min - leftMax > result){
                result = bucketList[i].min - leftMax
            }
            leftMax = bucketList[i].max
        }
        return result
    }

    fun findNearestNumber(num:Int):Int{
        // 从后向前查看逆向区域，找到逆序区域的前一位，即数字置换的边界
        val array = numToArray(num)
        val index = findTransFerPoint(array)
        // 如果数字置换边界是0 ，说明整个数组已经逆序，无法得到更大的相同数组组成的整数
        if(index == 0){
            return num
        }
        // 让逆序区域的前一位和逆序区域中大于大于它的最小数字交换位置
        exchange(array,index)
        // 把原来的逆序区转为顺序状态
        reverse(array,index)
        return arrayToNum(array)
    }

    private fun reverse(array: IntArray, index: Int) {
        var j = index
        for (i in array.size-1 downTo 1){
            if(j<=i)break
            val tmp = array[j]
            array[j] = array[i]
            array[i] = tmp
            j++
        }
    }

    private fun exchange(array: IntArray, index: Int) {
        val head = array[index-1]
        for (i in array.size-1 downTo 1){
            if(head < array[i]){
                array[index-1] = array[i]
                array[i] = head
                break
            }
        }
    }

    private fun findTransFerPoint(array: IntArray):Int{
        for (i in array.size-1 downTo 1){
            if(array[i]>array[i-1]){
                return i
            }
        }
        return 0
    }



    // 整数转整数数组
    private fun numToArray(num: Int):IntArray{

        val b = num.toString()
        val result = IntArray(b.length)
        val c =  b.split(Pattern.compile("/*"))
        for (i in c.indices) {
            if(c[i].isNotEmpty()){
                result[i] = Integer.valueOf(c[i])
            }

        }
        return result
    }
    // 整数组转整数
    private fun arrayToNum(array: IntArray):Int{
        val result = StringBuilder()
        for (i in array){
            result.append(i)
        }
        return result.toString().toInt()
    }

    // 删除数字 K
    fun removeKDigits(num:String,k:Int):String{
        var count = k;
        // 创建一个栈接收所有的数字
        val stack = CharArray(num.length)
        var top = 0
        // 当栈定数字大于遍历到当前数字时，栈顶数字出栈（相当于删除数字）
        for (i in num){
            while (top >0 && stack[top-1] >i && count >0){
                top --
                count--
            }
            stack[top++] = i
        }
        // 找到栈中第一个非零数字的位置，以此构建新的整数字符串
        var offset = 0
        while (offset < num.length-k && stack[offset] == '0'){
            offset++
        }
        return if(offset == num.length-k) "0" else String(stack,offset,num.length-k-offset)
    }

    // 删除数字 K
    fun removeKDigits2(num:String,k:Int):String{
        return when (k) {
            0 -> num
            num.length -> "0"
            else -> removeKDigits(numToArray(num.toInt()),k).toString()
        }
    }
    // 删除数字 K 具体过程
    private fun removeKDigits(num:IntArray, k:Int):Int{
        var  top = num[0]
        var count = k
        for (i in 1 until num.size){
            if(top>num[i] && num[i] != -1){
                num[i-1] = -1
                count--
                if(count == 0)break
            }
            top = num[i]
        }
        if(count >0){
            return removeKDigits(num,count)
        }
        val sb = StringBuilder()
        var isOffset = false
        for (i in num){
            if(isOffset && i != -1){
                sb.append(i)
            }else{
                if(i >= 1){
                    sb.append(i)
                    isOffset = true
                }
            }
        }
        if(sb.isEmpty())return 0
        return sb.toString().toInt()
    }

    // 超大型整数相加
    fun bigNumSum(a:String,b:String):String{
        if(a.isEmpty())return "0"
        if(b.isEmpty())return "0"
        val numA = a.split(Pattern.compile("/*")).toTypedArray()
        val numB = b.split(Pattern.compile("/*")).toTypedArray()
        numA.reverse()
        numB.reverse()
        val max = Math.max(numA.size,numB.size)
        var spaceNumber = 0
        val sb = StringBuilder()
        for (i in 1..max){
            val x = if(numA.size <= i) 0 else numA[i].toInt()
            val y = if(numB.size <= i) 0 else numB[i].toInt()
            val num = x+y+spaceNumber
            spaceNumber = if(num>10){
                1
            } else if(num == 0){
                spaceNumber == 0
                continue
            }else{
                0
            }
            sb.append(num%10)
        }

        if(spaceNumber == 1){
            sb.append(1)
        }

        return sb.reverse().toString()
    }
}

