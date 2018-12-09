package chapter01.stack;

import java.util.Stack;

/**
 * @author: 蒋泽恩
 * @date: 2018/10/18 17:30
 * @description: 测试Stack
 */
public class TestStack {
    public static void main(String[] args) {
        FixedCapacityStack stack = new FixedCapacityStack(100);
        System.out.println(stack.isEmpty());
        stack.push("to");
        stack.push("be");
        stack.push("or");
        stack.pop();
        System.out.println(stack.size());
        while(!stack.isEmpty()){
            System.out.print(stack.pop() +"\t");
        }
    }
}
