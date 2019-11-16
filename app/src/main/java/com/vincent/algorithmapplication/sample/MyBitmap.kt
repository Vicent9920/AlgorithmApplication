package com.vincent.algorithmapplication.sample

/**
 * <p>文件描述：位图算法实现<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/13 0013 <p>
 * <p>@update 2019/11/13 0013<p>
 * <p>版本号：1<p>
 *
 */
class MyBitmap(var size: Int) {
    private var words: LongArray
    private val num: Long = 1L

    init {
        words = LongArray(getWordIndex(size - 1) + 1)
    }

    // 查询标签
    fun getBit(bitIndex: Int): Boolean {

        if (bitIndex < 0 || bitIndex >= size) {
            throw IndexOutOfBoundsException("超过Bitmap有效范围")
        }
        val wordIndex = getWordIndex(bitIndex)
        return (words[wordIndex] and num.shl(bitIndex)) != 0L

    }

    // 保存标签
    fun setBit(bitIndex: Int) {
        if (bitIndex < 0 || bitIndex >= size) {
            throw IndexOutOfBoundsException("超过Bitmap有效范围")
        }
        val wordIndex = getWordIndex(bitIndex)
        words[wordIndex] = words[wordIndex] or num.shl(bitIndex)
    }

    // 标签位置
    private fun getWordIndex(bitIndex: Int): Int {
        return bitIndex.shr(6)
    }

}