package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //完成一个中缀表达式转成后缀表达式的功能
        //说明
        //1.  1+((2+3)*4)-5 => 转成 1 2 3 + 4 × + 5 -
        //2.  因为直接对str进行操作，不方便，因此先将"1+((2+3)*4)-5"中缀的表达式对应的List
        //  即”1+((2+3)*4)-5“ =>ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式转换成后缀表达式


        String expression = "1+((2+3)*4)-5";
        List<String> expressionList = toInfixExpressionList(expression);
        System.out.println(expressionList);
        List<String> infixToPostExp = infixToPostExp(expressionList);
        System.out.println(infixToPostExp);


        //先定义一个逆波兰表达式
        //(3+4)×5-6=>3 4 + 5 × 6 -
        //说明为了方便，逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "30 4 + 5 × 6 - ";
        //思路
        //1.先将"3 4 + 5 × 6 - " => 放在ArrayList中
        //2.将ArrayList传递给一个方法，遍历ArrayList配合栈 完成计算
        List<String> string = getListString(suffixExpression);
       //System.out.println(string);

        int res = calculate(string);
        System.out.println(res);
    }



    //将中缀表达式转换成后缀表达式
    public static List<String> infixToPostExp(List<String> List){
        Stack<String> s1 = new Stack<String>(); //运算符存放栈s1
        List<String> s2 = new ArrayList<String>();//存储中间结果栈s2
        for (String item : List) {
            if(item.matches("\\d+")){
                //入栈
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")) {
                //如果是右括号”）“，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号位置，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//!!!将(弹出s1栈，消除小括号
            }else {
                //如果是右括号")",则依次弹出s1栈顶的运算符弹出并加入到s2中，再次转到（4.1）与s1中新的栈顶运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                while (s1.size()!=0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;//注意因为是存放到List,因此按顺序输出就是对应的后缀表达式对应的List
    }


    //方法：将中缀表达式转换成对应的list
    public static List<String> toInfixExpressionList(String expression){
        //定义一个List，存放中缀表达式对应的内容
        ArrayList<String> list = new ArrayList<>();
        int i = 0;//相当于一个指针，用于遍历中缀表达式字符串
      String str;//用于多位数的拼接
       //StringBuilder sb = new StringBuilder();//用于多位数的拼接
        char c;//遍历到一个字符，放入c中然后存入集合中

        while (i < expression.length()){
            if ((c=expression.charAt(i))<48||(c=expression.charAt(i))>57){
                list.add(""+c);
                i++;
            }else {
                str = "";
               // sb=null;
              while (i<expression.length()&&(c=expression.charAt(i))>=48 && (c=expression.charAt(i))<=57){
                str += c;
                  i++;
              }
              list.add(str);
            }
        }

        return list;
    }



    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
       return list;
    }

    //完成对逆波兰表达式的运算
    /**
     * 1.从左至右扫描，将3和4压入堆栈
     * 遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得到7，再将7入栈；
     * 将5入栈；
     * 接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
     * 将6入栈；
     * 最后是-运算符，计算出35-6的值，即29，由此得出结果
     */
    public static int calculate(List<String> list){
        //创建一个栈
        Stack<String> stack = new Stack<>();


        //遍历list
        for (String item : list) {
            //这里使用正则表达式来取数
            if(item.matches("\\d+")){//匹配的是多位数
                //入栈
                stack.push(item);
            }else {
                //pop出两个数，并运算，在入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res =0;
                switch (item){
                    case "+":
                        res=num1+num2;
                        break;
                    case "-":
                        if(num1>num2){
                            res = num1-num2;
                            break;
                        }else {
                            res=num2-num1;
                            break;
                        }
                    case "×":
                        res=num1*num2;
                        break;
                    case "/":
                        if(num1>num2){
                            res = num1/num2;
                            break;
                        }else {
                            res=num2/num1;
                            break;
                        }
                    default:
                        System.out.println("出错了~~~，请仔细检查");
                        break;
                }

             stack.push(""+res);
            }


        }


       return Integer.parseInt(stack.pop()) ;

    }


}
//编写一个类Operation 可以返回一个运算符对应的优先级
class Operation{
    private static int ADD =1;
    private static int SUB =1;
    private static int MUL =2;
    private static int DIV =2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
            default:
                System.out.println("对不起，您输入的运算符不对");
                break;

        }
        return result;
    }

}
