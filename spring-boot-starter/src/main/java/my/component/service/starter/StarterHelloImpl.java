package my.component.service.starter;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StarterHelloImpl implements StarterHello {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public StarterHelloImpl() {
		super();
		logger.debug("DONE !!!!");
	}

	@PostConstruct
	public void init() {
		logger.debug("StarterHelloImpl IN init ¤¤¤¤¤¤¤¤¤¤¤¤¤");
		this.sayHello("StarterHelloImpl my friend");
	}

	@Override
	public String sayHello(String _message) {
		logger.debug("StarterHelloImpl IN");
		String message = "StarterHelloImpl Hello : " + _message;
		logger.debug(message);
		return message;
	}

}
