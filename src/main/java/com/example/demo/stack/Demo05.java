package com.example.demo.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * @author jl.yao
 * @className Demo05
 * @description 汉诺塔问题
 * @date 2021/7/1 18:56
 **/
@Slf4j
public class Demo05 {


    /**
     * 需求：在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
     * (1) 每次只能移动一个盘子;
     * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
     * (3) 盘子只能叠在比它大的盘子上。
     *
     * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
     *
     * 你需要原地修改栈。
     *
     * 示例1:
     *
     *  输入：A = [2, 1, 0], B = [], C = []
     *  输出：C = [2, 1, 0]
     * 示例2:
     *
     *  输入：A = [1, 0], B = [], C = []
     *  输出：C = [1, 0]
     * 提示:
     *
     * A中盘子的数目不大于14个。

     */


    @Test
    public void test(){

    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    // 将N个圆盘从A柱经由B柱移动到C柱
    void move(int N, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (N == 1) {
            // 直接将A柱的圆盘移动到C柱
            C.add(0, A.remove(0));
            return;
        }

        //将n分为 n 和n-1
        //第一步 将a柱子上的从上到下n-1个盘移到b柱子上
        move(N - 1, A, C, B);
        C.add(0, A.remove(0));
        //将b柱子上的n-1个盘子移到c柱子上
        move(N - 1, B, A, C);
    }



}
