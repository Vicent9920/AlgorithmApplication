package com.vincent.algorithmapplication.sort

import java.util.*

object BubbleSort {
    // 标准冒泡排序
    fun sort(array: IntArray) {
        for (i in array.indices) {
            for (j in 0 until array.size - i - 1) {
                if (array[j] > array[j + 1]) {
                    var temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                }
            }
        }
    }

    // 第一轮优化  冒泡排序
    fun sort2(array: IntArray) {
        for (i in array.indices) {
            // 标志位
            var isSorted = true
            for (j in 0 until array.size - i - 1) {
                if (array[j] > array[j + 1]) {
                    var tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                    // 有元素交换，修改标志位
                    isSorted = false
                }
            }
            if (isSorted) break
        }
    }

    // 第二轮优化 冒泡排序
    fun sort3(array: IntArray) {
        // 记录最后一次交换的位置
        var lastExchangeIndex = 0
        // 排序边界
        var sortBorder = array.size - 1
        for (i in array.indices) {
            // 标志位
            var isSorted = true
            for (j in 0 until sortBorder) {
                if (array[j] > array[j + 1]) {
                    var tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                    // 有元素交换，修改标志位
                    isSorted = false
                    // 交换元素的边界
                    lastExchangeIndex = j
                }
            }
            sortBorder = lastExchangeIndex
            if (isSorted) break
        }
    }

    /**
     * 冒泡排序算法抽象
     * @param array 需要排序的集合
     * @param callback 元素比较的方法，a 需要排在后面返回 true ,否则返回 false
     * <pre>   {@code
     * val array2 = arrayOf("2","4","1","5","3","6","7","8","9")
     * BubbleSort.sort3T(array2){
     * a:String,b:String ->
     * // 升序排列 ["1","2","3","4","5","6","7","8","9"]
     * //            return@sort3T a.toInt()>b.toInt()
     * // 降序排列 ["9","8", "7", "6", "5", "4", "3", "2", "1"]
     * return@sort3T a.toInt()<b.toInt()
     * }</pre>
     */
    fun <T> sort3T(array: Array<T>,callback:((a:T,b:T) -> Boolean)){

        // 记录最后一次交换的位置
        var lastExchangeIndex = 0
        // 排序边界
        var sortBorder = array.size - 1
        for (i in array.indices) {
            // 标志位
            var isSorted = true
            for (j in 0 until sortBorder) {
                if(callback.invoke(array[j],array[j+1])){
                    var tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                    // 有元素交换，修改标志位
                    isSorted = false
                    // 交换元素的边界
                    lastExchangeIndex = j
                }

            }
            sortBorder = lastExchangeIndex
            if (isSorted) break
        }
    }

    // 双向排序  鸡尾酒排序
    fun sort4(array: IntArray){
        var tmp = 0
        for (i in 0 until array.size/2){
            // 标志位
            var isSorted = true
            for (j in i until array.size-i-1){
                if(array[j] > array[j+1]){
                    tmp = array[j]
                    array[j] = array[j+1]
                    array[j+1] = tmp
                    isSorted = false
                }
            }
            if(isSorted)break
            isSorted = true
            for (k in array.size-i-1 downTo i+1){
                if(array[k] < array[k-1]){
                    tmp = array[k]
                    array[k] = array[k-1]
                    array[k-1] = tmp
                    isSorted = false
                }
            }
            if(isSorted)break
        }
    }

    /**
     * 双向冒泡排序（也称鸡尾酒排序）算法抽象
     * @param array 需要排序的集合
     * @param callback 元素比较的方法，a 需要排在后面返回 true ,否则返回 false
     * <pre>   {@code
     * val array2 = arrayOf("2","4","1","5","3","6","7","8","9")
     * BubbleSort.sort4t(array2){
     * a:String,b:String ->
     * // 升序排列 ["1","2","3","4","5","6","7","8","9"]
     * //            return@sort3T a.toInt()>b.toInt()
     * // 降序排列 ["9","8", "7", "6", "5", "4", "3", "2", "1"]
     * return@sort3T a.toInt()<b.toInt()
     * }</pre>
     */
    fun <T> sort4t(array: Array<T>,callback:((a:T,b:T) -> Boolean)){

        for (i in 0 until array.size/2){
            // 标志位
            var isSorted = true
            for (j in i until array.size-i-1){

                if(callback.invoke(array[j],array[j+1])){
                    val tmp = array[j]
                    array[j] = array[j+1]
                    array[j+1] = tmp
                    isSorted = false
                }
            }
            if(isSorted)break
            isSorted = true
            for (k in array.size-i-1 downTo i+1){
                if(!callback.invoke(array[k],array[k-1])){
                    val tmp = array[k]
                    array[k] = array[k-1]
                    array[k-1] = tmp
                    isSorted = false
                }
            }
            if(isSorted)break
        }
    }
}