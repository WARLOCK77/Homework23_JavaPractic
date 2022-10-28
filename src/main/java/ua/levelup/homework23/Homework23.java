package ua.levelup.homework23;

public class Homework23 {

    public static void main(String[] args) {
        System.out.println("Вычисление факториала: "+factorial(10));
        System.out.println("Количество цифр в числе: "+digitsInNumber(233665333));
        System.out.println("Наличие цифры в числе: "+symbolInNumber(123566, 7));
        System.out.println("Явлиется число полиндромом: "+palindrome(123321));
        System.out.println("Типы цыфр (чет., нечет.) в числе: "+typeDigitsInNumber(123456));
    }

    public static boolean symbolInNumber(long number, int symbol){
        boolean b=false;
        int sizeArr=digitsInNumber(number);
        int [] arr=new int[sizeArr];
        for (int i = 0; i < sizeArr; ++i) {
            arr[i] += number % 10;
            number /= 10;
        }
        for (int sym: arr){
            if(sym==symbol){
                b=true;
                break;
            }
        }
        return b;
    }

    public static int factorial(int n){
        int result=1;
        for (int i=1; i<=n; i++){
            result*=i;
        }
        return result;
    }

    public static int digitsInNumber(long number){
        int result=0;
        while (0!=number){
            ++result;
            number/=10;
        }
        return result;
    }

    public static boolean palindrome(long number){
        boolean b=false;
        int sizeArr=digitsInNumber(number);
        int [] arr=new int[sizeArr];
        int index=0;
        for (int i = 0; i < sizeArr; ++i) {
            arr[i] += number % 10;
            number /= 10;
        }
        if (sizeArr % 2 != 0) {
            System.out.print("this number is not palindrome: ");
            return false;
        }else {
            for (int i=0; i<sizeArr/2; i++){
                if (arr[index]==arr[sizeArr-index-1]){
                    ++index;
                    b=true;
                }
                else {
                    b=false;
                }
            }
        }
        return b;
    }

    public static int typeDigitsInNumber(long number){
        int pairCounter=0;
        int unpairCounter=0;
        int sizeArr=digitsInNumber(number);
        int [] arr=new int[sizeArr];
        for (int i = 0; i < sizeArr; ++i) {
            arr[i] += number % 10;
            number /= 10;
        }
        for (int symbol: arr){
            if ((symbol % 2) == 0){
                pairCounter++;
            } else {
                unpairCounter++;
            }
        }
        if (pairCounter==unpairCounter){
            return 0;
        }
        if(pairCounter<unpairCounter){
            return -1;
        } else {
            return 1;
        }
    }
}
