package finalLab;

import java.util.Scanner;
import java.util.ArrayList;

public class UserIDSorting {
   // TODO: Write the partitioning algorithm - pick the middle element as the
   // pivot, compare the values using two index variables l and h (low and high),
   // initialized to the left and right sides of the current elements being sorted,
   // and determine if a swap is necessary
   public static int partition(ArrayList<String> userIDs, int i, int k) {
       String piv = userIDs.get(k);
       int index = (i - 1);
       for (int j = i; j < k; j++) {

           if (userIDs.get(j).compareTo(piv) <= 0) {
               index++;

               String temp = userIDs.get(index);
               userIDs.set(index, userIDs.get(j));
               userIDs.set(j, temp);
           }
       }

       String temp = userIDs.get(index+1);
       userIDs.set(index+1, userIDs.get(k));
       userIDs.set(k, temp);

       return index + 1;

   }

   // TODO: Write the quicksort algorithm that recursively sorts the low and
   // high partitions
   public static void quicksort(ArrayList<String> userIDs, int i, int k) {
       if (i < k) {
           int pi = partition(userIDs, i, k);
           quicksort(userIDs, i, pi - 1);
           quicksort(userIDs, pi + 1, k);
       }
   }

   public static void main(String[] args) {
       Scanner scnr = new Scanner(System.in);

       ArrayList<String> userIDList = new ArrayList<String>();

       String userID;

       userID = scnr.next();
       while (!userID.equals("-1")) {
           userIDList.add(userID);
           userID = scnr.next();
       }

       // Initial call to quicksort
       quicksort(userIDList, 0, userIDList.size() - 1);

       for (int i = 0; i < userIDList.size(); ++i) {
           System.out.println(userIDList.get(i));
       }
   }
}