package com.example.demo;

/**
 * @author jl.yao
 * @className InsertSort
 * @description
 * @date 2021/5/8 13:41
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] array= {4,2,8,9,5,7,6,1,3};
        System.out.println("未排序数组排列：");
        display(array);
        System.out.println("------------------------------");
        sort(array);
        System.out.println("------------------------------");
        System.out.println("排序后数组排列：");
        display(array);
    }

   public static int[] sort(int[] array){
        int j;
        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
       for (int i = 0; i <array.length ; i++) {
           //记录要插入的数据
           int temp = array[i];
           j = i;
           while (j > 0 && temp < array[j-1]){
               //从已经排序的序列最右边的开始比较，找到比其小的数
               //向后挪动
               array[j] = array[j-1];
               j--;
           }
           //存在比其小的数，插入
           array[j] = temp;
           System.out.print("第"+(i+1)+"轮排序后的结果为:");
           display(array);
       }
       return array;
   }
    //遍历显示数组
    public static void display(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+"");
        }
        System.out.println();
    }

}
