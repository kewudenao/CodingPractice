package swordOffer;

class findNumberIn2DArray {
    // 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    // 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    //  思路 将矩阵向左旋转四十五度 则对于matrix[0][matrix.length-1]来说 向左则元素变小 向右则元素变大

    public boolean methodOne(int[][] matrix, int target) {
        int i = matrix.length-1 ; int j =0 ;
        while(i>=0&&j<matrix[0].length){
            if(matrix[i][j]>target) i--;
            else if(matrix[i][j]<target) j++;
            else return true;
        }
        return false;
    }
}