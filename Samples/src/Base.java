
class Base {
private static void display() {
System.out.println("Static or class method from Base");
}
public void print() {
System.out.println("Non-static or instance method from Base");
}
public static void main(String args[])
{
Base obj= new Derived();
obj.display();
obj.print();
}
}