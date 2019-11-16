package com.vincent.algorithmapplication


import android.util.LruCache
import com.vincent.algorithmapplication.sample.LRUCache
import com.vincent.algorithmapplication.sample.Maze
import com.vincent.algorithmapplication.sample.Money
import com.vincent.algorithmapplication.sample.MyBitmap
import org.junit.Test

/**
 * <p>文件描述：算法的实际应用<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/14 0014 <p>
 * <p>@update 2019/11/14 0014<p>
 * <p>版本号：1<p>
 *
 */
class Sample {

    // 测试位图算法
    @Test
    fun testBitmap() {
        // 存储长度
        val bmp = MyBitmap(128)
//        // 存入标签
//        bmp.setBit(126)
//        // 存入标签
//        bmp.setBit(75)
//        // 存入标签
//        bmp.setBit(64)
//        bmp.setBit(0)
//        // 查询标签
//        println(bmp.getBit(126))
//        // 查询标签
//        println(bmp.getBit(78))
//        println(bmp.getBit(0))
        LruCache<Int,String>(24)
        val array = intArrayOf(2,8,56,72,96,120,48,56,72)

        for (i in array){
            if(!bmp.getBit(i)){
                bmp.setBit(i)
            }else{
                println("数组重复：$i")

            }
        }
    }

    // 测试LRU缓存
    @Test
    fun testLruCache(){
        val cache = LRUCache(5)
        cache.putValue(1,"11")
        cache.putValue(2,"22")
        cache.putValue(3,"33")
        cache.putValue(4,"44")
        cache.putValue(5,"55")
        cache.putValue(6,"66")
        cache.getValue(3)
        cache.putValue(7,"77")
        cache.getValue(5)
        cache.putValue(8,"88")
        cache.putValue(9,"99")
        println(cache.toString())
    }

    @Test
    fun testMaze(){
        val start = Maze.Grid(2,1)
        val end = Maze.Grid(2,5)
        var resultGrid = Maze.aStarSearch(start, end)
        val path = mutableListOf<Maze.Grid>()
        while (resultGrid != null){
            path.add(Maze.Grid(resultGrid.x,resultGrid.y))
            resultGrid = resultGrid.parent
        }
        for (i in Maze.gridList.indices){
            for (j in Maze.gridList[i].indices){
                if(Maze.containGrid(path,i,j)){
                    print("*, ")
                }else{
                    print("${Maze.gridList[i][j]}, ")
                }
            }
        }
    }

    // 红包拆分
    @Test
    fun testMoney(){
        val result = Money.sendMoney(5,10)
        print(result.toString())
    }

}