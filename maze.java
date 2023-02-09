public class maze {
    public static void main(String[] args){
        //用二维数组表述迷宫的地图，其中0表示空，1表示有障碍物
        int[][] map=new int[8][7];
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for(int i=1;i<7;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        map[2][2]=1;

        //显示地图
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++)
                System.out.print(map[i][j]+" ");
            System.out.println();
        }
        M m=new M();
        m.findway(map,1,1);
        System.out.println("way to maze:");
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++)
                System.out.print(map[i][j]+" ");
            System.out.println();
        }
    }
}

class M{
    //递归回溯的方法找路 找到路返回true 找不到返回false
    //i j 表示老鼠的位置 初始位置为[1,1]
    //※※递归找路 先定义map数组各个值的含义
    //0--还没走 但可以走 1--障碍物 2--走过 可以走 3--走过 走不通
    //当map[6][5]=2时，表示成功找到路了true
    //找路的策略：下-右-上-左
    //另一个策略：右-下-左-上
    public boolean findway(int[][]map,int i,int j){
        if(map[6][5]==2) return true;
        else{
            if(map[i][j]==0){
                //先假定能走通
                map[i][j]=2;
                if(findway(map,i+1,j))
                    return true;
                else if(findway(map,i,j+1))
                    return true;
                else if(findway(map,i-1,j))
                    return true;
                else if(findway(map,i,j-1))
                   return true;
                /*if(findway(map,i,j+1))
                    return true;
                else if(findway(map,i+1,j))
                    return true;
                else if(findway(map,i,j-1))
                    return true;
                else if(findway(map,i-1,j))
                    return true;*/
                else {
                    map[i][j]=3;
                    return false;
                }
            }
            else{//map[i][j]=1,2,3  2的情况是又回到之前走过的地方认为false
                return false;
            }
        }
    }

}


