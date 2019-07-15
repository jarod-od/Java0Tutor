package by.java_intro.programming_with_classes_4.class1;
/**
 *  1.  Создайте  класс  Test1  двумя  переменными.  
 * Добавьте  метод  вывода  на  экран  и  методы  изменения  этих  переменных. 
 * Добавьте  метод, который  находит сумму значений этих переменных, и метод,  
 * который  находит  наибольшее значение из этих двух переменных. 
 */

class Test1 {
    private int var1, var2;
    public void setVar1(int var1) {
        this.var1 = var1;
    }
    public void setVar2(int var2) {
        this.var2 = var2;
    }
    public void printVars() {
        System.out.println("Var1 = " + var1 + ", var2 = " + var2);
    }

    public int getSumOfVars() {
        return var1 + var2;
    }

    public int getMaxOfVars() {
        return var1 > var2 ? var1 : var2;
    }
}