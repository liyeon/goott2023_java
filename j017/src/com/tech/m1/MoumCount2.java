package com.tech.m1;


import java.util.Scanner;

public class MoumCount2 {

   public static void main(String[] args) {
      int cntchar=0;
      int cnt=0;
      Scanner user=new Scanner(System.in);
      System.out.println("영어 단어 쳐보실래요? ");
      String msg = user.next();
      System.out.println(msg);
      char[] changemsg = msg.toCharArray();
   
      for (int i = 0; i < changemsg.length; i++) {
         cnt=msg.charAt(i);

         if (cnt==65 || cnt==69 || cnt==73 || cnt==79|| cnt==85
         || cnt==97|| cnt==101|| cnt==105|| cnt==111|| cnt==117) {
            cntchar++;
         }
      }
   
         System.out.println("이 단어의 모음의 갯수 : "+cntchar);   
       

   }
}