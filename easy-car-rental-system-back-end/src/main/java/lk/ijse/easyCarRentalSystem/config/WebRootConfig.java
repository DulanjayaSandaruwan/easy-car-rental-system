package lk.ijse.easyCarRentalSystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 08/07/2022
 **/
@Configuration
@Import(lk.ijse.easyCarRentalSystem.config.JpaConfig.class)
public class WebRootConfig {
}
