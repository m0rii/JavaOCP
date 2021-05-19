package wbs.pattern.proxy.variante;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ServiceProxy implements IService {
    // ggf setter , getter , config-file
	private IService service;
	private LocalTime from = LocalTime.of(8, 0);
	private LocalTime to = LocalTime.of(12, 0);
	private LocalTime now = LocalTime.now();

	public ServiceProxy(IService service) {
		this.service = service;
	}

	@Override
	public void m() {
		if(!(now.isAfter(to) && now.isBefore(from)) ) { // 	if(now.isBefore(from) || now.isAfter(to))
			
			throw new IllegalAccessTimeException("local time is " + now.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)) + " access is only allowed between " + from + " and " + to);
		}
		System.out.println("in m() von " + getClass().getSimpleName());
		System.out.println("extra stuff from proxy before calling m() von service implementation...");
		// delegation:
		// reicht ein objekt den aufruf einer methode für dieses objekt an ein anderes
		// objekt weiter,
		// auf das es eine referenz hat, spricht man von delegation
		service.m();
		System.out.println("extra stuff from proxy after calling m() von service implementation...");
	}
}
