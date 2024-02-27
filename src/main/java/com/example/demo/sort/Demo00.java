package com.example.demo.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jl.yao
 * @className Demo00
 * @description 排序合集
 * @date 2024/2/19 13:50
 **/
public class Demo00 {

//    private int[] nums = {9,2,1,8,0,5,6,4,3,7};

    @Test
    public  void test() {
        for (int i = 0; i < 10; i++) {
            int[] arr = demo06(randomNums());
            int[] arr2 = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                arr2[j] = arr[j];
            }
            Arrays.sort(arr2);
            System.out.println(Arrays.equals(arr2,arr));

        }
    }

    private int[] randomNums(){
        int[] nums = new int[10];
        for (int i = 0; i < 10 ; i++) {
            nums[i] = (int) (Math.random() * 100);
        }
        return nums;

    }

    private void swap(int i ,int j ,int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //1.冒泡排序
    public int[] demo01(int[] nums){
        //遍历数组  选出最大的 放在数组右侧
        //共需要遍历 n-1 轮
        int length = nums.length;
        for (int i = 1 ; i < length; i++) {
            for (int j = 0 ; j < length-1; j++) {
                if (nums[j] > nums[j+1]){
                    swap(j,j+1,nums);
                }
            }
        }
        return nums;
    }

    //2.选择排序
     private int[] demo02(int[] nums){
        int len = nums.length;
        //遍历选择数组中最大的（最小的） 放在数组右侧（左侧）
         for (int i = 0; i < len - 1 ; i++) {
             //遍历 每次默认第一个为最大值
             int max = 0;
             for (int j = 0; j < len -i; j++) {
                 //比较最大值  选出最大值小标
                 if (nums[max] <  nums[j]){
                     max = j;
                 }
             }
             // 将当前最大值下标交换到对应位置
             swap(max,len-1-i,nums);
         }
         return nums;
     }


    //3.插入排序
    private int[] demo03(int[] nums){
        int len = nums.length;
        //遍历数组，初始默认数组第一位已排序，从第二位开始 ，与已排序数组比较  找到合适位置插入,数组一次向后一位
        for (int i = 1; i < len; i++) {
            int tmp = nums[i];
            //待插入下标
            int tmpIndex = i;
            int j = i;
            while (j > 0 && tmp < nums[j-1]){
                nums[j] = nums[j-1];
                tmpIndex = j -1;
                j--;
            }
            // 找到合适位置直接插入
         nums[tmpIndex] = tmp;

        }
        return nums;
    }

    //4.希尔排序（最小缩量排序）
    private int[] demo04(int[] nums){
        //将数组拆分为 gap /= 2 个组，每个组单独直接插入排序。每完成一次分组排序后 分组个数减少，分组长度增加，
        // 例如数组初始长度 10  第一次分组 10/2 = 5组（下标差值为5的为一个组） 每组两个数，第二次分组 5/2= 2 每组5个数。 第三次分组 2/2 =1 每组10个数
           //确定每次分组步长
       for (int gap = nums.length/2; gap > 0; gap /=2) {
           for (int i = gap; i < nums.length; i++) {
               int temp = nums[i];
               int j = i;
               while (j >= gap && nums[j - gap] > temp) {
                   nums[j] = nums[j - gap];
                   j -= gap;
               }
               nums[j] = temp;
           }
       }
        return nums;
    }

    //5.归并排序
    public int[] demo05(int[] nums){
        //将数组一分为二，先将左侧排序 ，再将右侧排序。最后合并。
        //使用递归，例如数组初始长度二分，知道最后一位  例如 10- 5 - 2 - 1  划分到1之后 已排序，逐层返回 即可
        return sort(0,nums.length -1  , nums);
    }
    public int[]  sort(int l , int r, int[] nums){
        if(l == r) {
            return new int[]{nums[l]};
        }
        int mid = (r - l)/2 + l;
        int[] leftNums = sort(l,mid,nums);
        int[] rightNums = sort(mid+1,r,nums);
        return merge(leftNums,rightNums);
    }
    public int[] merge(int[] leftNums , int[] rightNums){

        int[] res = new int[leftNums.length+rightNums.length];
        int a = 0;
        int b = 0;
        int index = 0;
        while (a < leftNums.length &&  b < rightNums.length){
            if (leftNums[a] < rightNums[b]){
                res[index++] = leftNums[a++];
            }else {
                res[index++] = rightNums[b++];
            }
        }
        while (a < leftNums.length){
            res[index++] = leftNums[a++];
        }
        while (b < rightNums.length){
            res[index++] = rightNums[b++];
        }
        return res;

    }

    //6.快速排序

    public int[] demo06(int[] nums){
        //快速排序随机从数组中选取一位与最后一位交换  作为标准位，
        //将大于标准位放在右侧  ，小于标准位的放在左侧
        //从数组中随机选取一位

        quickSort(0,nums.length-1,nums);
        return nums;
    }

    public void quickSort(int l ,int r,int[] nums){
        if ( l < r){
            //每次从数组中随机选出一个标准数
            int random = l + (int)(Math.random() * ( r-l +1));
            //将标准数 交换到最右侧
            swap(random , r ,nums);
            //第一次排序完成后 再次排序
            int i[] = partition(l,r,nums);
            //左侧排序
            quickSort(l,i[0]-1,nums);
            quickSort(i[0]+1,r,nums);

        }


    }

    public int[] partition(int l,int r,int[] nums){
        //先构建三个区域，小于区域 等于区域 大于区域
        //小于区域 ,初始时无任何数据
        int less = l -1;
        //大于区域 ，初始时无任何数据
        int right = r;
        //首次默认最右侧为标准数
        int tmp = nums[r];
        while ( l <= right){
            //如果当前值 大于标准值，则将数据移动至大于区域，即与大于区域左侧第一位交换，大于区域范围将扩大一位
            if (nums[l] > tmp){
                //大于区域向左扩展一位
                swap(l,right--,nums);
                //小于区域l是新交换的数据, l 不动，做下一次比较
            }else if ( nums[l] < tmp){
                //如果当前值小于标准值，则将数据移动至小于区域，即与小于区域下一位交换
                swap(l++,++less,nums);
            }else {
                //如果标准值和当前值相等 ，则 当前比较值下移，此时相等 不比较，直接比较下一位，这里没有稳定性。
                l++;
            }
        }
        //当前l== right
//        swap(right,r,nums);
        //此处位等于区域
        return new int[]{less+1,right};
    }
    //7.基数排序

    //8.堆排序

    //9.计数排序

    //10.桶排序


}
