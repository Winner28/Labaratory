package spring.fun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

        public TypoWord(int value, String newName) {
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
}
