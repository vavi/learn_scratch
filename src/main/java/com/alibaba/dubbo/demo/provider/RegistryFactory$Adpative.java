package com.alibaba.dubbo.demo.provider;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class RegistryFactory$Adpative implements
	com.alibaba.dubbo.registry.RegistryFactory {
    @Override
    public com.alibaba.dubbo.registry.Registry getRegistry(
	    com.alibaba.dubbo.common.URL arg0) {
	if (arg0 == null)
	    throw new IllegalArgumentException("url == null");
	com.alibaba.dubbo.common.URL url = arg0;
	String extName = (url.getProtocol() == null ? "dubbo" : url
		.getProtocol());
	if (extName == null)
	    throw new IllegalStateException(
		    "Fail to get extension(com.alibaba.dubbo.registry.RegistryFactory) name from url("
			    + url.toString() + ") use keys([protocol])");
	com.alibaba.dubbo.registry.RegistryFactory extension = ExtensionLoader
		.getExtensionLoader(
			com.alibaba.dubbo.registry.RegistryFactory.class)
		.getExtension(extName);
	return extension.getRegistry(arg0);
    }
}