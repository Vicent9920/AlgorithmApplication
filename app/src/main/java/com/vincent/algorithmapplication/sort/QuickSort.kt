package com.vincent.algorithmapplication.sort

import java.util.*
import kotlin.collections.HashMap

/**
 * <p>文件描述：快速排序的实现<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/01 0027 <p>
 * <p>@update 2019/11/01 0027<p>
 * <p>版本号：1<p>
 *
 */
object QuickSort {
    /// 快速排序
    /// isDouble 是否双边循环
    fun sort(array: IntArray, startIndex: Int, endIndex: Int,isDouble:Boolean) {
        // 递归结束条件
        if (startIndex >= endIndex) return
        val pivotIndex = if(isDouble){
            partitionWithDouble(array, startIndex, endIndex)
        }else{
            partition(array, startIndex, endIndex)
        }

        // 根据基准元素，对分成两部分的数组进行递归排序
        sort(array, startIndex, pivotIndex - 1,isDouble)
        sort(array, pivotIndex + 1, endIndex,isDouble)
    }

    // 获取双边循环的基准元素
    // arr 需要排序的数组
    // startIndex 获取基准元素的起点边界
    // endIndex 获取基准元素的终点边界
    private fun partitionWithDouble(array: IntArray, startIndex: Int, endIndex: Int): Int{
        // 获取基准元素 默认获取第一个，也可获取其它任意元素
        // 根据数据情况选择不同的基准元素可以提高效率
        val pivot = array[startIndex]
        var left = startIndex
        var right = endIndex
        while (left!=right){
            // 控制right指针比较并左移
            while (left<right && array[right] > pivot){
                right--
            }
            // 控制left指针比较并右移
            while (left<right && array[left] <= pivot){
                left++
            }
            if(left<right){
                val tmp = array[left]
                array[left] = array[right]
                array[right] = tmp
            }

        }
        // pivot和指针重合点交换
        array[startIndex] = array[left]
        array[left] = pivot
        return left
    }

    // 获取基准元素
    // arr 需要排序的数组
    // startIndex 获取基准元素的起点边界
    // endIndex 获取基准元素的终点边界
    private fun partition(array: IntArray, startIndex: Int, endIndex: Int): Int {
        // 获取基准元素 默认获取第一个，也可获取其它任意元素
        // 根据数据情况选择不同的基准元素可以提高效率
        val pivot = array[startIndex]
        var mark = startIndex
        for (i in startIndex+1..endIndex){
            if(array[i] < pivot){
                mark++
                val tmp = array[mark]
                array[mark] = array[i]
                array[i] = tmp
            }
        }
        array[startIndex] = array[mark]
        array[mark] = pivot
        return mark
    }

    // 非递归方式实现排序
    fun sort(array: IntArray, startIndex: Int, endIndex: Int){
        val quickSortStack = Stack<Map<String,Int>>()
        // 整个数列的起止下标，以哈希的形式入栈
        val rootParam = HashMap<String,Int>()
        rootParam["startIndex"] = startIndex
        rootParam["endIndex"] = endIndex
        quickSortStack.push(rootParam)

        while (quickSortStack.isNotEmpty()){
            val param = quickSortStack.pop()
            val pivotIndex = partitionWithDouble(array,param["startIndex"]?:0,param["endIndex"]?:0)
            if(param["startIndex"]?:0< pivotIndex-1){
                val leftParam = HashMap<String,Int>()
                leftParam["startIndex"] = param["startIndex"]?:0
                leftParam["endIndex"] = pivotIndex-1
                quickSortStack.push(leftParam)
            }
            if(pivotIndex+1 < param["endIndex"]?:0){
                val rightParam = HashMap<String,Int>()
                rightParam["startIndex"] = pivotIndex+1
                rightParam["endIndex"] = param["endIndex"]?:0
                quickSortStack.push(rightParam)
            }
        }
    }
}