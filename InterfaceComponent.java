package decorator;

// Цель - Динамическсое добавление новых обязностей

//Для чего используеться - Используеться в качестве альтернативы порождению подклассов для расширения функциональности

public interface InterfaceComponent {
	void doOperation();
}

class MainComponent implements InterfaceComponent {
	
	@Override
	public void doOperation() {
		System.out.print("World!");
	}	
}

abstract class Decorator implements InterfaceComponent {
	protected InterfaceComponent component;
	
	public Decorator (InterfaceComponent c) {
		component = c;
	}
	
	@Override
	public void doOperation() {
		component.doOperation();
	}

	public void newOperation() {
		System.out.println("Do Nothing");
	}
}

class DecoratorSpace extends Decorator {
	
	public DecoratorSpace(InterfaceComponent c) {
		super(c);
	}
	
	@Override
	public void doOperation() {
		System.out.print(" ");
		super.doOperation();
	}
	
	@Override
	public void newOperation() {
		System.out.println("New space operation");
	}
}

class DecoratorComma extends Decorator {

	public DecoratorComma(InterfaceComponent c) {
		super(c);
	}
	
	@Override
	public void doOperation() {
		System.out.print(",");
		super.doOperation();
	}	
        
	@Override
	public void newOperation() {
		System.out.println("New comma operation");
	}
}

class DecoratorHello extends Decorator {
	
	public DecoratorHello(InterfaceComponent c) {
		super(c);
	}
	
	@Override
	public void doOperation() {
		System.out.print("Hello");
		super.doOperation();

	}
	
	@Override
	public void newOperation() {
		System.out.println("New hello operation");
	}
}

class Main {
	
	public static void main (String... s) {
		Decorator c = new DecoratorHello(new DecoratorComma(new DecoratorSpace(new MainComponent())));
		Decorator c2 = new DecoratorComma(new DecoratorHello(new MainComponent()));
		c2.doOperation();
		c2.newOperation();
		c.doOperation(); // Результат выполнения программы "Hello, World!"
	    c.newOperation(); // New hello operation
		InterfaceComponent interfaceComponent = new DecoratorHello(new MainComponent());
    }
}