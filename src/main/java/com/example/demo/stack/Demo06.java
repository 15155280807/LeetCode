package com.example.demo.stack;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jl.yao
 * @className Demo06
 * @description 堆盘子
 * @date 2021/7/1 19:43
 **/
@Slf4j
public class Demo06 {


    /**
     * 需求：堆盘子。设想有一堆盘子，堆太高可能会倒下来。
     * 因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。
     * 请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。
     * 此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。
     * 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
     *
     * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
     *
     * 示例1:
     *
     *  输入：
     * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
     * [[1], [1], [2], [1], [], []]
     *  输出：
     * [null, null, null, 2, 1, -1]
     * 示例2:
     *
     *  输入：
     * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
     * [[2], [1], [2], [3], [0], [0], [0]]
     *  输出：
     * [null, null, null, null, 2, 1, 3]
     *

     */

    @Test
    public void test(){
//todo
    }



    class StackOfPlates {

        private List<Stack<Integer>> list;
        private int cap;



        public StackOfPlates(int cap) {
            list = new ArrayList<>();
            this.cap= cap;

        }

        public void push(int val) {
            if (cap <= 0 ){
                return;
            }
            if (list.isEmpty()){
                //如果当前没有栈 新建栈
                list.add(new Stack<Integer>());
            }
            //如果当前最近的栈满，则需要新建栈
            if (list.get(list.size()-1).size() >= cap){
                list.add(new Stack<>());
            }
            //再取最近的栈push
            Stack<Integer> stack = list.get(list.size() - 1);
            stack.push(val);
        }

        public int pop(){
            // 如果当前没有栈
            if (list.isEmpty()) {
                return -1;
            }
            // 弹出
            Stack<Integer> stack = list.get(list.size() - 1);
            int val = stack.pop();
            // 如果栈空则要删除栈
            if (stack.isEmpty()) {
                list.remove(list.size() - 1);
            }
            return val;
        }


        public int popAt(int index) {
            // 如果索引不在栈表内
            if(list.size() <= 0 || index > list.size() - 1) {
                return  -1;
            }
            // 弹出
            Stack<Integer> stack = list.get(index);
            Integer pop = stack.pop();
            // 若为空栈则删除
            if(stack.isEmpty()) {
                this.list.remove(index);
            }
            return pop;

        }
    }

}
