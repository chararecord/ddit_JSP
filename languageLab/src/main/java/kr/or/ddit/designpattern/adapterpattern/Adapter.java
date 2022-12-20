package kr.or.ddit.designpattern.adapterpattern;

// adapter pattern = wrapper pattern
public class Adapter implements Target {
	
	private Adaptee adaptee; // adaptee 없이 adapter를 생성할 수 없게 됨
	
	// wrapper instance
	public Adapter(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		adaptee.specificRequest();
	}
}
