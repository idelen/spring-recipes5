import com.apress.springrecipes.sequence.SequenceGenerator;
import com.apress.springrecipes.sequence.config.SequenceGeneratorConfiguration;
import com.apress.springrecipes.sequence.domain.SequenceDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);

//		SequenceGenerator generator = context.getBean(SequenceGenerator.class);
//
//		System.out.println(generator.getSequence());
//		System.out.println(generator.getSequence());

		ApplicationContext context = new AnnotationConfigApplicationContext("com.apress.springrecipes.sequence");

		SequenceDao sequenceDao = context.getBean(SequenceDao.class);

		System.out.println(sequenceDao.getNextValue("IT"));
		System.out.println(sequenceDao.getNextValue("IT"));
	}
}
