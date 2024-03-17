package com.example.abc.test._lambda;


interface Col{
    int countXY(int x , int y);
}
public class Lam3 {
    public static void main(String[] args) {
        //a.
        Col col1 = (x,y) -> //{
         /*return*/ x+y
        //}
        ;

        //b.
        Col col2 = (x,y) -> Lam3.zzz(x, y);

        //c.
        Col col3 = Lam3::zzz; //改b.    因為兩邊參數都是兩個

    }

    public static int zzz(int qwer , int asdf){
        return qwer - asdf;
    }

}
