package com.vincent.algorithmapplication

import com.vincent.algorithmapplication.sort.*
import org.junit.Test

/**
 * <p>文件描述：排序算法测试<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/10/31 0031 <p>
 * <p>@update 2019/10/31 0031<p>
 * <p>版本号：1<p>
 *
 */
class Sort {
    // 冒泡排序
    @Test
    fun sort1() {
//        val array = intArrayOf(2,4,1,5,3,6,7,8,9)//5,8,6,3,9,4,7,1,2,6
//        BubbleSort.sort(array)
//        BubbleSort.sort2(array)
//        BubbleSort.sort3(array)
//        BubbleSort.sort4(array)
//        println(array.contentToString())
        val array2 = arrayOf("2", "4", "1", "5", "3", "6", "7", "8", "9")
        BubbleSort.sort3T(array2) { a: String, b: String ->
            // 升序排列 ["1","2","3","4","5","6","7","8","9"]
//            return@sort3T a.toInt()>b.toInt()
            // 降序排列 ["9","8", "7", "6", "5", "4", "3", "2", "1"]
            return@sort3T a.toInt() < b.toInt()
        }
        println(array2.contentToString())
    }

    // 快速排序
    @Test
    fun quickSort(){
        var array = intArrayOf(4,6,5,2,8,9,7,5,1,3)
        QuickSort.sort(array,0,array.size-1,false)
        println(array.contentToString())
        array = intArrayOf(4,8,6,7,4,2,1,5,3,9,5)
        QuickSort.sort(array,0,array.size-1,true)
        println(array.contentToString())
        array = intArrayOf(8,4,3,9,5,7,2,6,5,1,8,4)
        QuickSort.sort(array,0,array.size-1)
        println(array.contentToString())
    }

    // 堆排序
    @Test
    fun heapSort(){
        val array = intArrayOf(2,4,1,5,3,6,7,8,9)
        HeapSort.sort(array)
        println(array.contentToString())
    }

    // 计数排序
    @Test
    fun countSort(){
        println(CountSort.sort(intArrayOf(8,4,5,2,1,5,6,2,5,9,4,7,1,6,2,3,4,5)).contentToString())
        println(CountSort.sort2(intArrayOf(99,110,115,105,107,92,111,106,98,108)).contentToString())
    }

    // 桶排序
    @Test
    fun bucketSort(){
        println(BucketSort.sort(doubleArrayOf(3.2,4.2,6.5,5.1,15.2,11.5,12.6,4.8,6.4,9.9,1.5,10.2)).contentToString())
    }

}