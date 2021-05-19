package wbs.pattern.proxy.variante;

public class ProxyFactory {
	public static IService getService() {
		// die proxy-factory könnte hier zum beispiel den erzeugungsprozess
		// für die service-implementierungen und deren proxies optimieren!
		// z.b. durch die verwaltung von pools von objekten...
		IService service = new ServiceImpl();
		IService proxy = new ServiceProxy(service);
		return proxy;
	}
}
