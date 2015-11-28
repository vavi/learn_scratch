package com.vavi.spring.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringExtensionLearn implements BeanClassLoaderAware,
		BeanDefinitionRegistryPostProcessor, BeanNameAware, BeanPostProcessor,
		BeanFactoryAware, BeanFactoryPostProcessor, InitializingBean,
		ApplicationContextAware {

	@Override
	public void setBeanName(String name) {
		System.out.println("1.Specified by: setBeanName(...) in BeanNameAware");

	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out
				.println("2.Specified by: setBeanClassLoader(...) in BeanClassLoaderAware");

	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out
				.println("3.Specified by: setBeanFactory(...) in BeanFactoryAware");

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out
				.println("4.Specified by: setApplicationContext(...) in ApplicationContextAware");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out
				.println("5.Specified by: afterPropertiesSet() in InitializingBean");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(
			BeanDefinitionRegistry registry) throws BeansException {
		System.out
				.println("6.Specified by: postProcessBeanDefinitionRegistry(...) in BeanDefinitionRegistryPostProcessor");

	}

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out
				.println("7.Specified by: postProcessBeanFactory(...) in BeanFactoryPostProcessor");

	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out
				.println("Specified by: postProcessBeforeInitialization(...) in BeanPostProcessor");

		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out
				.println("Specified by: postProcessAfterInitialization(...) in BeanPostProcessor");

		return null;
	}

}
