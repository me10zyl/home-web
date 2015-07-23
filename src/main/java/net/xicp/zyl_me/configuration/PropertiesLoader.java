package net.xicp.zyl_me.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class PropertiesLoader {
	@Value("${mybatis.configuration.path}")
	public String mybatisConfigurationPath;
}
