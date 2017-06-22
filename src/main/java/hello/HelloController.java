package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static final String template = "New Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public Greeting hello(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/hello1")
    public Greeting goodmorning(@RequestParam(value="name", defaultValue="GoodMorning") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/goodmorning/day")
    private Greeting goodmorningday(@RequestParam() String name){
    	return new Greeting(counter.incrementAndGet(),String.format(template, name+" GoodDay"));
    }
}
