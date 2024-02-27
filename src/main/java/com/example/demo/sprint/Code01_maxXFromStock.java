package com.example.demo.sprint;


/**
 * 来自神策
 * 给定一个数组arr，表示连续n天的股价，数组下标表示第几天
 * 指定x标：任意两天的股价之和-此两天间隔的天数
 * 比如
 * 第三天，价格是10
 * 第九天，价格是30
 * 那么第3天和第9天的指标x= 10+30-（9-3）=34
 * 那么返回arr中最大的指标x
 * 时间复杂度O（N）
 */
public class Code01_maxXFromStock {


    // arr[i]+arr[j] -(j-i) > arr[i]+i + arr[j]-j
    public static int maxX(int[] arr){
        if (null == arr || arr.length<2){
            return -1;
        }
        int preBest = arr[0];
        int ans =0;
        for (int i = 1; i < arr.length; i++) {
            ans = Math.max(ans,arr[i]-i+preBest);
            preBest = Math.max(preBest,arr[i]+i);
        }
        return ans;
    }
}
