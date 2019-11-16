package com.vincent.algorithmapplication.sample

import kotlin.math.abs

/**
 * <p>文件描述：A 星寻路算法<p>
 * <p>@author 烤鱼<p>
 * <p>@date 2019/11/14 0014 <p>
 * <p>@update 2019/11/14 0014<p>
 * <p>版本号：1<p>
 *
 */
object Maze {
    class Grid( var x:Int,var y:Int){
        var f = 0
        var g = 0
        var h = 0
         var parent:Grid? = null

        fun initGrid(last:Grid?,end:Grid){
            this.parent = last
            if(last != null){
                this.g = last.g+1
            }else{
                this.g = 1
            }
            this.h = abs((this.x - end.x) + abs(this.y - end.y))
            this.f = this.g + this.h
        }
    }


    val gridList:Array<IntArray> = arrayOf(
        intArrayOf(0,0,0,0,0,0,0),
        intArrayOf(0,0,0,1,0,0,0),
        intArrayOf(0,0,0,1,0,0,0),
        intArrayOf(0,0,0,1,0,0,0),
        intArrayOf(0,0,0,0,0,0,0))

    fun aStarSearch(start:Grid,end:Grid):Grid?{
        val openList = mutableListOf<Grid>()
        val closeList = mutableListOf<Grid>()
        openList.add(start)
        while (openList.size > 0){
            val currentGrid = findMindGrid(openList)
            openList.remove(currentGrid)
            closeList.add(currentGrid)
            val neighbors = findNeighbors(currentGrid,openList, closeList)
            for (i in neighbors){
                if(!openList.contains(i)){
                    i.initGrid(currentGrid,end)
                    openList.add(i)
                }
            }
            for (i in openList){
                if (i.x == end.x && i.y == end.y){
                    return i
                }
            }
        }
        return null
    }

    private fun findMindGrid(openList: MutableList<Grid>): Grid {
        var tmpGrid = openList.first()
        for (grid in openList){
            if(grid.f < tmpGrid.f){
                tmpGrid = grid
            }
        }
        return tmpGrid
    }

    private fun findNeighbors(grid: Grid, openList: MutableList<Grid>, closeList:MutableList<Grid>):MutableList<Grid>{
        val result = mutableListOf<Grid>()
        if(isValidGrid(grid.x,grid.y-1,openList,closeList)){
            result.add(Grid(grid.x,grid.y-1))
        }
        if(isValidGrid(grid.x,grid.y+1,openList,closeList)){
            result.add(Grid(grid.x,grid.y+1))
        }
        if(isValidGrid(grid.x-1,grid.y,openList, closeList)){
            result.add(Grid(grid.x-1,grid.y))
        }
        if(isValidGrid(grid.x+1,grid.y,openList, closeList)){
            result.add(Grid(grid.x+1,grid.y))
        }
        return result
    }
    private fun isValidGrid(x:Int, y:Int, openList: MutableList<Grid>, closeList: MutableList<Grid>):Boolean{
        if(x < 0 || x >= gridList.size || y < 0 || y >= gridList.first().size)return false
        if(gridList[x][y] == 1)return false
        if(containGrid(openList,x, y))return false
        if(containGrid(closeList,x, y))return false
        return true
    }

     fun containGrid(grids:MutableList<Grid>, x:Int, y:Int):Boolean{
        for (n in grids){
            if(n.x == x && n.y == y){
                return true
            }
        }
        return false
    }


}