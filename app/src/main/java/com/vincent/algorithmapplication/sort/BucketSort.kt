package com.vincent.algorithmapplication.sort

import java.util.*

/**
 * <p>文件描述：桶排序的实现<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/2 0002 <p>
 * <p>@update 2019/11/2 0002<p>
 * <p>版本号：1<p>
 *
 */
object BucketSort {
    fun sort(array: DoubleArray):DoubleArray{
        // 得到数列的最大值、最小值、差值
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
        // 初始化桶
        val bucketNumber = array.size
        val bucketList = mutableListOf<LinkedList<Double>>()
        for (i in 0 until bucketNumber){
            bucketList.add(LinkedList())
        }
        // 遍历原始数组
        for (i in array){
            // 区间跨度
            val num = ((i-min)*(bucketNumber-1)/d).toInt()
            bucketList[num].add(i)
        }
        // 对每个桶内部进行排序
        for (i in bucketList){
            // JDK 底层采用了归并排序或者归并的优化版本
            i.sort()
        }

        // 输出全部元素
        val resultData = DoubleArray(array.size)
        var index = 0
        for (list in bucketList){
            for (i in list){
                resultData[index] = i
                index++
            }
        }
        return resultData
    }
}