package uz.group.mppguiproject;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uz.group.mppguiproject.ui.CheckoutBook;
import uz.group.mppguiproject.ui.CheckoutEntryRecord;

import javax.swing.*;
import java.awt.*;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MppGuiProjectApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MppGuiProjectApplication.class)
				.headless(false).run(args);

		EventQueue.invokeLater(() -> {
			CheckoutEntryRecord frame = ctx.getBean(CheckoutEntryRecord.class);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.draw();
		});

	}

}
