package CLASSWORK29.task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var cats =Cat.makeCats(10);
        int command =0;
        while (true) {
            try {
                Printer.print(cats);
                System.out.println("1 - to sort cats by breed");
                System.out.println("2 - to sort by name and age");
                System.out.println("3 - to delete cats of definite color");
                System.out.println("4 - to delete cats with name length that is 5 symbols ");
                System.out.print("Which command do you want to do?:");
                String c = sc.nextLine();
                command = isString(c);
                isCapableCommand(command,1);
                break;
            }catch (NumberFormatException | IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
        switch (command){
            case 1 :
                cats.sort(Cat::byBreed);
                break;
            case 2:
                cats.sort(Cat.comparatorFull);
                break;
            case 3:
                Cat.Color[] colors = {Cat.Color.TABBY, Cat.Color.SILVER, Cat.Color.GRAY,Cat.Color.PEACH, Cat.Color.GINGER, Cat.Color.TORTIE};
                int c = 0;
                while(true){
                try {
                    printColor();
                    System.out.print("Choose a color:");
                    String s = sc.nextLine();
                    c = isString(s);
                    isCapableCommand(c,2);
                    break;
                }catch (NumberFormatException | IndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                }
                }System.out.println(colors[c - 1]);
                for (int i = 0; i < cats.size(); i++) {
                    if(cats.get(i).getColor().name().equals(colors[c-1].name())){
                        Cat cat1 = cats.get(i);
                        cats.removeIf(cat1::byColor);
                    }
                }

                break;
            case 4:
                for(int i = 0;i < cats.size();i++){
                    cats.removeIf(cats.get(i)::byLength);
                }
                break;
        }
        Printer.print(cats);
        // А сюда добавьте код, который будет сортировать коллекцию котов
        // используйте лямбда-выражения и ссылки на методы
        //cats.sort(?);
        //Printer.print(cats);
    }

    static int isCapableCommand(int num, int n) throws IndexOutOfBoundsException{
        if(n == 1) {
            if (num < 1 || num > 4) {
                throw new IndexOutOfBoundsException("Choose a correct command!!!");
            } else {
                return num;
            }
        }else{
            if (num < 1 || num > 6) {
                throw new IndexOutOfBoundsException("Choose a correct color!!!");
            } else {
                return num;
            }
        }
    }

    static int isString(String s) throws NumberFormatException{
        try {
            int num = Integer.parseInt(s);
            return num;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It has to number!!!");
        }
    }
    static void printColor(){
//        TABBY, SILVER, GRAY, PEACH, GINGER, TORTIE
        System.out.println("1 - Tabby cats");
        System.out.println("2 - Silver cats");
        System.out.println("3 - Gray cats");
        System.out.println("4 - Peach cats");
        System.out.println("5 - Ginger cats");
        System.out.println("6 - Tortie cats");
    }



}
