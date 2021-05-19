package wbs.pattern.proxy.variante;

public class ServiceImpl implements IService {

	@Override
	public void m() {
		System.out.println("in m() von " + getClass().getSimpleName());
	}
}