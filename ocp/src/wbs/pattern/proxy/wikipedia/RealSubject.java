package wbs.pattern.proxy.wikipedia;

public class RealSubject implements Subject{

	@Override
	public void operation() {
		System.out.println(" operation von RealSubjekt");	
	}

}
