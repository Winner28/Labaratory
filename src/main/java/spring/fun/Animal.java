package spring.fun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
@Data
public class Animal {

    private String name;
    private int age;
    private static int fage;

    public void setName(String name) {
        this.name = name;
     }

    class TypoWord {

        private int value;

         TypoWord(int value, String newName) {
            this.value = value;
            Animal.this.setName(newName);
        }

        public void sayValueAndName() {
            System.out.println(this.value + "and name " + Animal.this.getName());
        }

        protected void h() {
            System.out.println("h1");
        }
    }

    @AllArgsConstructor
    static class TypoStatic {
        private int a;

        public int getA() {
            int fage = Animal.fage;
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
       int []input = {9, 4, 10, 8, 2, 4};
       int max = 10;
       int []count = new int[max + 1];
       for (int i = 0; i < input.length; i++) {
           count[input[i]]++;
       }

       for (int i = 1; i < count.length; i++) {
           count[i] = count[i] + count[i - 1];
       }

       int result [] = new int[input.length];
       for (int i = 0; i < input.length; i++) {
           result[count[input[i]]--] = input[i];
           //count[input[i]]--;
       }

       Algos.print(result);



    }
}
