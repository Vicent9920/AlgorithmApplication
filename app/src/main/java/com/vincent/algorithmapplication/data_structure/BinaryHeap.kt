package com.vincent.algorithmapplication.data_structure

/**
 * <p>文件描述：二叉堆的实现<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/10/27 0027 <p>
 * <p>@update 2019/10/27 0027<p>
 * <p>版本号：1<p>
 *
 */
object BinaryHeap {
    // “上浮”调整（插入节点排序）
    fun upAdjust(array: IntArray) {
        var childIndex = array.size - 1
        var parentIndex = (childIndex - 1) / 2
        var temp = array[childIndex]
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex]
            childIndex = parentIndex
            parentIndex = (parentIndex - 1) / 2
        }
        array[childIndex] = temp
    }

    // “下沉”调整 （删除节点）
    fun downAdjust(array: IntArray, index: Int, length: Int) {
        var parentIndex = index
        var temp = array[parentIndex]
        var childIndex = 2 * parentIndex + 1
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++
            }
            if (temp <= array[childIndex]) {
                break
            }
            array[parentIndex] = array[childIndex]
            parentIndex = childIndex
            childIndex = 2 * childIndex + 1
        }
        array[parentIndex] = temp
    }

    fun buildHeap(array: IntArray) {
        for (i in (array.size - 2) / 2 downTo 0) {
            downAdjust(array, i, array.size)
        }
    }


}