package com.vincent.algorithmapplication.sort

/**
 * <p>文件描述：计数排序的实现<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/2 0002 <p>
 * <p>@update 2019/11/2 0002<p>
 * <p>版本号：1<p>
 *
 */
object CountSort {

    // 计数排序
    fun sort(array: IntArray):IntArray{
        // 计算数列的最大值
        var max = array[0]
        for (i in 1 until array.size){
            if(array[i]>max){
                max = array[i]
            }
        }
        // 根据最大值确定统计数组长度
        val countArray = IntArray(max+1)
        // 遍历数列，填充统计数组
        for(i in array){
            countArray[i]++
        }
        // 遍历统计数组 输出结果
        var index = 0
        val resultData = IntArray(array.size)
        for (i in countArray.indices){
            for (j in 0 until countArray[i]){
                resultData[index++] = i
            }
        }
        return resultData
    }

    // 计数排序 优化
    fun sort2(array: IntArray):IntArray{
        // 计算数列的最大值、最小值、以及差值
        var max = array[0]
        var min = array[0]
        for (i in 1 until array.size){
            if(array[i]>max){
                max = array[i]
            }
            if(array[i]<min){
                min = array[i]
            }
        }
        val d = max-min

        // 根据最大值确定统计数组长度
        val countArray = IntArray(d+1)
        // 遍历数列，填充统计数组
        for(i in array){
            countArray[i-min]++
        }
        for (i in 1 until countArray.size){
            countArray[i]+=countArray[i-1]
        }

        // 遍历统计数组 输出结果
        val resultData = IntArray(array.size)
        for (i in array.size-1 downTo 0){
            resultData[countArray[array[i]-min]-1] = array[i]
            countArray[array[i]-min]--
        }
        return resultData
    }
}