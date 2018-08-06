	class Overriding extends Car {
		void run()
		{
		System.out.println("Audi is running safely with 100km");
		}
		public static void main(String args[])
		{
		Car b= new Overriding();    //upcasting
		b.run();
		}
		}
