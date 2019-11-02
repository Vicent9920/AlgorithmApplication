package com.vincent.algorithmapplication.data_structure

/**
 * <p>文件描述：优先队列的实现<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/10/31 0027 <p>
 * <p>@update 2019/10/31 0027<p>
 * <p>版本号：1<p>
 *
 */
class PriorityQueue {
    // 默认长度
    private var array = IntArray(16)
    private var size = 0

    // 入队
    fun enQueue(value: Int) {
        // 判断是否需要扩容
        if (size >= array.size) {
            reSize()
        }
        array[size++] = value
        upAdjust()
    }

    // 出队
    fun deQueue(): Int {
        if (size == 0) {
            throw Exception("the array is empty")
        }
        // 获取对顶元素
        val first = array.first()
        // 最后一个元素移到堆顶
        array[0] = array[--size]
        downAdjust()
        return first
    }

    // 队列扩容
    private fun reSize() {
        this.array = array.copyOf(2 * size)
    }

    // “上浮”调整
    private fun upAdjust() {
        var childIndex = size - 1
        var parentIndex = (childIndex - 1) / 2
        // 临时保存
        val temp = array[childIndex]
        while (childIndex > 0 && temp > array[parentIndex]) {
            // 赋值
            array[childIndex] = array[parentIndex]
            childIndex = parentIndex
            parentIndex /= 2
        }
        array[childIndex] = temp
    }

    // “下沉”调整
    private fun downAdjust() {
        var parentIndex = 0
        // 保存根节点的值
        val temp = array.first()
        var childIndex = 1
        while (childIndex < size) {
            // 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++
            }
            // 如果父节点大于子节点的值，跳出循环
            if (temp >= array[childIndex]) {
                break
            }
            // 赋值
            array[parentIndex] = array[childIndex]
            parentIndex = childIndex
            childIndex = 2 * childIndex + 1
        }
        array[parentIndex] = temp
    }
}