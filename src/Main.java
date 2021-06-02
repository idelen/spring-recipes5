import com.apress.springrecipes.shop.object.Cashier;
import com.apress.springrecipes.shop.object.Product;
import com.apress.springrecipes.shop.config.ShopConfiguration;
import com.apress.springrecipes.shop.object.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class Main {

	public static void main(String[] args) throws Exception{
//		ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);

//		SequenceGenerator generator = context.getBean(SequenceGenerator.class);
//
//		System.out.println(generator.getSequence());
//		System.out.println(generator.getSequence());

//		ApplicationContext context = new AnnotationConfigApplicationContext("com.apress.springrecipes.sequence");
//
//		SequenceDao sequenceDao = context.getBean(SequenceDao.class);
//
//		System.out.println(sequenceDao.getNextValue("IT"));
//		System.out.println(sequenceDao.getNextValue("IT"));

		// recipe 2-2
//		ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);
//
//		Product aaa = context.getBean("aaa", Product.class);
//		Product cdrw = context.getBean("cdrw", Product.class);

		// recipe 2-3-3
//		ApplicationContext context = new AnnotationConfigApplicationContext(SequenceConfiguration.class);
//
//		SequenceGenerator generator = context.getBean(SequenceGenerator.class);
//
//		System.out.println(generator.getSequence());
//		System.out.println(generator.getSequence());

//		// recipe 2-5
//		ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);
//
//		Product aaa = context.getBean("aaa", Product.class);
//		Product cdrw = context.getBean("cdrw", Product.class);
//		Product dvdrw = context.getBean("dvdrw", Product.class);
//
//		ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
//		cart1.addItem(aaa);
//		cart1.addItem(cdrw);
//		System.out.println("Shopping cart 1 contains " + cart1.getItems());
//
//		ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);
//		cart2.addItem(dvdrw);
//		System.out.println("Shopping cart 2 contains " + cart2.getItems());
//
//		// add recipe 2.6.2
//		Resource resource = new ClassPathResource("discounts.properties");
//		Properties props = PropertiesLoaderUtils.loadProperties(resource);
//
//		System.out.println("And don't forget our discounts");
//		System.out.println(props);

		//recipe 2.7
		ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

		String alert = context.getMessage("alert.checkout", null, Locale.US);
		String alert_inventory = context.getMessage("alert.inventory.checkout", new Object[] {"[DVD-RW 3.0]", new Date()}, Locale.US);

		System.out.println("The I18N message for alert.checkout is: " + alert);
		System.out.println("The I18N message for alert.inventory.checkout is: " + alert_inventory);

		Cashier cashier = context.getBean(Cashier.class);
		ShoppingCart cart = context.getBean(ShoppingCart.class);
		cashier.checkout(cart);

	}
}
