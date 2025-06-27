Steps to reproduce
1. ./gradlew bootJar
2. java -agentlib:native-image-agent=config-output-dir=./src/main/resources/META-INF/native-image/,experimental-class-define-support -jar ./build/libs/graalvm-0.0.1-SNAPSHOT.jar
3. ./gradlew nativeCompile
4. ./build/native/nativeCompile/graalvm

Stacktrace:
```
Application run failed
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory': org.hibernate.bytecode.spi.BytecodeProvider: org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl Unable to get public no-arg constructor
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1826)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:607)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:529)
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:339)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:373)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:337)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:207)
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:970)
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:627)
        at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146)
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:752)
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:318)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1361)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1350)
        at com.example.graalvm.GraalvmApplicationKt.main(GraalvmApplication.kt:13)
        at java.base@21.0.7/java.lang.invoke.LambdaForm$DMH/sa346b79c.invokeStaticInit(LambdaForm$DMH)
Caused by: java.util.ServiceConfigurationError: org.hibernate.bytecode.spi.BytecodeProvider: org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl Unable to get public no-arg constructor
        at java.base@21.0.7/java.util.ServiceLoader.fail(ServiceLoader.java:586)
        at java.base@21.0.7/java.util.ServiceLoader.getConstructor(ServiceLoader.java:679)
        at java.base@21.0.7/java.util.ServiceLoader$LazyClassPathLookupIterator.hasNextService(ServiceLoader.java:1240)
        at java.base@21.0.7/java.util.ServiceLoader$LazyClassPathLookupIterator.hasNext(ServiceLoader.java:1273)
        at java.base@21.0.7/java.util.ServiceLoader$2.hasNext(ServiceLoader.java:1309)
        at java.base@21.0.7/java.util.ServiceLoader$ProviderSpliterator.tryAdvance(ServiceLoader.java:1491)
        at java.base@21.0.7/java.util.Spliterators$1Adapter.hasNext(Spliterators.java:681)
        at org.hibernate.boot.registry.classloading.internal.AggregatedServiceLoader$ClassPathAndModulePathAggregatedServiceLoader.loadAll(AggregatedServiceLoader.java:123)
        at org.hibernate.boot.registry.classloading.internal.AggregatedServiceLoader$ClassPathAndModulePathAggregatedServiceLoader.getAll(AggregatedServiceLoader.java:112)
        at org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl.loadJavaServices(ClassLoaderServiceImpl.java:241)
        at org.hibernate.bytecode.internal.BytecodeProviderInitiator.initiateService(BytecodeProviderInitiator.java:51)
        at org.hibernate.bytecode.internal.BytecodeProviderInitiator.initiateService(BytecodeProviderInitiator.java:22)
        at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.initiateService(StandardServiceRegistryImpl.java:130)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:263)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:238)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:215)
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.<init>(SessionFactoryBuilderImpl.java:70)
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.<init>(SessionFactoryBuilderImpl.java:47)
        at org.hibernate.boot.internal.DefaultSessionFactoryBuilderService.createSessionFactoryBuilder(DefaultSessionFactoryBuilderService.java:26)
        at org.hibernate.boot.internal.MetadataImpl.getSessionFactoryBuilder(MetadataImpl.java:175)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1513)
        at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:66)
        at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:390)
        at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:419)
        at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:400)
        at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:366)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1873)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1822)
        ... 16 more
Caused by: java.lang.NoSuchMethodException: org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl.<init>()
        at java.base@21.0.7/java.lang.Class.checkMethod(DynamicHub.java:1078)
        at java.base@21.0.7/java.lang.Class.getConstructor0(DynamicHub.java:1241)
        at java.base@21.0.7/java.lang.Class.getConstructor(DynamicHub.java:2442)
        at java.base@21.0.7/java.util.ServiceLoader$1.run(ServiceLoader.java:666)
        at java.base@21.0.7/java.util.ServiceLoader$1.run(ServiceLoader.java:663)
        at java.base@21.0.7/java.security.AccessController.executePrivileged(AccessController.java:114)
        at java.base@21.0.7/java.security.AccessController.doPrivileged(AccessController.java:571)
        at java.base@21.0.7/java.util.ServiceLoader.getConstructor(ServiceLoader.java:674)
        ... 42 more
```
