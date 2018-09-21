/*
    Odwa Ntloko
    21 September 2018
    ntlokodwa@gmail.com
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class ReverseList{
    //Method to reverse all the elements in a list, used by nodeReversal()
    public static List<Integer> reverse(List<Integer> l){
        List<Integer> rev = new LinkedList<>();
        int n = l.size();
        for(int i = 0; i < n/2; i++){
            rev.add(i, l.get(((n-1)-i)));
        }
        for(int i = n/2; i < n; i++){
            rev.add(l.get(((n-1)-i)));
        }
        return rev;
    }

    //method that reverse elements of even list by grouping them into nodes of n/2
    public static List<Integer> evenReversal(List<Integer> l){
        List<Integer> revList = new LinkedList<>(); //new linkedList obj to store resulting list

        revList = reverse(l.subList(0, (l.size()/2))); //reverse first half of list
        revList.addAll(reverse(l.subList((l.size()/2), l.size()))); //add collection of second half of reversed list
        
        return revList;
    }

    //method that reverse elements of odd list by grouping them into nodes of n/2
    public static List<Integer> oddReversal(List<Integer> l){
        List<Integer> revList = new LinkedList<>(); //new linkedList obj to store resulting list
        int mid = l.size()/2; //index of the middle element

        revList = reverse(l.subList(0, mid)); //reverse first half of list
        revList.add(l.get(mid)); //keep the position of the middle digit as is
        revList.addAll(reverse(l.subList(mid+1, l.size()))); //add collection of second half of reversed list
        
        return revList;
    }
    
    //method to display the elements in the list
    public static void printList(List<Integer> list){
        for(Integer i: list){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //main method
    public static void main(String[]args){
        List<Integer> ll = new LinkedList<Integer>(); //linked list to store elements in
        
        System.out.println("Enter values to add into list, separated by spaces. eg: [1 2 3 4 etc.]");
        Scanner sc = new Scanner(System.in);
        
        String line = sc.nextLine(); 
        
        //user input stored in array
        String[] array = line.split(" ");

        //adding elements String array into Integer linkedList 
        for(int i = 0; i < array.length; i++){
            ll.add(Integer.parseInt(array[i]));
        }
        sc.close();
        System.out.println(5/2);
        //Display modified list to user
        if( ll.size() % 2 == 0){
            printList(evenReversal(ll));
        }else{
            printList(oddReversal(ll));
        }
       
        
    }
}