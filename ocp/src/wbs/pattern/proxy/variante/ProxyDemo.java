package wbs.pattern.proxy.variante;

public class ProxyDemo {
	
	/*
	 * was versteht man in der software-entwicklung unter
einer factory?
wo haben wir hier lose kopplung?  proxydemo und Iservise loose copling
        wie könnte ein klassendiagramm zu diesem code aussehen
     (bitte skizze auf papier...)

          gibt es eine has a beziehung zwischen ProxyFactory
      und IService? es kommt daraf an?
      
         gibt es eine is a beziehung zwischen ProxyFactory
         und IService?  ?
         
        gibt es eine assoziation zwischen ProxyFactory
          und IService? ja
          
         was w e i s s der client (hier: ProxyDemo)?
         
         was könnte der "extra stuff" sein?
         
         
	 */
	
	// loose coupling and hight Cohesion
	
	// proxydemo und Iservise loose copling
	// proxydemo und servisce proxy loose couipling

	// der client des angebotenen dienstes (IService) ist hier die demo-klasse.
	// der client kennt die service-implementierung nicht! (lose kopplung)
	// der client weiss auch nicht, dass er mit einem proxy für die
	// service implementierung arbeitet!

	// die entkopplung des clients von der service-implementierung wird hier duch
	// den
	// einsatz einer Factory (ProxyFactory) ermöglicht.
	public static void main(String[] args) {
		IService service = ProxyFactory.getService();
		service.m();
	}
}