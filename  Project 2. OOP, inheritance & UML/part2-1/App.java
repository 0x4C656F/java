
// THIS IS PART 2.1
public class App {
    public static void main(String[] args) throws Exception {
        SubClass subClassInstance = new SubClass();
        SuperClass a = new SubClass();
        System.out.println(a.getClass());
        a.overloadedMethod();
        a.overloadedMethod("Hello");
        subClassInstance.overloadedMethod(10);
        a.printClass();
    }
}

abstract class MyAbstractClass {
    public abstract void myAbstractMethod();
}

class SuperClass extends MyAbstractClass {
    private int privateVar;
    protected int protectedVar;
    public int publicVar;

    public SuperClass() {}

    public SuperClass(int var) {
        this.protectedVar = var;
    }

    public void printClass() {
        System.out.println("SuperClass");
    }

    public void myAbstractMethod() {
        System.out.println("Abstract method implemented in SuperClass");
    }

    public void overloadedMethod() {
        System.out.println("Overloaded method in SuperClass");
    }

    public void overloadedMethod(String arg) {
        System.out.println("Overloaded method in SuperClass with argument: " + arg);
    }
}

class SubClass extends SuperClass {
    public SubClass() {
        super();
    }

    public SubClass(int var) {
        super(var);
    }

    @Override
    public void printClass() {
        super.printClass();
        System.out.println("SubClass");
    }

    public void overloadedMethod(int arg) {
        System.out.println("Overloaded method in SubClass with int argument: " + arg);
    }
}
