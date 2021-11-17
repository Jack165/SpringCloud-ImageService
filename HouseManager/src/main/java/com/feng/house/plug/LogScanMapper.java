package com.feng.house.plug;

import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class LogScanMapper extends ClassPathBeanDefinitionScanner {

	BeanDefinitionRegistry registry;
	public LogScanMapper(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
		super(registry,useDefaultFilters);
		this.registry=registry;
	}

	@Override
	public Set<BeanDefinitionHolder> doScan(String... basePackages) {
		//使用自定义的加载过滤
		addIncludeFilter(new LogTypeFilter());
		Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
		processBeanDefinitions(beanDefinitions);
		return beanDefinitions;
	}

	private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitions) {
		GenericBeanDefinition definition;
		for (BeanDefinitionHolder holder : beanDefinitions) {
			definition = (GenericBeanDefinition) holder.getBeanDefinition();
			// 设置名称规则已类名称当作bean注入的名称
			definition.getConstructorArgumentValues().addGenericArgumentValue(definition.getBeanClassName());
			// 修改beanClass为LogBeanInterface
			definition.setBeanClass(LogFactoryBean.class);
			definition.setBeanClassName(definition.getBeanClassName());
			definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
			//this.registry.registerBeanDefinition(definition.getBeanClassName(),definition);
		}
	}


}
