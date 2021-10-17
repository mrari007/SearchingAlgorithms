import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchingAlgorithms {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            String searchingChoice = "";
            int wantedEl = 0;           //the element the user will specify that the array will be searched for
            int index = -1;             //the index of the searched element
            int [] myArray = new int[500];
            for(int i = 0; i <myArray.length; i++){
            myArray[i] = random.nextInt(500 - 1) + 1;;
            }
            //input validation for the first user input
            do{
                System.out.println("What type of search do you want to use? Type 's' for sequential or 'b' for binary");
                searchingChoice = scanner.nextLine();
            } while(!(searchingChoice.equalsIgnoreCase("b") || searchingChoice.equalsIgnoreCase("s")));

        //input validation for the second user input
        do {
            System.out.println("Type the number you are looking for. It should be between 1 and 500");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            wantedEl = scanner.nextInt();
        } while (wantedEl <= 0 || wantedEl > 500);

        //use binary or sequential search depending on the first user input
        if(searchingChoice.equalsIgnoreCase("s")) {
            index = sequentialSearch(myArray, wantedEl);
        } else {
            //sorting the array in order to be able to use binary search
            Arrays.sort(myArray);
            index = binarySearch(myArray, 0, myArray.length - 1, wantedEl);
        }
        //printing depending whether the element is in the array or not
        if(index < 0) {
            System.out.println("The array does not contain the element");
        } else {
            System.out.println("The element was found at position: " + index);
        }
    }

    /**
     *
     * @param arr
     * @param bottom the beginning of the current array
     * @param top the end of the current array
     * @param a the element I am looking for
     * @return the index of the element if the element is found in the array or -1 if it isn't
     */
    public static int binarySearch (int [] arr, int bottom, int top, int a) {
        if (top >= bottom){
            int middle = bottom + (top-bottom) / 2;
            if(arr[middle] == a){
                return middle;
            } else if(arr[middle] > a){
                return binarySearch(arr, bottom, middle - 1, a);
            } else {
                return binarySearch(arr, middle + 1, top, a);
            }
        }
        return -1;
    }

    /**
     *
     * @param arr
     * @param a the element I am looking for
     * @return the index of the element if the element is found in the array or -1 if it isn't
     */
    public static int sequentialSearch (int [] arr, int a) {
        for(int i =0; i< arr.length; i ++){
            if(arr[i] == a){
                return i;
            }
        }
        return -1;
    }
}

