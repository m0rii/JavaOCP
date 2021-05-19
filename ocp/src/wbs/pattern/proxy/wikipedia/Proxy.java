package wbs.pattern.proxy.wikipedia;

public class Proxy implements Subject{
	// RealSubject realsubject = new RealSubject();
	  private Subject subject;

      public Proxy(Subject subject) {
              this.subject = subject;
      }
	
	@Override
	public void operation() {
		  System.out.println("i am delegating");
		  subject.operation();
    	//  realsubject.operation();
	}

}
