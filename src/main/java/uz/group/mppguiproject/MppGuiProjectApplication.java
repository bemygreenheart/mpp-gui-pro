package uz.group.mppguiproject;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uz.group.mppguiproject.ui.CheckoutEntryRecordWindow;
import uz.group.mppguiproject.ui.LoginWindow;

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
			LoginWindow frame = ctx.getBean(LoginWindow.class);
			frame.setVisible(true);
			frame.draw();
		});

	}

}
