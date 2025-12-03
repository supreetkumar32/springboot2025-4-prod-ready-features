# springboot2025-4-prod-ready-features

devtools
1. in file->build,execution,deployment ->compiler->build project automatically (enable)
2. in file -> advanced settings ->allow auto-make to start even if developed application is currently running.(enable)

Auditing:Auditing in Spring Boot allows you to automatically populate certain
fields, such as creation and modification timestamps, as well as the
user who created or modified the entity.

Steps to add auditing:
1. Create Auditable base Entity using the following annotations
@EntityListeners(AuditingEntityListener.class). This way you will get access to
@CreatedBy, @CreatedDate, @LastModifiedBy, and @LastModifiedDate annotations.
2. Extend all Entities from the Superclass.
3. Create a class and Implement the AuditorAware interface to provide
the current authenticated user from Spring Security.
4. Enable JPA Auditing by adding the @EnableJpaAuditing annotation to
a configuration class.
5. Pass the reference of the AuditorAware class bean to the
@EnableJpaAuditing interface.

Internal working of Auditing:
1. When an entity is persisted or updated, the AuditingEntityListener
triggers and performs the following actions:
a. PrePersist
b. PreUpdate
2. The AuditorAware interface provides the information about the
current user.

@PrePersist is a JPA lifecycle callback annotation used in Spring Boot to execute some logic automatically before an entity is inserted (saved for the first time) into the database.

@PreUpdate is a JPA lifecycle annotation used in Spring Boot that tells JPA to run a specific method automatically BEFORE an entity is updated in the database.

HIBERNATE-ENVERS-MAVEN
1. added the dependency
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-envers</artifactId>
			<version>6.5.2.Final</version>
		</dependency>

2. @Audited
What is @Audited?

@Audited is an annotation from Hibernate Envers used to track historical changes of an entity.

It automatically creates and maintains audit tables that store previous versions of records.

3. @NotAudited
@NotAudited is a Hibernate Envers annotation used to exclude specific fields or relationships from being audited even when the entity is annotated with @Audited.

Springdoc OpenAPI
Springdoc OpenAPI is a library that simplifies integration of Swagger
UI and OpenAPI 3 into Spring Boot applications, allowing you to
automatically generate API documentation from your Spring MVC
endpoints. Here’s how you can set it up,
<dependency>
<groupId>org.springdoc</groupId>
<artifactId>springdoc-openapi-starter-webmvcui</artifactId>
<version>2.5.0</version>
</dependency>

Access the api-doc here: localhost:8080/v3/api-docs
access the swagger-ui here: localhost:8080/swagger-ui/index.html





