package wbs.pattern.proxy.wikipedia;

public class Client {

	public static void main(String[] args) {
		RealSubject realsubject = new RealSubject();
		Proxy proxy = new Proxy(realsubject);
		proxy.operation();
	//Subject subject = new Proxy();
	//subject.operation();
	}

}
