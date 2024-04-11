/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab09;

/**
 *
 * @author 13476
 */
public class Lab09 {
/*    
ToDo 01:  Write an algorithm to solve the following problem

The sequence of triangle numbers is generated by adding the natural numbers. 
So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

1: 1
3: 1,3
6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28
We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over one hundred divisors?
*/
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 7;
                
        int triNum = triangleNumber(n);
        
        System.out.println("Triangle number " + n + " is " + triNum);
        
        printFactors(triNum, triNum, 0);
        
        System.out.println(triNum + " has " + numFactors(triNum,triNum,0) +  " divisors");
                
        System.out.println(isTriNum(11));
      
        //works for 1 and 6 
        System.out.println(findTriNum(1)); 
        //System.out.println(findTriNum(100)); //results in stack overflow


        
    }
    
    public static int findTriNum(int d){
        int triNum = triangleNumber(1);
        
        while (!isTriNum(triNum) || numFactors(triNum,triNum, 0)!= d){
            ++triNum;
        }
        return triNum;   
    }
    
    public static boolean isTriNum(int n){
        int sum = 0;
        int count = 1;
        while(sum < n){
            sum += count;
            ++count;
            if(sum == n){return true;}
        }
        return false;
    }
    
    public static int triangleNumber(int n){
        if(n==1){
            return 1;
        }
        else{
            return n + triangleNumber(n-1);
        }
    }
    
    public static void printFactors(int n, int d, int c){
        if(d==1){
            ++c;
            System.out.println(d + " ");
        }
        else{
            if(n%d==0){
                ++c;
                System.out.print(d + " ");
            }
            printFactors(n, d-1, c);
        }
    }
    
    public static int numFactors(int n, int d, int c){
        if(d==1){
            return ++c;
        }
        else{
            if(n%d==0){
                ++c;
            }
            return numFactors(n, d-1, c);
        }
    }
    
}
