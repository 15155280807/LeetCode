package com.example.demo.sprint;


/**
 * 来自美团
 * 小团生日收到妈妈送的两个一摸一样的数列做礼物
 * 他很开心的把玩，比不过不小心没拿稳将数列摔坏了
 * 现在他手上的来个那个数列分别为A和B，长度分别是n和m
 * 小团很想再次让这两个数列变得一样。他现在能做两种操作
 * 操作一：将一个选定数列中的某一个数a改成数b，这会花费｜b-a｜的时间
 * 操作二：选择一个数列中某个数a，将他从数列中丢掉，花费｜a｜的时间
 * 小团想知道。他最小能以多少是时间将这两个数列变得再次相同
 * 输入描述
 * 第一行两个空格隔开的正整数n和m，分别表示数列A和B的长度
 * 接下来一行n个整数，分别为A1 A2 ... An
 * 接下来一行m个整数，分别为B1 B2 ... Bm
 * 对于所有数据，1<=n,m<=2000 ,|Ai|,|Bi| <= 10000
 * 输出一行一个整数，表示花费最小时间，来使得来个那个数列相同
 */
public class Code02_ChangeToSame {


    //递归
    public static int zuo(int[] A,int ai,int[] B ,int bi){
        if (ai ==A.length && bi == B.length){
            return 0;
        }
        if (ai != A.length && bi == B.length){
            //若bi到头了，删除ai数据
            return A[ai] + zuo(A,ai+1,B,bi);
        }
        if (ai == A.length && bi != B.length){
            //若ai到头了，删除bi数据
            return B[bi] + zuo(A,ai,B,bi+1);
        }
        //若不满足上面规则，则表示ai和bi都还有数据
        //可能性1: 删掉A[ai]
        int p1 =A[ai]+zuo(A,ai+1,B,bi);
        //可能性2: 删掉B[bi]
        int p2 = B[bi] +zuo(A,ai,B,bi+1);
        //可能性3: 都删掉 （可能性3 一定小于等于可能性4  所以优化掉,可能性1和2 一样小于可能性3）
//        int p3 = A[ai]+B[ai]+zuo(A,ai+1,B,bi+1);
//        可能性4 变  A[ai] -> B[]bi or B[bi] -> A[ai]
        int p4 = Math.abs(A[ai]-B[bi])+zuo(A,ai+1,B,bi+1);

        return Math.min(p1,Math.min(p2,p4));
    }
}
