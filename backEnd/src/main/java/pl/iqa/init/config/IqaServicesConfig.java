package pl.iqa.init.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"pl.iqa.services", "pl.iqa.repository"})
public class IqaServicesConfig {

}
