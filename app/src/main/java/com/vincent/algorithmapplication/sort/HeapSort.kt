package com.vincent.algorithmapplication.sort

/**
 * <p>文件描述：堆排序的实现<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/02 0027 <p>
 * <p>@update 2019/11/02 0027<p>
 * <p>版本号：1<p>
 *
 */
object HeapSort {
    fun sort(array: IntArray) {
        // 把无序数组构建成堆
        for (i in (array.size - 2) / 2 downTo 0) {
            downAdjust(array, i, array.size, false)
        }
//        BinaryHeap.upAdjust(array)
        // 循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶
        for (i in array.size - 1 downTo 1) {
            // 最后一个元素和第一个元素交换
            val tmp = array[i]
            array[i] = array[0]
            array[0] = tmp
            // 下沉调整最大堆
            downAdjust(array, 0, i, false)
        }
    }

    // “下沉”调整 （删除节点）
    // isMax true 最大堆 false 最小堆
    private fun downAdjust(array: IntArray, index: Int, length: Int, isMax: Boolean) {
        var parentIndex = index
        var temp = array[parentIndex]
        var childIndex = 2 * parentIndex + 1
        while (childIndex < length) {
            if (isMax) {
                if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                    childIndex++
                }
                if (temp >= array[childIndex]) {
                    break
                }
            } else {
                if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                    childIndex++
                }
                if (temp <= array[childIndex]) {
                    break
                }
            }

            array[parentIndex] = array[childIndex]
            parentIndex = childIndex
            childIndex = 2 * childIndex + 1
        }
        array[parentIndex] = temp
    }
}